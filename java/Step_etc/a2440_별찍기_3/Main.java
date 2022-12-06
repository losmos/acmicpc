/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2440
 	문제번호 : 2440
 	알고리즘 : 구현
*/
package Step_etc.a2440_별찍기_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for(int i = N; i > 0; i--) {
			for(int j = 0; j < N; j++) {
				if(j < i) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}