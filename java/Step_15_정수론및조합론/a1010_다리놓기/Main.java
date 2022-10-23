/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1010
 	문제번호 : 1010
 	알고리즘 : 수학, 다이나믹 프로그래밍, 조합론
*/
package Step_15_정수론및조합론.a1010_다리놓기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	/**
	 * 다리가 교차되거나 1:n || n:1 과같이 중복해서 다리가 놓아지는 케이스를 어떻게 고려해야되나 고민을 되게많이했다.
	 * N=3, M=5라면 5P3 순열로 접근해서 풀려고 시도했었다.
	 * 즉, N : M 의 모든 다리의 경우의 수(mPn)를 구한다음에 교차나 겹치는 케이스를 빼는식으로 접근했었는데 (nPr 순열) 결론적으로, 답에 스스로 닿지못했고, 아쉽다.
	 * 예를들어 N에서 3개를 뽑고, 오른쪽에서 3개를 뽑았다면, 순열개념으로 생각했을때는 교차되는 다리가 있지만, 그냥 순서가 없는 조합의 개념으로보면 결국 한가지 케이스밖에 없다.
	 * 그리고 그게 N과 M에서 임의의 사이트를 선정하고나서 다리를놓을수있는 유일한 방법이다.
	 * 그림없이 텍스트로 설명하자니 좀 어려운데, 헷갈리면 직접 그려보거나 서칭해보자.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int[][] dp = new int[31][31];

		int T = Integer.parseInt(br.readLine());
		for(int k = 0; k < T; k ++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for(int i = 0; i < M+1; i++) {
				for(int j = 0; j <= i; j++) {
					if(i == j || j == 0) {	// 조합 nCn = 1 이고, nC0 또한 1이므로, 해당 케이스는 값을 1을 할당해준다.
						dp[i][j] = 1;
					} else {	// 그 외 는 파스칼의 삼각형 규칙에 따라서 아래와같은 공식 적용.
						dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);
					}
				}
			}
			bw.write(String.valueOf(dp[M][N]) + "\n");	// 출력할때 dp[N][M]이 아니라 dp[M][N]임. (nCm 이 아니라 mCn 이므로)
		}

		br.close();
		bw.flush();
		bw.close();
	}
}