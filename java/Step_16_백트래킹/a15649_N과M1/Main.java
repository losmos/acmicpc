/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15649
 	문제번호 : 15649
 	알고리즘 : 백트래킹
*/
package Step_16_백트래킹.a15649_N과M1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * 숫자 nPr 의 순열 문제임.
	 * 중복을 허용하지않기 때문에 n만큼의 visited[] 배열을만들고 방문여부를 기억한다. 순열에서 한번 사용한숫자는 다시 쓰지 않음
	 * r크기 만큼의 최종 출력할 순열 arr[]을 만들고 값을 저장함.
	 * dfs로 재귀call 하면서 목표 depth만큼 도달했다면 값을 출력하고 return 함.
	 */

class DFSInfo {
	int N;	// nPr 순열에서 n 값
	int targetDepth;	// dfs가 최종적으로 도달할 깊이
	boolean[] visited = null;	// 숫자를 선회하면서, 숫자 방문여부를 기억한다.
	int[] arr = null;			// 출력할 순열 저장

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
			for(int v : dfsInfo.arr) {	// 완성된 순열 출력
				bw.write(v + " ");
			}
			bw.write("\n");
			return;
		}

		// visited[i]가 false인 숫자를 전부 순회하면서 최종적으로 출력할 순열 arr[]에 숫자를 저장한다.
		for(int i = 0; i < dfsInfo.N; i++) {
			if(!dfsInfo.visited[i]) {
				dfsInfo.visited[i] = true;
				dfsInfo.arr[nowDepth] = i+1;	// i = 0부터시작하기때문에 +1해줘야함
				dfs(dfsInfo, nowDepth+1);		// dfs recursive call
				dfsInfo.visited[i] = false;		// 현재 depth를 방문하지않은 상태로 변경
			}
		}

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