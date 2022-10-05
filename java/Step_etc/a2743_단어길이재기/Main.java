/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2743
 	문제번호 : 2743
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a2743_단어길이재기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write(br.readLine().length()+"");
        br.close();
        bw.flush();
        bw.close();
	}
}