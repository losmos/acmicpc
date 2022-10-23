/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2579
 	문제번호 : 2579
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a2579_계단오르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * dp 점화식 세우기가 너무 어려워서, 검색해 봤는데도 쉽사리 이해되지 않았던 문제.
 * 제일 헷갈렸던건 연속3계단 처리를 어떤식으로 해야 하는가에 대한 부분이였는데,
 * 결과적으론 시간을 좀 들여서 이해를 하긴 함.
 * 
 * 처음에 혼자 점화식을 세우려고할때는, 너무 어려웠었다.
 * 예를들어 for(int i = 0; i < n; i++) loop문에서 dp[i]배열의 max값을 구한다고 했을 때
 * 현재 dp[i]값을 검사하는 단계라면. 그 전단계였던 dp[i-1], dp[i-2], ..., d[i-n] 은 이미 dp max값을 점화식을통해 구한상태로 가지고있다는 전제를 깔고 접근하려 했기 때문(잘못된 방법)
 * 하지만 현재 dp[i]번째 검사 단계일때, dp[i-2] 까지만 정확한 max값을 가지고 있다라고 하면 계단오르기의 max값을 유연하게 계산해서 처리 할 수 있음.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n+1];	// 계단숫자
		int[] dp = new int[n+1];		// dp값

		stair[1] = Integer.parseInt(br.readLine());
		dp[1] = stair[1];
	
		if(n >= 2) {	// n이 1 입력되면 예외발생
			stair[2] = Integer.parseInt(br.readLine());
			dp[2] = stair[1] + stair[2];
		}

		for(int i = 3; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());	// 계단 숫자 입력
			dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];	// i-3, i-2번째는 max값이 fixed 된 dp배열에서 값을 꺼내쓰고, i-1값은 stair값에서 꺼내씀.
		}

		br.close();
		bw.write(String.valueOf(dp[n]));
		bw.flush();
		bw.close();
	}
}