/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2156
 	문제번호 : 2156
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a2156_포도주시식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * dp문제를 연속으로 풀어서 그런지, 이번문제 점화식 세우는거는 별로 어렵지 않았다.
 * ex) 6 10 13 9 8 1
 * 
 * n=1일때는 6을 고르면된다.
 * n=2일때는 6, 10을 고르면 된다.
 * n=3일때는 6, 13을 고르거나 6,10을 골라야 된다.
 * n=4일때는 dp[1] + wine[3] + wine[4] 해주거나  dp[2] + wine[4]을 더해주면 된다.
 * ...
 * n일때 dp[n] = Math.max(dp[n-1], dp[n-2]) + wine[n];
 * 
 * 추가+)
 * i번째 포도주잔을 반드시 선택할필요는 없음. 선택하지않고 skip할수도있기때문에 이런 로직을 추가해야함.
 * 따라서 Math.max(dp[n-1], dp[n-2]) + wine[n] 여기에다가 dp[n-1] 둘중 더큰 max값을 취하는 로직도 들어가야함. (dp[n-1]을 선택한다는건. 이번 i번째 포도주잔을 마시지 않겠다는 의미임)
 * 위와같은 로직이 들어가지 않으면 dp[6] = 26인대도 불구하고 dp[7]의 max값이 23이나옴.(dp[4]=12 값에다가 wine[6]=10, wine[7]=1값을 더해서 나온값이 23) 
 * 아래 반례 디버깅 돌리다가 알게됨.
 * 
 * 반례)
 * 10
 * 1
 * 1
 * 10
 * 1
 * 5
 * 10
 * 1
 * 1
 * 1
 * 10
 */
public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		int max = 0;

		wine[1] = Integer.parseInt(br.readLine());
		dp[1] = wine[1];
		max = dp[1];

		if(n >= 2 ) {	// 포도주가 2잔일때
			wine[2] = Integer.parseInt(br.readLine());
			dp[2] = wine[1] + wine[2];

			if(dp[2] > max) {
				max = dp[2];
			}
		} 
		
		if(n >= 3) {	// 포도주가 3잔일때
			wine[3] = Integer.parseInt(br.readLine());
			dp[3] = Math.max(wine[1] + wine[2], Math.max(wine[1], wine[2]) + wine[3]);	// 포도주 1,2를 선택하고 3을 스킵하거나 or 1,3선택 or 2,3 선택하는 경우
			if(dp[3] > max) {
				max = dp[3];
			}
		}

		// 포도주가 4잔 이상일때
		for(int i = 4; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
			dp[i] = Math.max(Math.max(dp[i-3] + wine[i-1], dp[i-2]) + wine[i], dp[i-1]);

			if(dp[i] > max) {
				max = dp[i];
			}
		}

		br.close();
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}