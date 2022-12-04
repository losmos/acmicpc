/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2558
 	문제번호 : 2558
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a2558_A더하기2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) + "");
        br.close();
        bw.flush();
        bw.close();
	}
}