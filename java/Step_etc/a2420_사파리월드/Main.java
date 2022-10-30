/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2420
 	문제번호 : 2420
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a2420_사파리월드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();
        bw.write(Math.abs(Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken())) + "\n");
        bw.flush();
        bw.close();
	}
}