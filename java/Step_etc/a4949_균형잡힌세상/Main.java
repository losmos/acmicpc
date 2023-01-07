/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4949
 	문제번호 : 4949
 	알고리즘 : 자료 구조, 문자열, 스택
*/
package Step_etc.a4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 최대 100글자로이루어진 문자열을 수용할 char[] 배열을만들고.
 * 괄호가 열릴때마다 포인터변수 pointer++, 닫힐때마다 pointer-- 해준다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[] bracketStack = new char[100];
		
		outer: while(true) {
			
			int pointer = 0;
			char[] arr = br.readLine().toCharArray();
			if(arr[0] == '.') {
				break;
			} else {
				for(int i = 0, range = arr.length; i < range; i++) {
					if(arr[i] == '(') {
						bracketStack[pointer++] = '(';
					} else if(arr[i] == ')') {
						if(pointer == 0) {	// 열린괄호가 없는데 닫는괄호가 들어오는 경우
							sb.append("no").append("\n");
							continue outer;
						}

						if(bracketStack[pointer-1] == '(') {
							pointer--;
						} else {
							sb.append("no").append("\n");
							continue outer;
						}
					} else if(arr[i] == '[') {
						bracketStack[pointer++] = '[';
					} else if(arr[i] == ']') {
						if(pointer == 0) {	// 열린괄호가 없는데 닫는괄호가 들어오는 경우
							sb.append("no").append("\n");
							continue outer;
						}

						if(bracketStack[pointer-1] == '[') {
							pointer--;
						} else {
							sb.append("no").append("\n");
							continue outer;
						}
					}
				}
				
				if(pointer == 0) {
					sb.append("yes").append("\n");
				} else {
					sb.append("no").append("\n");
				}
			}
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}