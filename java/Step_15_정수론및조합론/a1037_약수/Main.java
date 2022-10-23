/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1037
 	문제번호 : 1037
 	알고리즘 : 수학, 정수론
*/
package Step_14_정수론및조합론.a1037_약수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	/**
	 * 진짜약수가 주어질때. 이들의 곱으로 N을 구할수있는데
	 * 진짜약수들 중에서 가장 작은숫자와 가장 큰 숫자를 곱하면 그 숫자가 N인듯
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());	// 진짜 약수의 개수
		int min = 1000000;	// 진짜 약수 중 최소값
		int max = 2;		// 진짜 약수 중 최대값

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());

			if(input < min) {
				min = input;
			}
			if(input > max) {
				max = input;
			}
		}

		bw.write(String.valueOf(min*max));

		br.close();
		bw.flush();
		bw.close();
	}
}