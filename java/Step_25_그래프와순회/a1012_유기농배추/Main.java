/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1012
 	문제번호 : 1012
 	알고리즘 : 래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
*/
package Step_25_그래프와순회.a1012_유기농배추;

import java.util.Scanner;

class IO {
	Scanner scan = new Scanner(System.in);
	
	// Input TestCase
	public int inputT()
	{
		int T = scan.nextInt();
		return T;
	}
	
	// Input CabbageField Info
	public int[][] inputCabbageFieldInfo()
	{
		int xLen = scan.nextInt();
		int yLen = scan.nextInt();
		
		int[][] cabbageField = new int[xLen][yLen];
		
		return cabbageField;
		
	}
	
	// Input Number Of Cabbage
	public int inputCabbageInfo()
	{
		int numOfCabbage = scan.nextInt();
		return numOfCabbage;
	}

	// Update Cabbage Field Info
	public int[][] updateCabaggeFieldInfo(int _T, int[][] _cabbageField)
	{
		int x = 0;
		int y = 0;
		
		for(int i=0; i<_T; ++i)
		{
			x = scan.nextInt();
			y = scan.nextInt();
			
			_cabbageField[x][y] = 1;
		}
		
		return _cabbageField;
	}
	
	public void output(int[] _result)
	{
		for(int i=0; i<_result.length; ++i)
		{
			System.out.println(_result[i]);
		}
	}
}

class Calc{
	
	int[][] cabbageField = null;
	boolean[][] visitedField = null;
	int[] dx = {0,0,-1,1};
	int[] dy = {-1,1,0,0};
	boolean cabbageYN = false;
	int count = 0;
	
	public int run(int[][] _cabbageField, boolean[][] _visitedField)
	{
		cabbageYN = false;
		count = 0;
		
		cabbageField = _cabbageField;
		visitedField = _visitedField;
		
		for(int i=0; i<cabbageField.length; ++i)
		{
			for(int j=0; j<cabbageField[0].length; ++j)
			{
				cabbageYN = false;
				dfs(i,j);	// dfs start
				
				if(cabbageYN)
				{
					count += 1;
				}
			}
		}
		
		return count;
		
	}
	
	public void dfs(int _x, int _y)
	{
		if(CheckVisitedCabbage(_x, _y))
		{
			return;
		}
		
		visitedField[_x][_y] = true;
		if(cabbageField[_x][_y] == 1)
		{
			cabbageYN = true;
		}
		else
		{
			return;
		}
		
		int x = 0;
		int y = 0;
		
		//현재 좌표로부터 상하좌우 4방향에대한 배추존재유무 검사
		for(int i=0; i<4; ++i)
		{
			x = _x + dx[i];
			y = _y + dy[i];
			
			// x,y 좌표가 배추밭을 벗어나거나, 이미 방문한적이 있을경우 continue
			if(CheckVisitedCabbage(x, y))
			{
				continue;
			}
			
			if(cabbageField[x][y] == 1)
			{
				cabbageYN = true;
				dfs(x,y);	// recursive call
			}
			else
			{
				visitedField[x][y] = true;
			}
		}
	}
	
	public boolean CheckVisitedCabbage(int _x, int _y)
	{
		if(_x < 0 || _y < 0 || _x >= cabbageField.length || _y >= cabbageField[0].length || visitedField[_x][_y])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}


public class Main {
	
	// 01. 입력 첫줄 테스트케이스 T 입력
	// 02. 입력 둘째줄은 배추밭의 가로길이, 세로길이, 배추개수 순서대로 입력
	// 03. 배추 좌표 입력
	// 04. 테스트케이스 T >= 2 라면, 02 ~ 03번사항을 T만큼 반복
	public static void main(String args[])
	{
		int T = 0;
		int[][] cabbageField = null;
		boolean[][] visitedField = null;
		int numOfCabbage = 0;
		
		IO io = new IO();
		Calc calc = new Calc();
		
		T = io.inputT();
		int[] resultArr = new int[T];
		
		for(int i=0; i<T; ++i)
		{
			cabbageField = io.inputCabbageFieldInfo();
			visitedField = new boolean[cabbageField.length][cabbageField[0].length];
			numOfCabbage = io.inputCabbageInfo();
			cabbageField = io.updateCabaggeFieldInfo(numOfCabbage, cabbageField);
			
			int result = calc.run(cabbageField, visitedField);
			resultArr[i] = result;
		}
		
		io.output(resultArr);
		
	}
}