/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/9012
문제번호 : 9012
알고리즘 : 자료 구조, 문자열, 스택
*/

package Step_20_스택.a9012_괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * "(" 나오면 int vps 값을 +1 해준다.
 * ")" 나오면 int vps 값을 -1 해준다.
 * 
 * vps값은 최종적으로 0으로 끝나야하며(YES출력 조건) 중간에 한번이라도 0보다 작아지면 "NO"를 출력한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			char[] vpsArr = br.readLine().toCharArray();

			int vps = 0;
			for(int j = 0, range = vpsArr.length; j < range; j++) {
				if(vpsArr[j] == '(') {
					vps++;
				} else if(vpsArr[j] == ')') {
					vps--;
				}

				if(vps < 0) {
					break;
				}
			}

			if(vps == 0) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}