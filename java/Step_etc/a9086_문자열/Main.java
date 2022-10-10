/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9086
 	문제번호 : 4101
 	알고리즘 : 구현
*/
package Step_etc.a9086_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            bw.write(str.substring(0, 1));
            bw.write(str.substring(str.length()-1, str.length()));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
	}
}