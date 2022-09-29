/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1271
 	문제번호 : 1271
 	알고리즘 : 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package Step_etc.a1271_엄청난부자2;

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
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        bw.write(n.divide(m).toString() + "\n");
        bw.write(n.remainder(m).toString());

        br.close();
        bw.flush();
        bw.close();
	}
}