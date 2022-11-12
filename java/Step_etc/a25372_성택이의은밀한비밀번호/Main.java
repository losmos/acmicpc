/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25372
 	문제번호 : 11382
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a25372_성택이의은밀한비밀번호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            if(input.length() >= 6 && input.length() <= 9) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}