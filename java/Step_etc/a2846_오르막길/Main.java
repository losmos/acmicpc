/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2846
 	문제번호 : 2846
 	알고리즘 : 구현
*/
package Step_etc.a2846_오르막길;

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

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int start = 0;
		int last = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());

			if(start == 0) {
				start = input;
				last = input;
				continue;
			}

			if(input > last) {
				last = input;

				if(i == N-1 && last - start > max) {
					max = last - start;
				}
			} else {
				if(last - start > max) {
					max = last - start;
				}

				start = input;
				last = input;
			}
		}

		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}