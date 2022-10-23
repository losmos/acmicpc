/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1002
 	문제번호 : 1002
 	알고리즘 : 수학, 기하학
*/
package Step_14_기하1.a1002_터렛;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	/**
	 * 참고 url : https://mathbang.net/101
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int i =0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int d_pow = 0;	// 두개 좌표 사이의 거리 (double형 쓰면 안됨. 정밀도가 아무리높아도 오차가 생길 수 있음)
			int x1 = Integer.parseInt(st.nextToken());	// 첫번째 좌표 x값
			int y1 = Integer.parseInt(st.nextToken());	// 첫번째 좌표 y값
			int r1 = Integer.parseInt(st.nextToken());	// 첫번째 좌표를 중점으로 그려진 원의 반지름
			int x2 = Integer.parseInt(st.nextToken());	// 두번째 좌표 x값
			int y2 = Integer.parseInt(st.nextToken());	// 두번째 좌표 y값
			int r2 = Integer.parseInt(st.nextToken());	// 두번째 좌표를 중점으로 그려진 원의 반지름

			// d의제곱 = (x1-x2)의 제곱 + (y1-y2)의 제곱
			d_pow = (int)(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
			
			if(r1 == r2 && d_pow == 0) {	// 교점의 개수가 무한대인경우는 -1출력. 두원이 완전하게 일치하는경우임
				bw.write("-1" + "\n");
				continue;
			}

			if(Math.pow(r1 + r2,2) > d_pow && Math.pow(r1 - r2,2) < d_pow) {				// 교점이 2개이려면 두 원의 반지름의 합이 d보다크고 && 두원의 반지름의 차가 d보다 작아야함.
				bw.write("2" + "\n");
			} else if (Math.pow(r1 + r2,2) == d_pow || d_pow == Math.pow(r2 - r1, 2)) {	// 교점이 1개이려면 두 원의 반지름의 합이 d와같거나 두반지름의 차가 d와 같으면 됨(각각 외접, 내접 조건)
				bw.write("1" + "\n");
			} else {
				bw.write("0" + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}