/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15651
 	문제번호 : 15651
 	알고리즘 : 백트래킹
*/
package Step_15_백트래킹.a15651_N과M3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * 재귀call 할때마다, for문 처음부터 돌면서 i값을 하나하나 할당해주면 된다. 간단한 문제
	 */
class Main {

	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public void dfs(int[] arr, int nowDepth, int N, int M) throws IOException{
		if(nowDepth == M) {		// 출력조건. depth가 목표한 depth에 도달하면 출력함
			for(int v : arr) {
				bw.write(v + " ");
			}
			bw.write("\n");
			return;
		}

		for(int i = 0; i < N; i++) {
			arr[nowDepth] = i+1;	// arr에 값 할당
			dfs(arr, nowDepth + 1, N, M);	// 재귀 call 하면서 depth를 +1 해준다.
		}
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];	// 출력할 숫자 저장할 배열
		main.dfs(arr, 0, N, M);	// dfs 재귀call 시작

		br.close();
		main.bw.flush();
		main.bw.close();
	}
}