/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1671
 	문제번호 : 1671
 	알고리즘 : 이분 매칭
*/
package Step_43_이분매칭.a1671_상어의저녁식사;

import java.util.ArrayList;
import java.util.Scanner;

class IO
{
   Scanner scan = new Scanner(System.in);
   
   public int inputN()
   {
      int N = scan.nextInt();
      return N;
   }
   
   public int[][] inputStat(int _N)
   {
      int[][] sharkStat = new int[_N][3];
      for(int i=0; i<_N; ++i)
      {
         sharkStat[i][0] = scan.nextInt();
         sharkStat[i][1] = scan.nextInt();
         sharkStat[i][2] = scan.nextInt();
      }
      
      return sharkStat;
   }
   public void output(int _result)
   {
      System.out.println(_result);
   }
}


class Calc
{
	ArrayList<ArrayList<Integer>> bestDepthSarhkInfoArray = new ArrayList<ArrayList<Integer>>(); 
	
   int[][] sharkStat = null;   // 입력한 상어 능력치
   boolean[] sharkUsed = null;   // 상어의 먹이사슬정보에 사용된 상어index를 true
   int savedIdx = 0;   // for문을 수행하면서 인덱스 n과 n+1 과 비교하기위해서 해당변수에 저장.

   ArrayList<Integer> bestDepthsharkInfo = new ArrayList<Integer>();
   ArrayList<Integer> sharkInfo = null;   //dfs를 돌리면서 먹이사슬정보를 저장할 arraylist
   
   int[][] sharkStatSwapTemp = null;
   
   int chance = 0;
   int stage = 0;
   
   public int run(int[][] _sharkStat)
   {
      sharkStat = _sharkStat;	// 상어 능력치 정보
      
      for(int i=0; i<_sharkStat.length; ++i)
      {
         sharkUsed = new boolean[sharkStat.length];	// visited 체크 배열
         sharkInfo = new ArrayList<Integer>();
         dfs(i);
      }
      
      sharkStatSwapTemp = new int[sharkStat.length - bestDepthsharkInfo.size() + 1][3];
      sharkUsed = new boolean[sharkStatSwapTemp.length];
      
      int t = 0;
      outer : for(int j=0; j<sharkStat.length; ++j)
      {
         for(int y=1; y<bestDepthsharkInfo.size(); ++y)
         {
            if( j== bestDepthsharkInfo.get(y))
            {
               continue outer;
            }
         }
         
         sharkStatSwapTemp[t][0] = sharkStat[j][0];
         sharkStatSwapTemp[t][1] = sharkStat[j][1];
         sharkStatSwapTemp[t][2] = sharkStat[j][2];
         
         t = t+1;
      }
      
      sharkStat = sharkStatSwapTemp;
      
      for(int j=0; j<bestDepthsharkInfo.size(); ++j)
      {
         System.out.println("INDEX_1 : " + bestDepthsharkInfo.get(j));
      }
      
      int tempResult = sharkStat.length;
      bestDepthsharkInfo = new ArrayList<Integer>();
      
      
      stage=2;
      for( int x=0; x<sharkStat.length; ++x)
      {
         sharkUsed = new boolean[sharkStat.length];
         sharkInfo = new ArrayList<Integer>();
         dfs(x);
         
//         // 제일깊은 depth의 상어 먹이사슬정보 저장
//         if(bestDepthsharkInfo.size() == 0 || sharkInfo.size() > bestDepthsharkInfo.size() )
//         {
//            bestDepthsharkInfo = sharkInfo;
//         }
                  
      }
      
      for(int x=0; x<bestDepthsharkInfo.size(); ++x)
      {
         System.out.println("INDEX_2 : " + bestDepthsharkInfo.get(x));
      }
      
      System.out.println("tempResult : " + tempResult);
      System.out.println("bestdepthsharkinfo.size : " + bestDepthsharkInfo.size());
      return tempResult - bestDepthsharkInfo.size() +1;
   }
   
   // dfs돌려서 depth가 가장 깊은 경로에해당하는걸 저장한다.
   // 배열 index번호가 상어번호를 의미.
   // 이미 상어의 먹이사슬선이 이어진 상어들을 또 체크할 필요는 없으므로 이런상어들은 저장해놨다가 for문돌릴때 건너뛴다.
   
   // dfs돌리면서 하나의 사이클이 끝날떄를 체크하는 로직을 추가하고. 이 사이클이끝날떄마다 depth가 깊으면 sharkInfo정보를 갈아치운다.
   public void dfs(int _idx)
   {
      // task: _idx가넘어온 상어index번호부터 먹이사슬 최상위로두고 체크를 시작한다.
      sharkInfo.add(_idx);
      savedIdx = _idx;
      sharkUsed[_idx] = true;
      
      if(bestDepthsharkInfo.size() == 0 || sharkInfo.size() >= bestDepthsharkInfo.size() )
      {
//         bestDepthsharkInfo = sharkInfo;
    	  bestDepthsharkInfo = new ArrayList<>(sharkInfo);
    	  bestDepthSarhkInfoArray.add(bestDepthsharkInfo);
      }
         
//      int depth = 0;
      
      for(int i=0;  i<sharkStat.length; ++i)
      {
         if(sharkUsed[i] == true || savedIdx == i)
         {
            if(sharkInfo.size()>1 &&  i == sharkStat.length-1)
            {
//               sharkUsed[i] = false;
               sharkUsed[sharkInfo.get(sharkInfo.size()-1)] = false;
               sharkInfo.remove(sharkInfo.size()-1);
               savedIdx = sharkInfo.get(sharkInfo.size()-1);
            }
            
            continue;
         }
         
         if(canEatCheck(sharkStat[savedIdx], sharkStat[i]))
         {
            dfs(i);
         }
         
         if(sharkInfo.size()>1 &&  i == sharkStat.length-1)
         {
            sharkUsed[sharkInfo.get(sharkInfo.size()-1)] = false;
            sharkInfo.remove(sharkInfo.size()-1);
            savedIdx = sharkInfo.get(sharkInfo.size()-1);
         }
      }
   }
   
   public boolean canEatCheck(int[] _shark1, int[] _shark2)
   {
	   
	   if(stage != 2)
	   {
		   if(_shark1[0] > _shark2[0] && _shark1[1] > _shark2[1] && _shark1[2] > _shark2[2])
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	   }
	   else
	   {
		   if(_shark1[0] >= _shark2[0] && _shark1[1] >= _shark2[1] && _shark1[2] >= _shark2[2])
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }

	   }
	   
	   
	   
	   
//	   if(_shark1[0] == _shark2[0] && _shark1[1] == _shark2[1] && _shark1[2] == _shark2[2])
//      {
//		   chance = chance+1;
//      }
//	   
//      if(_shark1[0] > _shark2[0] && _shark1[1] > _shark2[1] && _shark1[2] > _shark2[2])
//      {
//         return true;
//      }
//      else
//      {
//         return false;
//      }
   }
}


public class Main {

   // 첫째줄 상어의 마리수 N
   // 둘쨰줄부터 각 상어의 크기, 속도, 지능정보
   // 상어정보는 2차원배열에다가 입력받는다.
   
	
	/*
	 * 반례
	 * 
	 * 
	 	5
		5 5 5
		5 5 5
		4 3 3
		3 4 3
		3 3 4
		
		result :1
	 */
   public static void main(String args[])
   {
      IO io = new IO();
      Calc calc = new Calc();
      
      
      int N = io.inputN();
      int [][] sharkStat = io.inputStat(N);
      
      int result = calc.run(sharkStat);
      io.output(result);
   }
}