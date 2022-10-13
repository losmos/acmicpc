/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9184
 	문제번호 : 9184
 	알고리즘 : 다이나믹 프로그래밍, 재귀
*/
package Step_16_동적계획법1.a9184_신나는함수실행;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * [문제풀이 컨셉]
 * 재귀 > 메모이제이션 방식으로 변경
 */
public class Main {

	public int getDpV(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if(a > 20 || b > 20 || c > 20) {
			a = 20; b = 20; c = 20;
		}

		int [][][]dp = new int[a+1][b+1][c+1];

		for(int i = 0; i <= a; i++) {
			for(int j = 0; j <= b; j++) {
				for(int k = 0; k <= c; k++) {
					if(i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 1;
					} else if(i < j && j < k) {
						dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
					} else {
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
					}
				}
			}
		}

		return dp[a][b][c];
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			sb.append(main.getDpV(a, b, c)).append("\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}