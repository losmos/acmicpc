/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9095
 	문제번호 : 9095
 	알고리즘 : 다이나믹 프로그래밍
*/

package Step_etc.a9095_1_2_3더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * DP는 정말 계속풀어봐도 점화식구하기가 쉽지가않다.
 * 
 * 참고사이트 : https://dnf-lover.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-9095%EB%B2%88-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-DP-%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-JAVA
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];	// dp 점화식
		}

		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}