/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/17626
 	문제번호 : 17626
 	알고리즘 : 다이나믹 프로그래밍, 브루트포스 알고리즘
*/
package Step_etc.a17626_FourSquares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dp[i] = 4;	// 라그랑주는 1770년에 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다고 증명하였으므로, 최대값은 4
			for(int j = (int)Math.sqrt(i); j > 0; j--) {	// 오름차순으로 찾는것보다. 내림차순으로 찾는게 더 빠르다.
				int pow = (int)Math.pow(j, 2);
				if(pow == i) {	// (i의 루트값)^2 == i와 같다면, 한개 제곱의수로 표현 할 수 있다.
					dp[i] = 1;
					break;
				} else if(dp[i] == 2) {	// 한개 제곱수로 표현할수없다면, 그 외 케이스중에서는 2개로 표현하는것이 제일 최소값이므로 바로 break
					break;
				}
				
				if(pow > i) {	// sqrt의 제곱값이 i를넘어가면 break
					break;
				} else {
					// dp[i-pow] + 1 를 이해하기 위한 예를 보면,
					// i=28일때 pow값은 25이므로 25를뺀 나머지값은 3이다.
					// 3으로 만들수있는 최소개수는 3이므로 (1^2 + 1^2 + 1^2)
					// dp[25] 값인 3 에다가 +1(sqrt의 제곱하는 경우읭수)를 해주면 i를 구성하는 제곱수 개수를 찾을 수 있다.
					dp[i] = Math.min(dp[i], dp[i-pow] + 1);
				}
			}
		}

		br.close();
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
	}
}