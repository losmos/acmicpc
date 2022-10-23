/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9663
 	문제번호 : 9663
 	알고리즘 : 브루트포스 알고리즘, 백트래킹
*/
package Step_15_백트래킹.a9663_NQueen;

import java.util.ArrayList;
import java.util.Scanner;

class IO {
	Scanner scan = new Scanner(System.in);
	
	public int input()
	{
		int N = scan.nextInt();
		
		return N;
	}
}

class Calc{
	
	int N = 0;
	boolean[] checkBoard = null;
	int resultCnt = 0;
	int yLastQueen = -10;
	
	int tempYval = -10; 
	
	ArrayList<Integer> tempAr = new ArrayList<Integer>();	// nQueen 위치 출력용
	
	public int calc(int _N)
	{
		N = _N;
		checkBoard = new boolean[_N];
		nQueen(0);
		
		return resultCnt;
		
	}
	
	public void nQueen(int _Yval)
	{
		if(_Yval > tempYval)
		{
			tempYval = _Yval;	//_Yval > tempYval 일경우는 체스판 다음 행으로 이동해서 진입한 case.
		}
		else if (tempYval > _Yval)
		{
			tempYval = _Yval +1 ;	//tempYval > _Yval 일경우는 체스판 다음 행에서 까꾸로 돌아온 case.
		}
		
		int lastNqueen = -10;
		
		for( int i = 0; i < N; i++)
		{
			if(_Yval == 0)
			{
				yLastQueen = -10;
//				if(tempAr.size() > 0)
//					tempAr.remove(0);
//				lastNqueen = -10;
//				checkBoard[0] = false;  
			}
			
//			if(checkBoard[i] == false && i != (yLastQueen -1) && (i != yLastQueen +1))
			if(checkBoard[i] == false && (_Yval == 0 || ddd(i, tempAr, _Yval)?true : false) )
			{
				if(lastNqueen != -10)
				{
					checkBoard[lastNqueen] = false;  
					tempAr.remove(tempAr.size()-1);	// nQueen 위치 출력용
					tempYval = _Yval;
					lastNqueen = -10;
					
					if(tempAr.size() -1 > 0)
					{
						yLastQueen = tempAr.get(tempAr.size()-2);
					}
					else
					{
						yLastQueen = -10;
					}
				}
				
				
				tempAr.add(i);	// nQueen 위치 출력용
				yLastQueen = tempAr.get(tempAr.size()-1);
				checkBoard[i] = true;
				lastNqueen = i;
				
				if(_Yval == N-1)
				{
					resultCnt ++;
					
					// nQueen 위치 출력용
					/*
					String resultStr = "";
					for(int x=0; x<tempAr.size(); x++)
					{
						resultStr = resultStr + tempAr.get(x) + "";
					}
					System.out.println("RESULT : " + resultStr);
					*/
					
				}
				else
				{
//					yLastQueen = lastNqueen;
					nQueen(_Yval+1);
					/*
					 * if(lastNqueen != -10) { checkBoard[lastNqueen] = false;
					 * tempAr.remove(tempAr.size()-1); // nQueen 위치 출력용 lastNqueen = -10; }
					 */
				}
				
			}

			if(i == N-1)
			{
				if(lastNqueen != -10)
				{
					checkBoard[lastNqueen] = false;
					tempAr.remove(tempAr.size()-1);	// nQueen 위치 출력용
					tempYval = _Yval;
					if(tempAr.size() -1 > 0)
					{
						yLastQueen = tempAr.get(tempAr.size()-2);
					}
					else
					{
						yLastQueen = -10;
					}
				}
			}
			
		}
	}
	
	public boolean ddd(int _i, ArrayList<Integer> _tempAr, int _Yval)
	{
		for(int i=0; i<_tempAr.size(); i++)
		{
			if(tempYval > _Yval)
			{
				if(_tempAr.size()-2-i >= 0)
				{
					if(_i == _tempAr.get(_tempAr.size()-2-i) -i-1 || _i == _tempAr.get(_tempAr.size()-2-i) +i+1 )
					{
						return false;
					}
					
				}
			}
			else
			{
				if(_i == _tempAr.get(_tempAr.size()-1-i) -i-1 || _i == _tempAr.get(_tempAr.size()-1-i) +i+1 )
				{
					return false;
				}
			}
			
		}
		
		return true;
	}
	
}


public class Main {
	
	public static void main(String args[])
	{
		IO io = new IO();
		Calc calc = new Calc();
		
		int N = io.input();
		int result = calc.calc(N);
		
		System.out.println(result);
		
	}
		
}