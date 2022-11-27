/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/8437
 	문제번호 : 8437
 	알고리즘 : 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a8437_Julka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger totalCnt = new BigInteger(br.readLine());
		BigInteger gap = new BigInteger(br.readLine());

		br.close();
		bw.write(totalCnt.add(gap).divide(BigInteger.valueOf(2)) + "\n");
		bw.write(totalCnt.subtract(gap).divide(BigInteger.valueOf(2)) + "\n");
		bw.flush();
		bw.close();
	}
}