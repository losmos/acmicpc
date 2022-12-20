/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11723
 	문제번호 : 11723
 	알고리즘 : 구현, 비트마스킹
*/
package Step_etc.a11723_집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * Map으로할까하다가 입력조건 중 x의 값 범위가 1~20이라서 배열 주소번지를 key로 쓰고 그 값을 value값으로 활용함(범위가 작아서 배열 사이즈를 작게 잡아도 됨)
 * 코딩 구현은 단순.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[20+1];

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if(!command.equals("all") && !command.equals("empty")) {
				x = Integer.parseInt(st.nextToken());
			}

			switch (command) {
				case "add": {
					arr[x] = true;
					break;
				}
				case "remove": {
					arr[x] = false;
					break;
				}
				case "check": {
					if(arr[x]) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
					break;
				}
				case "toggle": {
					arr[x] = !arr[x];
					break;
				}
				case "all": {
					for(int j = 1; j <= 20; j++) {
						if(!arr[j]) {
							arr[j] = true;
						}
					}
					break;
				}
				case "empty": {
					for(int j = 1; j <= 20; j++) {
						if(arr[j]) {
							arr[j] = false;
						}
					}
					break;
				}
				default:
				break;
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}