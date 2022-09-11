/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4153
 	문제번호 : 4153
 	알고리즘 : 수학, 기하학, 피타고라스 정리
*/
package Step_13_기하1.a4153_직각삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		final String RIGHT = "right";
		final String WRONG = "wrong";

		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) {
				break;
			}

			if(a > b && a > c) {	// a가 제일 큰 값일 때
				if( b*b + c*c == a*a) {
					bw.write(RIGHT + "\n");
				} else {
					bw.write(WRONG + "\n");
				}
			} else if (b > a && b > c) {	// b가 제일 큰 값일 때
				if( a*a + c*c == b*b) {
					bw.write(RIGHT + "\n");
				} else {
					bw.write(WRONG + "\n");
				}
			} else {	// c가 제일 큰 값이거나, 제일큰값이 동시에 2개이상이거나
				if( a*a + b*b == c*c) {
					bw.write(RIGHT + "\n");
				} else {
					bw.write(WRONG + "\n");
				}
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}