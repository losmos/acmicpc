/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11376
 	문제번호 : 11376
 	알고리즘 : 이분 매칭
*/
package Step_43_이분매칭.a11376_열혈강호2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class IO {
	Scanner scan = new Scanner(System.in);
	
	public int input()
	{
		return scan.nextInt();
	}
	
	public void output(int[] _result)
	{
		int resultCnt = 0;
		
		for(int i=0; i<_result.length; ++i)
		{
			if(_result[i] != -1)
			{
				resultCnt += 1;
			}
		}
		
		System.out.println(resultCnt);
	}
}

class Calc{
	
	int[] matching = null;
	ArrayList<Integer>[] worker = null;	//일할수있는 정보
	boolean[] visited = null; 
	public int[] run(ArrayList<Integer>[] _worker, int _N, int _M)
	{
		visited = new boolean[_N];
		matching = new int[_M];	// 간선이 연결된 정점
		
		for(int z=0; z<_M; ++z)
		{
			matching[z] = -1;
		}
		worker = _worker;
		
		for(int i=0; i<_N; ++i)
		{
			for(int j=0; j<2; ++j)
			{
				Arrays.fill(visited, false);
				dfs(i);
			}
		}
		
		return matching;
	}
	
	// return true : 간선연결 성공, return false : 간선연결 실패
	public boolean dfs(int _index)
	{
		if(visited[_index] == true)
			return false;
		
		visited[_index] = true;
		
		for(int i=0; i<worker[_index].size(); ++i)
		{
			int visitVal = worker[_index].get(i) -1;
			
			
			// 연결된 간선이 없을경우 간선 연결.
			if(visitCheck(visitVal) == false)
			{
				matching[visitVal] = _index;
				
				return true;
			}
			else if(visitCheck(visitVal) == true)	// 간선연결이가능하고
			{
				
				boolean result = dfs(matching[visitVal]);	// dfs 호출로 밀어내기 시도
				if(result)
				{
					matching[visitVal] = _index;
					
					return true;
				}
				
			}
			
		}
			
		
		return false;
	}
	
	public boolean visitCheck(int _index)
	{
		if(matching[_index] == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
}


public class Main {
	
	// 01. 입력 첫줄 직원수 N, 일의 개수 M
	// 02. 둘쨰줄부터 N번만큼 반복하여 i번째 직원이 할 수 있는 일의 개수, 할 수 있는 일의번호 입력
	// 03. index : i 에대해 순차적으로 할수있는 일(번호)에 간선을 연결, N : M 간의 이분매칭 ㄱㄱ 
	
	public static void main(String args[])
	{
		IO io = new IO();
		int N = io.input();
		int M = io.input();
		
		ArrayList<Integer>[] worker = new ArrayList[N];
		
		for(int i=0; i<N; ++i)
		{
			worker[i] = new ArrayList<Integer>();
			int work = io.input();
			for(int j=0; j<work; ++j)
			{
				int temp = io.input();
				worker[i].add(temp);
			}
		}
		
		Calc calc = new Calc();
		int[] result = calc.run(worker, N, M);
		
		io.output(result);
	}
}