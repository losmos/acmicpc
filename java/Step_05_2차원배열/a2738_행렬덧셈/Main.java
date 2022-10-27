/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2738
 	문제번호 : 2738
 	알고리즘 : 수학, 구현
*/
package Step_05_2차원배열.a2738_행렬덧셈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int [N][M];
		int[][] B = new int [N][M];

		// 행렬 A 입력받음
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행렬 B 입력받으면서 동시에 A와 더한값 StringBuilder에 append 해줌
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());

				sb.append(A[i][j] + B[i][j]).append(" ");
			}
			sb.append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}