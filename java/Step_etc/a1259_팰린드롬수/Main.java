/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1259
 	문제번호 : 1259
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a1259_팰린드롬수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

	// 팰린드롬 체크 함수
	public String checkPalindrome(String str, int left, int right) {
		if(left >= right) {
			return "yes";
		}else if(str.charAt(left) == str.charAt(right)) {
			return checkPalindrome(str, left+1, right-1);	// recursive call
		} else {
			return "no";
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			sb.append(main.checkPalindrome(str, 0, str.length()-1)).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}