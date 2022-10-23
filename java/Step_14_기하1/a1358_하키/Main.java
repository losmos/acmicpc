/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1358
 	문제번호 : 1358
 	알고리즘 : 기하학
*/
package Step_14_기하1.a1358_하키;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	/**
	 * 선수의 좌표가 주어졌을때
	 * if 왼쪽원 안에있는지 검사
	 * else if 사각형안에 있는지 검사
	 * (선수의 x,y 좌표값이 직사각형의 우측상단 꼭지점 좌표값보다 작고 and 왼쪽하단 꼭지점인 x,y 좌표값보다 크다면  사각형안에 포함되어 있다고 볼 수 있음)
	 * else if 오른쪽원 안에 있는지 검사
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());	// 링크의 중앙부분에 위치하는 직사각형의 width
		int H = Integer.parseInt(st.nextToken());	// 링크의 중앙부분에 위치하는 직사각형의 height
		int X = Integer.parseInt(st.nextToken());	// 문제x 좌표
		int Y = Integer.parseInt(st.nextToken());	// 문제y 좌표
		int P = Integer.parseInt(st.nextToken());	// 선수의 수

		int r = H/2;			// 원의 반지름
		int x1 = X;				// 왼쪽 원의 중점 x좌표
		int y1 = Y + r;			// 왼쪽 원의 중점 y좌표
		int squareX = X + W;	// 직사각형의 우측상단 꼭지점 x좌표
		int squareY = Y + H;	// 직사각형의 우측상단 꼭지점 y좌표
		int x2 = X + W;			// 오른쪽 원의 중점 x좌표
		int y2 = Y + r;			// 오른쪽 원의 중점 y좌표
		
		int result = 0;
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int pX = Integer.parseInt(st.nextToken());	// 선수의 x좌표
			int pY = Integer.parseInt(st.nextToken());	// 선수의 y좌표
			int dPowLeft = (int)(Math.pow(pX - x1, 2) + Math.pow(pY - y1, 2));	// 선수와 왼쪽 원의 중점까지의 거리값의 제곱값
			int dPowRight = (int)(Math.pow(pX - x2, 2) + Math.pow(pY - y2, 2));	// 선수와 오른쪽 원의 중점까지의 거리값의 제곱값
			
			if(dPowLeft <= r*r) {	// 선수가 왼쪽 원 안에 있다면
				result++;
			} else if((pX >= X && pY >= Y) && (pX <= squareX && pY <= squareY)) {	// 선수가 중앙 직사각형 안에 있다면
				result++;
			} else if(dPowRight <= r*r) {	// 선수가 오른쪽 원 안에 있다면
				result++;
			}
		}

		bw.write(String.valueOf(result) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}