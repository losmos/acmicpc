/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11660
 	문제번호 : 11660
 	알고리즘 : 다이나믹 프로그래밍, 누적 합
*/
package Step_18_누적합.a11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 각 행 기준으로 dp값을 구한다.
 * 그 dp값을 가지고 주어지는 구간(x1,x2 ~ y1,y2)에대한 누적합을 구한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][N+1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());	// 누적합
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = 0;
			for(int j = x1; j <= x2; j++) {
				sum += dp[j][y2] - dp[j][y1-1];	// 지정된 범위의 누적합 구하기
			}

			sb.append(sum).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.flush();
	}
}