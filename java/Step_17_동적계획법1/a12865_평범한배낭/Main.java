/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/12865
 	문제번호 : 12865
 	알고리즘 : 다이나믹 프로그래밍, 배낭 문제
*/
package Step_17_동적계획법1.a12865_평범한배낭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 혼자 머리싸매고 끙끙대봤지만, 역시 쉽지않은 문제였고,
 * 배낭 알고리즘이라고, 별도의 알고리즘 개념이었음
 * 
 * 참조 : https://fbtmdwhd33.tistory.com/60
 * 
 * 위 블로그 참조하여 겨우 품.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 물품 수
		int K = Integer.parseInt(st.nextToken());	// 버틸수있는 최대 무게

		int[] itemWeight = new int[N+1];
		int[] itemValue = new int[N+1];
		int[][] dp = new int[N+1][K+1];	// N : 아이템번호, K : 아이템무게
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			itemWeight[i] = Integer.parseInt(st.nextToken());	// 물건의 무게
			itemValue[i] = Integer.parseInt(st.nextToken());	// 물건의 가치
			for(int j = 1; j <= K; j++) {	// 반복문을 돌면서, 매번 무게를 J만큼 담을 수 있을때의 조건을 체크한다. (+ i번째 아이템까지를 가진채로)

				dp[i][j] = dp[i-1][j];	// 직전 아이템까지의 dp정보를 그대로 내려받는다.

				if(j - itemWeight[i] >= 0) {	// 무게를 J만큼 담을 수 있을때, J - itemWeight[i] >= 0 이라면 (현재 아이템의 무게를 추가하고도 더넣을 공간이 있다면)
					dp[i][j] = Math.max(dp[i-1][j], itemValue[i] + dp[i-1][j-itemWeight[i]]);	// 직전 아이템까지의 가치값 dp value와 , 현재 아이템의 가치 + 남은 무게의 가치중 큰값을 취한다.
				}
			}
		}

		br.close();
		bw.write(dp[N][K] + "");
		bw.flush();
		bw.close();
	}
}