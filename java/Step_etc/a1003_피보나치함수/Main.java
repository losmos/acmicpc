/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1003
 	문제번호 : 1003
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_etc.a1003_피보나치함수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] fibonacci = new long[41];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for(int i = 2; i <= 40; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				bw.write("1 0 \n");
			} else if(n == 1) {
				bw.write("0 1 \n");
			} else {
				bw.write(fibonacci[n-1] + " " + fibonacci[n] + "\n");	// 문제의 출력결과는 결국 n-1번째 피보나치수, n번째 피보나치수를 출력하는것과 같음
			}

		}

		br.close();
		bw.flush();
		bw.close();
	}
}