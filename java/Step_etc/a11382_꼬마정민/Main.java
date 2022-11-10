/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11382
 	문제번호 : 11382
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a11382_꼬마정민;

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
        
        BigInteger input = new BigInteger(st.nextToken());
        
        br.close();
        bw.write(input.add(BigInteger.valueOf(Long.parseLong(st.nextToken()))).add(BigInteger.valueOf(Long.parseLong(st.nextToken()))).toString());
        bw.flush();
        bw.close();
	}
}