/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15652
 	문제번호 : 15652
 	알고리즘 : 백트래킹
*/
package Step_15_백트래킹.a15652_N과M4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * 여타 N과M 문제랑 비슷한데, prev값에 arr[]배열에 last로 들어간 값을 기억하고 있다가, 그것보다 작은수는 무시하면됨.
	 */
class DFSInfo {
	int N;
	int M;
	int[] arr;
	int prev = 0;

	DFSInfo(int N, int M) {
		this.N = N;
		this.M = M;
		arr = new int[M];
	}
}
class Main {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public void dfs(DFSInfo dfsInfo, int nowDepth) throws IOException{
		if(nowDepth == dfsInfo.M) {		// 출력조건. depth가 목표한 depth에 도달하면 출력함
			for(int v : dfsInfo.arr) {
				bw.write(v + " ");
			}
			bw.write("\n");
			return;
		}

		for(int i = 0; i < dfsInfo.N; i++) {
			if(i+1 < dfsInfo.prev) {	// 문제의 비내림차순 조건을 만족하기위해. arr에 저장할 숫자가 last로 저장한값보다 작을경우에는 continue
				continue;
			}
			dfsInfo.arr[nowDepth] = i+1;	// arr에 값 할당
			dfsInfo.prev = i+1;				// arr에 할당한 last값 저장
			dfs(dfsInfo, nowDepth + 1);		// 재귀 call 하면서 depth를 +1 해준다.
		}

		dfsInfo.prev = 0;	// prev 값 초기화
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		DFSInfo dfsInfo = new DFSInfo(N, M);
		main.dfs(dfsInfo, 0);	// dfs 재귀call 시작

		br.close();
		main.bw.flush();
		main.bw.close();
	}
}