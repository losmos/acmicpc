/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/11399
문제번호 : 11047
알고리즘 : 그리디 알고리즘, 정렬
*/

package Step_19_그리디알고리즘.a11399_ATM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * ATM출금 순서를 Pi값(인출시간)이 가장 짧은사람 순서대로 세운다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] inputArr = new int[N];		// Pi(인출시간) 입력값
		int[] prefixSumArr = new int[N];	// 누적합
		for(int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputArr);

		prefixSumArr[0] = inputArr[0];
		int sum = prefixSumArr[0];
		for(int i = 1; i < N; i++) {
			prefixSumArr[i] = prefixSumArr[i-1] + inputArr[i];
			sum += prefixSumArr[i];
		}

		br.close();
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}