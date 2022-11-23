/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14581
 	문제번호 : 14581
 	알고리즘 : 구현
*/
package Step_etc.a14581_팬들에게둘러싸인홍준;


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

		sb.append(":fan::fan::fan:").append("\n");
		sb.append(":fan::").append(br.readLine()).append("::fan:").append("\n");
		sb.append(":fan::fan::fan:").append("\n");

		br.close();
		bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}