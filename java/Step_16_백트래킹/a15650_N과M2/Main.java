/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15650
 	문제번호 : 15650
 	알고리즘 : 백트래킹
*/
package Step_16_백트래킹.a15650_N과M2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * 숫자 nCr 의 조합 문제인거같은데 맞나?
	 * 순열과 달리 중복을 허용함. n만큼의 visited[] 배열을만들고 방문여부를 기억한다.
	 * r크기 만큼의 최종 출력할 조합의수 arr[]을 만들고 값을 저장하는데
	 * prev 값을 기억하고 있는다. 다음에 올 값은 전에 입력한 값인 prev보다 커야함.
	 * dfs로 재귀call 하면서 목표 depth만큼 도달했다면 값을 출력하고 return 함.
	 */

class DFSInfo {
	int N;
	int targetDepth;			// dfs가 최종적으로 도달할 깊이
	boolean[] visited = null;	// 숫자를 선회하면서, 숫자 방문여부를 기억한다.
	int[] arr = null;			// 출력할 조합 저장
	int prev = 0;				// arr[] 배열에 최근에 put된 값을 기억하고 있음

	DFSInfo(int N, int M) {
		this.N = N;
		targetDepth = M;
		visited = new boolean[N+1];
		arr = new int[M];
	}
}

class Main {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public void dfs(DFSInfo dfsInfo, int nowDepth) throws IOException {
		if(dfsInfo.targetDepth == nowDepth) {	// 목표 깊이까지 도달했다면 출력하고 되돌아감.
			for(int v : dfsInfo.arr) {
				bw.write(v + " ");
			}
			bw.write("\n");
			return;
		}

		// visited[i]가 false인 숫자를 전부 순회하면서 최종적으로 출력할 조합 arr[]에 숫자를 저장한다.
		for(int i = 0; i < dfsInfo.N; i++) {
			if(!dfsInfo.visited[i] && dfsInfo.prev < (i+1)) {
				dfsInfo.visited[i] = true;
				dfsInfo.arr[nowDepth] = i+1;	// i = 0부터시작하기때문에 +1해줘야함
				dfsInfo.prev = i+1;				// dfsInfo.arr[]에 마지막으로 입력된값 기억하고있음
				dfs(dfsInfo, nowDepth+1);		// dfs recursive call
				dfsInfo.visited[i] = false;		// 현재 depth를 방문하지않은 상태로 변경
			}
		}
		dfsInfo.prev = 0;	// for loop가 끝났다면 다음 연산을 위해 prev를 초기화시킴.
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		DFSInfo dfsInfo = new DFSInfo(N, M);

		main.dfs(dfsInfo, 0);

		br.close();
		main.bw.flush();
		main.bw.close();
	}
}