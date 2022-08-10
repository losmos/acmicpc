/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25304
 	문제번호 : 25304
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a25304_영수증;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int total = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sumN = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sumN = sumN + (a * b) ;
		}

		if(total == sumN) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
	}
}