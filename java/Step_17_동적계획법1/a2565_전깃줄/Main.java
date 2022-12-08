/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2565
 	문제번호 : 2565
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a2565_전깃줄;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * A-B가 연결되어있을 때. 예를들어 a[1] -- b[8]이 연결되어있을 때 
 * a[i] -- b[j] 가 연결되어있다면, 여기서  교차되는 전기줄의 조건은
 * i > 1 && j < 8 또는
 * a < 1 && j > 8 인 경우이다.
 * 즉 i가 1보다 크면, j는 8보다 작아야되고
 * i가 1보다 작으면, j는 8보다 커야만, 전깃줄이 교차된다.
 * 
 * 
 * 설치된 상태에서. 어떤식으로 전깃줄을 제거해야만 되는지를 고민했었으나,
 * 어떤식으로 풀이를 해야할지 도저히 감이안와서 검색함.
 *
 * 진짜 발상의 전환이다.
 * 설치상태에서 제거하는 방식이 아니라, LIS로 부분수열을 구하듯이.
 * 부분 전깃줄 수열(?)을 구해서 그중에 가장 많이 설치 가능한것을 찾으면 된다.
 * 문제의 답은 전깃줄을 설치할 수 있는 최대개수가 아니라, 최소 제거개수이므로.
 * 전기줄개수N - 설치최대개수를 구하면 최소 제거개수가 나온다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());	// 전깃줄개수
		int[] arr = new int[500+1];	// 배열의 주소번지는 전봇대A의 위치번호, 값 부분은 전봇대B의 위치번호를 의미함. (위치번호는 최대 500)
		int[] dp = new int[500+1];
		
		// 전깃줄 할당
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		int max = 0;	// 전깃줄을 설치 할 수 있는 최대 개수

		// 전깃줄 1번을 설치하고나서 1~N까지(1을제외한) 전깃줄을 설치했을때의 dp를 구해보고
		// 전깃줄 2번을 설치해보고 1~N(2를제외한) 전깃줄을 설치했을때의 dp를 구해보고
		// ... 반복
		for(int i = 1; i <= 500; i++) {
			if(arr[i] == 0) {	// 전깃줄이 설치되지않은 위치번호는 skip
				continue;
			}

			dp[i] = 1;	// 일단 i의 전깃줄을 설치한다. 그러면 dp[i]값은 최소 1로 초기화해주어야함.(설치전깃줄개수 = 1)
			for(int j = 1; j < i; j++) {
				if(arr[j] == 0) {	// 전깃줄이 설치되지않은 위치번호는 skip
					continue;
				}

				// 이하 전깃줄이 교차되지 않을 조건설명
				// 설명 : arr배열의 주소값이 A의 위치번호이고 배열값이 B의 위치번호 이므로,
				// arr[j]의 전깃줄 A위치번호는 항상 arr[i]의 A위치번호보다 작으므로, 교차되지 않으려면 A와 연결된 B의위치번호 arr[i]보다 arr[j]가 항상 작아야 한다.)
				if(arr[j] < arr[i]) {	
					dp[i] = Math.max(dp[i], dp[j] + 1);

					if(dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}

		br.close();
		bw.write((N - max) + "");
		bw.flush();
		bw.close();
	}
}