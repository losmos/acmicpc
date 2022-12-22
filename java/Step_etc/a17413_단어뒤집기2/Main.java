/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/17413
 	문제번호 : 17413
 	알고리즘 : 구현, 자료 구조, 문자열, 스택
*/
package Step_etc.a17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * StringBuilder의 reverse 내장함수 활용
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();		// 최종적으로 출력할 문자열을 담을 StringBuilder
		StringBuilder sb2 = new StringBuilder();	// 뒤집을(reverse) 문자열을 담을 StringBuilder

		char[] arr = br.readLine().toCharArray();	// input

		int bracket = 0;	// "<" 괄호가 나올경우 bracket+1, ">" 괄호가 나올경우 bracket-1
		for(int i = 0, range = arr.length; i < range; i++) {
			if(arr[i] == '<') {
				bracket++;
				if(sb2.length() > 0) {
					sb.append(sb2.reverse());
					sb2 = new StringBuilder();	// clear
				}
				sb.append(arr[i]);
				continue;
			} else if(arr[i] == '>') {
				bracket--;
				sb.append(arr[i]);
				continue;
			}

			if(bracket > 0) {	// "<" 괄호가 열려있는 상태이면 문자를 뒤집지 않고 그대로 담는다.
				sb.append(arr[i]);
			} else {
				if(arr[i] == ' ') {	// 공백이 나오면 sb2를 뒤집는다(reverse)
					sb.append(sb2.reverse()).append(' ');
					sb2 = new StringBuilder();	// clear
				} else {
					sb2.append(arr[i]);
				}
			}
		}

		if(sb2.length() > 0) {
			sb.append(sb2.reverse());
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}