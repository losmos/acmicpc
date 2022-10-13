/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3733
 	문제번호 : 3733
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a3733_Shares;

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

        String input = "";

        while((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input, " ");

            int N = Integer.parseInt(st.nextToken()) + 1;
            int S = Integer.parseInt(st.nextToken());
            bw.write(S / N + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
	}
}