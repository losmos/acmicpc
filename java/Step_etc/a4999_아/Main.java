/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4999
 	문제번호 : 4999
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a4999_아;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input1 = br.readLine().length();
        int input2 = br.readLine().length();

        if(input1 >= input2) {
            bw.write("go");
        } else {
            bw.write("no");
        }

        br.close();
        bw.flush();
        bw.close();
	}
}