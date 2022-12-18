/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14928
 	문제번호 : 14928
 	알고리즘 : 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a14928_큰수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		long temp = 0;
        for (int i = 0, range = input.length(); i < range; i++) {
        	temp = (temp * 10 + (input.charAt(i) - '0')) % 20000303;
        }

		br.close();
		bw.write(temp + "");
		bw.flush();
		bw.close();
	}
}