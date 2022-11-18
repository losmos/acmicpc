/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11659
 	문제번호 : 11659
 	알고리즘 : 누적 합
*/
package Step_18_누적합.a11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 그냥 누적 합 알고리즘의 기본문제.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];	// 누적합을 저장할 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {	// 누적 합 (0번인덱스는 0으로 둔다.)
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}

		// 지정된 인덱스 구간의 합 계산.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(-1 * arr[Integer.parseInt(st.nextToken())-1] + arr[Integer.parseInt(st.nextToken())]).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.flush();
	}
}