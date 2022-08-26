/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1671
 	문제번호 : 1671
 	알고리즘 : 이분 매칭
*/
package Step_43_이분매칭.a1671_상어의저녁식사.failed02;

import java.util.Scanner;

class IO
{
   Scanner scan = new Scanner(System.in);
   
   public int inputN()
   {
	   int N = scan.nextInt();
	   return N;
   }
   
   public int[][] inputSharkStat(int _N)
   {
	   int sharkStat[][] = new int[_N][3];
	   
	   for(int i=0; i<_N; ++i)
	   {
		   int size = scan.nextInt();
		   int speed = scan.nextInt();
		   int intel = scan.nextInt();
		   
		   sharkStat[i][0] = size;
		   sharkStat[i][1] = speed;
		   sharkStat[i][2] = intel;
	   }
	   
	   return sharkStat;
   }
   
   public void output(boolean[] _deadShark)
   {
	   int resultCnt = 0;
	   
	   for(int i=0; i<_deadShark.length; ++i)
	   {
		   if(_deadShark[i] == false)
		   {
			   resultCnt ++;
		   }
	   }
	   
	   System.out.print(resultCnt);
   }
}


class Calc
{
	int[][] sharkStat = null;
	boolean[][] visited = null;	// 밀어내기 당했을 경우, 기존에 가지고있던 정점 index를 true로 함. 추후 이분매칭 dfs돌리면서 true값의 index는 건너뜀
	int[] sharkEatMatching = null;		// 먹을 상어 index 저장
	int[] sharkBeEatenMatching = null;	// 잡아먹는 무서운 상어 index 저장
	int N = 0;
	boolean[] deadShark = null;
	int stage = 0;
	boolean[] skipIdx = null;
	
	public void clearMatchingInfo()
	{
		for(int i=0; i<N; ++i)
		{
			sharkEatMatching[i] = -1;		// -1로 초기화
			sharkBeEatenMatching[i] = -1;	// -1로 초기화
		}
	}
	
	public boolean[] run(int[][] _sharkStat, int _N)
	{
		N = _N;
		sharkStat = _sharkStat;
		visited = new boolean[_N][_N];
		sharkEatMatching = new int [_N];
		sharkBeEatenMatching = new int [_N];
		deadShark = new boolean[N];
		skipIdx = new boolean [_N];
		
		stage = 1;
		
		clearMatchingInfo();
		
		for(int i=0; i<_N; ++i)
		{
			bipartiteMatching(i);
		}
		
		stage = 2;
//		for(int x=0; x<skipIdx.length; ++x)
//		{
//			if(sharkBeEatenMatching[x] != -1)
//			{
//				skipIdx[x] = true;
//			}
//		}
		
//		clearMatchingInfo();
		
		for(int j=0; j<_N; ++j)
		{
			if(stage == 2 && skipIdx[j])
			{
				continue;
			}
			
			bipartiteMatching(j);
		}
		
		return deadShark;
	}
	
	// 01. loop문 돌리면서 각 index 별로 dfs 돌려서 매칭시켜준다.
	// 02. 다음 index상어가 기존 상어의 정점대상이라면 
	//  - 기존상어가 다른 정점을 맺을 수 있는지 체크한다.
	//  - 다른정점을 맺을 수 있다면 그 정점에 매칭시키고, 밀어냈던 상어의 정점은 기존상어의 정점에 맺어준다.
	//  - 만일 밀어내기에실패하면 다음 index의 이분매칭 검사로 넘어간다.
	public boolean bipartiteMatching(int _index)	// by dfs
	{
		for(int i=0; i<N; ++i)
		{
			if(stage == 2 && skipIdx[i])
			{
				continue;
			}
			
			if(i == _index || visited[_index][i])
			{
				continue;	// 자기자신을 먹을수있을지없을지 비교할필요는 없으므로, 밀어내기 당했던 번호는 검사 할 필요 없으므로 continue
			}
			
			if(canEatCheck(_index, i))	// _index -> i 를 먹을 수 있다면
			{
				if(sharkBeEatenMatching[i] == -1)
				{
					sharkEatMatching[_index] = i ;		// _index 상어가 _i 를 먹을 수 있음
					sharkBeEatenMatching[i] = _index;	// _i상어가 _index상어에게 먹힐 수 있음
					deadShark[i] = true;				// i 상어 으앙쥬금
					if(stage==1)
						skipIdx[i] = true;
					
					return true;
				}
				else	// 먹을순 있지만, 다른 상어놈이 이미 먹이로 선점해놨을경우(밀어내기 시도)
				{
					int tempIdx = sharkBeEatenMatching[i];
					visited[tempIdx][i] = true;
					if(bipartiteMatching(tempIdx))	// 밀어내기 성공
					{
						sharkEatMatching[_index] = i;
						sharkBeEatenMatching[i] = _index;
						deadShark[i] = true;		// i 상어 으앙쥬금
						if(stage==1)
							skipIdx[i] = true;
						
						return true;
					}
					else
					{
						visited[tempIdx][i] = false;
					}
				}
			}
			
		}
		
		return false;
	}
	
	public boolean canEatCheck(int _index, int _i)
	{
		if(stage == 1)
		{
			if( sharkStat[_index][0] == sharkStat[_i][0] && 
					sharkStat[_index][1] == sharkStat[_i][1] && 
					sharkStat[_index][2] == sharkStat[_i][2]
			  )
			{
				return false;
			}
			
			if( sharkStat[_index][0] >= sharkStat[_i][0] && 
					sharkStat[_index][1] >= sharkStat[_i][1] && 
					sharkStat[_index][2] >= sharkStat[_i][2]
			  )
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
			if( sharkStat[_index][0] >= sharkStat[_i][0] && 
					sharkStat[_index][1] >= sharkStat[_i][1] && 
					sharkStat[_index][2] >= sharkStat[_i][2]
			  )
			{
				
				if( sharkStat[_index][0] == sharkStat[_i][0] && 
						sharkStat[_index][1] == sharkStat[_i][1] && 
						sharkStat[_index][2] == sharkStat[_i][2]
				  )
				{
					if(deadShark[_index] == true
//							&& sharkEatMatching[_i] == _index && sharkBeEatenMatching[_index] == _i
							)
					{
						return false;
					}
					else
					{
						return true;
					}
				}
//					
//				if(sharkEatMatching[_i] == _index && sharkBeEatenMatching[_index] == _i)
//				{
//					return false;
//				}
				
				return true;
			}
			else
			{
				return false;
			}

		}
		
	}
	
}


public class Main_failed_02 {

	// 01. 첫째줄 상어의 마리수 N
	// 02. 둘쨰줄부터 각 상어의 크기, 속도, 지능정보 입력
	// 03. 상어정보는 2차원배열에다가 입력받는다.
	// 04-1. dfs & 이분매칭을통해 최대 매칭을 구한다.
	//  - 기존에는 이분매칭없이 dfs로만 canEat 체크를해줘서 반례가생겨버렸었다... 삽질 좋아 ^^^^^
	// 04-2. eat 메소드 호출.
	// 04-3. dfs & 이분매칭 한번더 수행
	// 05. 남은 생존상어 counting
	
	public static void main(String args[])
	{
		int N = 0;
		int [][] sharkStat = null;
		boolean[] deadShark = null;
		
		IO io = new IO();
		Calc calc = new Calc();
		
		N = io.inputN();
		sharkStat = io.inputSharkStat(N);
		deadShark = calc.run(sharkStat, N);
		io.output(deadShark);
		
	}
}