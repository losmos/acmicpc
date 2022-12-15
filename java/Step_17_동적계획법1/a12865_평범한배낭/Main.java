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
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 물품 수
		int K = Integer.parseInt(st.nextToken());	// 버틸수있는 최대 무게

		int[] itemWeight = new int[N];
		int[] itemValue = new int[N];
		int[][] dp = new int[N][K+1];	// N : 아이템번호, K : 아이템무게
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			itemWeight[i] = Integer.parseInt(st.nextToken());	// 물건의 무게
			itemValue[i] = Integer.parseInt(st.nextToken());	// 물건의 가치
			for(int j = itemWeight[i]; j <= K; j++) {	// 반복문을 돌면서, 매번 무게를 J만큼 담을 수 있을때의 조건을 체크한다. (+ i번째 아이템까지를 가진채로)
				if(itemWeight[i] <= K) {	// 아이템의무게가 가방에 수용할 수 있는 최대무게를 넘지 않을경우
					if(i == 0) {
						dp[i][j] = itemValue[i];
						continue;
					}

					if(dp[i-1][j] + itemWeight[i] <= K) {	// 전까지 담았던 아이템에 더해서(+) 더 담을 수 있을경우
						// dp[i][j] = dp[i-1][j] + itemValue[i];
						dp[i][j] = Math.max(dp[i-1][j] + itemValue[i], itemValue[i] + dp[i][K-i]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j], itemValue[i] + dp[i-1][K-i]);
					}
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}

		br.close();
	}
}