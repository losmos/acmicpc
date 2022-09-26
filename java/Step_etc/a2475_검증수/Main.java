/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2475
 	문제번호 : 2475
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a2475_검증수;

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
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        
        int result = 0;
        for(int i = 0; i < 5; i++) {
            int input = Integer.parseInt(st.nextToken());
            result = result + (input * input);
        }

        bw.write(String.valueOf(result%10));
        br.close();
        bw.flush();
        bw.close();
	}
}