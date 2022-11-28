/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/8871
 	문제번호 : 8871
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a8871_Zadanie_probne2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		br.close();
		bw.write((t+1)*2 + " " + (t+1)*3);
		bw.flush();
		bw.close();
	}
}