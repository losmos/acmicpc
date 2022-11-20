/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11365
 	문제번호 : 11365
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a11365_밀비급일;

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
		StringBuilder input = new StringBuilder();

		while(true) {
			input.append(br.readLine());

			if(input.toString().equals("END")) {
				break;
			}

			sb.append(input.reverse().append("\n"));
			input.delete(0, sb.length());
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}