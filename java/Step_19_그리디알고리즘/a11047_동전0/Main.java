/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/11047
문제번호 : 11047
알고리즘 : 그리디 알고리즘, 정렬
*/

package Step_19_그리디알고리즘.a11047_동전0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 일반적인 그리디 알고리즘 사용.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] greedyArr = new int[N];

		for(int i = 0; i < N; i++) {
			greedyArr[i] = Integer.parseInt(br.readLine());	// 동전의 가치는 오름차순으로 입력됨
		}

		int result = 0;
		outer : while(true) {
			for(int i = N-1; i >= 0; i--) {
				if(K >= greedyArr[i]) {
					result += K / greedyArr[i];	// K가 1600이고, greedyArr[i] 값이 500이라면 result 값은 3
					K = K % greedyArr[i];		// K가 1600이고, greedyArr[i] 값이 500이라면 K값은 100

					if(K == 0) {
						break outer;
					}
				}
			}
		}

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}