/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/13277
 	문제번호 : 13277
 	알고리즘 : 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a13277_큰수곱셈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        BigInteger bi = new BigInteger(st.nextToken());

        br.close();
        bw.write(bi.multiply(new BigInteger(st.nextToken())) + "");
        bw.flush();
        bw.close();
	}
}