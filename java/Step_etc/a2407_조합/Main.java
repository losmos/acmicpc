/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2407
 	문제번호 : 2407
 	알고리즘 : 수학, 조합론, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a2407_조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 파스칼의 삼각형 사용
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger[][] dp = new BigInteger[n+1][n+1];	// 동적계획법 사용할 배열. 파스칼의 삼각형 규칙을 활용해서 값을 할당할거임
		
		for(int i = 0, range = dp.length; i < range; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0) {	// 조합 nCn = 1 이고, nC0 또한 1이므로, 해당 케이스는 값을 1을 할당해준다.
					dp[i][j] = BigInteger.valueOf(1);
				} else {	// 그 외 는 파스칼의 삼각형 규칙에 따라서 아래와같은 공식 적용.
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}

		br.close();
		bw.write(dp[n][m] + "");
		bw.flush();
		bw.close();
	}
}