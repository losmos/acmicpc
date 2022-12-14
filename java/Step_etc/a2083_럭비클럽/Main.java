/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2083
 	문제번호 : 2083
 	알고리즘 : 구현
*/
package Step_etc.a2083_럭비클럽;

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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if(name.equals("#") && age == 0 && weight == 0) {
				break;
			}

			if(age > 17 || weight >= 80) {
				sb.append(name).append(" ").append("Senior").append("\n");
			} else {
				sb.append(name).append(" ").append("Junior").append("\n");
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}