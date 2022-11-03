/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2338
 	문제번호 : 2338
 	알고리즘 : 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a2338_긴자리계산;

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

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        br.close();
        bw.write(A.add(B).toString() + "\n");
        bw.write(A.subtract(B).toString() + "\n");
        bw.write(A.multiply(B).toString() + "\n");
        bw.flush();
        bw.close();
	}
}