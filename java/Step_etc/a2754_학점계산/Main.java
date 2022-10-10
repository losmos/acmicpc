/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2754
 	문제번호 : 2754
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a2754_학점계산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String score = br.readLine();

        if(score.equals("A+")) {
            bw.write("4.3");
        } else if(score.equals("A0")) {
            bw.write("4.0");
        } else if(score.equals("A-")) {
            bw.write("3.7");
        } else if(score.equals("B+")) {
            bw.write("3.3");
        } else if(score.equals("B0")) {
            bw.write("3.0");
        } else if(score.equals("B-")) {
            bw.write("2.7");
        } else if(score.equals("C+")) {
            bw.write("2.3");
        } else if(score.equals("C0")) {
            bw.write("2.0");
        } else if(score.equals("C-")) {
            bw.write("1.7");
        } else if(score.equals("D+")) {
            bw.write("1.3");
        } else if(score.equals("D0")) {
            bw.write("1.0");
        } else if(score.equals("D-")) {
            bw.write("0.7");
        } else {
            bw.write("0.0");
        }

        br.close();
        bw.flush();
        bw.close();
	}
}