/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1463
 	문제번호 : 1463
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_16_동적계획법1.a1463_1로만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 이번 DP문제 너무어려웠다. 점화식을 못세우겠음.
 * 이것도 결국 검색해서 공부함.
 * 
 * n에 연산할수있는 방법은 총 3가지이다.
 *  - X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *  - X가 2로 나누어 떨어지면, 2로 나눈다.
 *  - 1을 뺀다.
 * 
 * n=10 일때를 계산해보자.
 * 10은 3으로 나누어 떨어지진않기때문에 3으로 나눌 수 없다.
 * 대신 2로나누어 떨어진다.
 * 따라서 10일때 할수있는 경우의 수는, 2로나누거나 1을 빼주는방법. 총 2가지의 경우의 수가 있다.
 * 10을 2로나누면 5가되고. 1을 빼주면 9가된다.
 * 그럼 2로나누는게 나을까? 1을 빼주는게 나을까?
 * 그전에, 5의 연산횟수최소값과. 9의 연산횟수최소값은 몇일까? 몇이든간에, 5의연산횟수최소값 +1 만큼 더해주면 10의 연산횟수가된다. (10에서 2를나누면 5가되기때문에. 역으로 5의 연산횟수를 알면 거기에 연산횟수 +1만 해주면된다)
 * 마찬가지로 1을뺀값인 9의 연산횟수최소값 + 1만큼 해주는것도 10의 연산횟수가 된다. (10에서 1을 빼주면 9가되고, 이는 한번의 연산횟수가 들기 때문이다.)
 * 그래서 10이란숫자에서 2로 나누는게 나을까? 1을 빼주는게나을까?
 * 그건 5와, 9 둘중 연산횟수최소값이 더 작은 연산횟수에 + 1 을 해주면 된다.
 * 실제로 계산해보면 9의 연산최소값이 더 적다.
 * 그렇기때문에 9의 연산최소값에 + 1을 해주는것이 n=10일때 연산최소값이다.
 * 하지만 9의 연산최소값을 구하기위해선 3으로나누었을때의 연산최소값, 또는 1을 빼주었을때의 연산최소값중에 뭐가 더 적은지 알아야하고 그 연산횟수최소값에 + 1을 해준게 9의 연산횟수최소값이다.
 * 이처럼 위에서 했던 방식을 계속 반복해주어야한다.
 * 
 * 따라서 점화식은 아래와 같이 세울 수 있다.
 * (if n%3 == 0일때) n의 연산횟수최소값 dp[n] = Math.min(dp[n/3]) + 1 또는 Math.min(dp[n-1] + 1)
 * (if n%2 == 0일때) n의 연산횟수최소값 dp[n] = Math.min(dp[n/2]) + 1 또는 Math.min(dp[n-1] + 1)
 * (if n%6 == 0일때) n의 연산횟수최소값 dp[n] = Math.min(dp[n/3]) + 1 또는 Math.min(dp[n/2]) + 1 또는 Math.min(dp[n-1] + 1)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];	// 숫자 n의 최소값은 dp[n]에 저장됨.

		dp[0] = 0;
		dp[1] = 0;

		for(int i = 2; i <= n; i++) {
			if(i % 6 == 0) {	// 3으로도 나누어떨어지고, 2로도 나누어 떨어질 때
				dp[i] = Math.min(Math.min(dp[i-1], dp[i/2]), dp[i/3]) + 1;
			}else if(i % 3 == 0) {	// 3으로 나누어 떨어질 때
				dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			}else if(i % 2 == 0) {	// 2로 나누어 떨어질 때
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			} else {	// 3으로도, 2로도 나누어 떨어지지 않아서 -1을 해주어야 되는 케이스
				dp[i] = dp[i-1] + 1;
			}
		}

		br.close();
		bw.write(String.valueOf(dp[n]));
		bw.flush();
		bw.close();
	}
}