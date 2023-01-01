/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/10828
문제번호 : 10828
알고리즘 : 자료 구조, 스택
*/

package Step_20_스택.a10828_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 컨셉없음. 그냥 구현하면됨.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.empty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					if(stack.empty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "top":
					if(stack.empty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
				default : 
				}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}