/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25372
 	문제번호 : 11382
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a25314_코딩은체육과목입니다;

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

        N = N / 4;

        for(int i = 1; i < N; i++) {
            sb.append("long ");
        }

        sb.append("long int");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}