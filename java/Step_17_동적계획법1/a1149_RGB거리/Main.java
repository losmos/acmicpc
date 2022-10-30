/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1149
 	문제번호 : 1149
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a1149_RGB거리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 
 * 아래 테스트케이스는 
 * 첫번째집을 R로 칠하는 비용 :26, 첫번째집을 G로 칠하는 비용 : 40, 첫번째집을 B로 칠하는비용 : 83
 * 두번째집을 R로 칠하는 비용 :49, 두번째집을 G로 칠하는 비용 : 60, 첫번째집을 B로 칠하는비용 : 57
 * 세번째집을 R로 칠하는 비용 :13, 세번째집을 G로 칠하는 비용 : 89, 세번째집을 B로 칠하는비용 : 99
 * 을 의미한다.
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 * 
 * N = 1일때 집을 칠할 수 있는 경우의 수는
 * R / G / B
 * 
 * N = 2일때 집을 칠할 수 있는 경우의 수는
 * R,G / R,B
 * G,R / G,B
 * B,R / B,G
 * 
 * N = 3일떄 집을 칠할 수 있는 경우의 수는
 * R,G,R / R,G,B / R,B,R / R,B,G
 * G,R,G / G,R,B / G,B,G / G,B,R
 * B,R,B / B,R,G / B,G,B / B,G,R 이다.
 * 
 * 문제는 경우의수를 찾는것이 아니고, 페인트를 칠하는 비용의 경우의수중, 가장 최소값을 찾는것.
 * 
 * 패턴을보면 대충 점화식을 세울수있는데
 * N=3일때 R로시작하는경우, N=2일때 R로시작하지않는 모든 경우의 수의 비용중 최소값을 택하고 거기에 N=3일때 R의 페인트칠하는 비용을 더해주면 된다.
 * 다시말해서 N=2일때의 G,R / G,B vs B,R / B,G의 경우 비용 중 최소값 + N=3일때 R을칠하는비용 과 같다.
 * 
 * 위에 내용을 다시 숫자로 치환해서 적어보면
 * R,G,B를 각각 숫자 0,1,2으로 치환하고
 * N=3일때 0번으로시작하는 비용의 최소값은 N=2일때 1번으로 시작하는 비용 vs 2번로 시작하는 비용중 최소값을 택, 거기에 N=3일때 0을칠하는 비용을 더한것과 같다.
 * 다시말해서 N=2일때의 1,0 / 1,2 비용 vs 2,0 / 2,1의 경우 비용 중 최소값 + N=3일때 0을칠하는비용 과 같다. (== dp[3][0] = Math.min(dp[2][1],dp[2][2]) + rgb[3][0]; ) 
 * 
 * 2차원배열 dp[i][j]를 만들어서 i에는 N값이 들어가고 N일때의 j(1,2,3인경우 즉 R,G,B의 경우의)을 구해주며 dp해주면 될듯.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] rgb = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		// 페인트 칠하는비용 정보를 rgb배열에 담는다.
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				// 칠하는 비용값
				// 예를들면, rgb[1][2]는, N=1일때 B(2)를 칠하는비용의 값을 의미한다.
				rgb[i][j] = Integer.parseInt(st.nextToken());	
			}
		}

		// dp N=1일때의 RGB 초기화.
		dp[1][0] = rgb[1][0];	// R을 0으로 치환하였다. 0 이 R이다.
		dp[1][1] = rgb[1][1];	// G을 1으로 치환하였다. 1 이 G이다.
		dp[1][2] = rgb[1][2];	// B을 2으로 치환하였다. 2 이 B이다.

		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				dp[i][j] += Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]) + rgb[i][j]; // ex) dp[2][1] = Math.min(dp[1][0],dp[1][2]) + rgb[2][1];
			}
		}

		br.close();
		bw.write(String.valueOf(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2])));	// dp[N][?]의 최소값
		bw.flush();
		bw.close();
	}
}