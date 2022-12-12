/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/6810
 	문제번호 : 6810
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a6810_ISBN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 91;	// 9780921418까지의 sum 값

		// 이하 뒤에오는 추가 3자리수 계산
		sum += Integer.parseInt(br.readLine()) * 1;
		sum += Integer.parseInt(br.readLine()) * 3;
		sum += Integer.parseInt(br.readLine()) * 1;

		br.close();
		bw.write("The 1-3-sum is " + sum);
		bw.flush();
		bw.close();
	}
}