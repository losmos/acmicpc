/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/24078
 	문제번호 : 24078
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a24078_Remainder;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 주어진 수 x를 21로 나눈 나머지값을 구하는 문제
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write((Integer.parseInt(br.readLine()) % 21) + "");
		br.close();
        bw.flush();
        bw.close();
	}
}