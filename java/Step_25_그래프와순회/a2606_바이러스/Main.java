/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2606
 	문제번호 : 2606
 	알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
*/
package Step_25_그래프와순회.a2606_바이러스;


import java.util.Scanner;

class IO {
	Scanner scan = new Scanner(System.in);
	
	public int inputN()
	{
		int N = scan.nextInt();
		
		return N;
	}
	
	public int inputLoopN()
	{
		int loopN = scan.nextInt();
		
		return loopN;
	}
	
	public int[][] inputConnInfo(int _N, int _loopN)
	{
		int[][] connInfo = new int[_N][_N];
		int tempInt1 = 0; 
		int tempInt2 = 0; 
		
		for(int i=0; i<_loopN; ++i)
		{
			tempInt1 = scan.nextInt();
			tempInt2 = scan.nextInt();
			
			connInfo[tempInt1-1][tempInt2-1] = 1;	//default값인 0은 비연결, 1은 연결상태를 의미, -1해주는이유는 n번째인덱스와 n+1컴퓨터번호와 매핑되기 때문
			connInfo[tempInt2-1][tempInt1-1] = 1;
			
		}
		
		return connInfo;
	}
	
	public void output(int _result)
	{
		System.out.println(_result);
	}
}

class Calc{
	
	boolean[] visited = null;
	int[][] connInfo = null;
	int result = 0;
	
	public int run(int[][] _connInfo, int _N)
	{
		visited = new boolean[_N];	// default : false
		connInfo = _connInfo;
		dfs(0);
		
		return result;
	}
	
	public void dfs(int _idx)
	{
		visited[_idx] = true;
		
		for(int i=0; i<connInfo.length; i++)
		{
			if(connInfo[_idx][i] == 1 && visited[i] == false)
			{
				result ++;
				dfs(i);
			}
		}
	}
}


public class Main {
	
	// 첫번째 줄에는 컴퓨터수  N input
	// 두번째 줄에는  conn 되어있는 컴퓨터쌍 개수
	// 세번째줄부터 N번만큼 loop돌리면서 conn정보
	public static void main(String args[])
	{
		IO io = new IO();
		int N = io.inputN();
		int loopN = io.inputLoopN();
		int[][] connInfo = io.inputConnInfo(N, loopN);
		
		Calc calc = new Calc();
		int result = calc.run(connInfo, N);
		io.output(result);
	}
		
}