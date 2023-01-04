/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/10773
문제번호 : 10773
알고리즘 : 구현, 자료 구조, 스택
*/

package Step_20_스택.a10773_제로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * [문제풀이 컨셉]
 * 컨셉없음. 그냥 구현하면됨.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}

		int result = 0;
		for(int i = 0, range = stack.size(); i < range; i++) {
			result += stack.pop();
		}

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}