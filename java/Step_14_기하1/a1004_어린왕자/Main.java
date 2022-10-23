/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1004
 	문제번호 : 1004
 	알고리즘 : 기하학
*/
package Step_14_기하1.a1004_어린왕자;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	/**
	 * 행성계가 시작점(좌표)을 온전하게 둘러싸고 있을때 도착점(좌표)도 동시에 둘러싸고있으면 행성계를 진입/이탈할일이 없음
	 * 따라서 시작점이 원안에있을때 도착점이 원 밖에 있거나, 도착점이 원 안에 있을때 시작점이 원 밖에 있으면 반드시 진입/이탈 하게됨
	 * 임의의 행성계 중점 좌표가 주어지고 행성계 범위를 의미하는 반지름이 주어졌을 때.
	 * 행성계와 시작점/도착점과의 거리 d를구했을때 반지름이 더 크다면 시작/도착점은 그 행성계 원(범위) 안에 있음
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());	// 테스트케이스
		for (int i =0; i < T; i++) {
			int dPowStart = 0;	// 행성계 중점 좌표로부터 시작점까지의 거리
			int dPowEnd = 0;	// 행성계 중점 좌표로부터 도착점까지의 거리
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());	// 출발점 x좌표
			int y1 = Integer.parseInt(st.nextToken());	// 출발점 y좌표
			int x2 = Integer.parseInt(st.nextToken());	// 도착점 x좌표
			int y2 = Integer.parseInt(st.nextToken());	// 도착점 y좌표
			int n = Integer.parseInt(br.readLine());	// 행성계 개수

			int result = 0;	// 최종적으로 출력할 값인, 행성계 진입/이탈 토탈 횟수
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());	// 행성계의 중점 x좌표
				int cy = Integer.parseInt(st.nextToken());	// 행성계의 중점 y좌표
				int r = Integer.parseInt(st.nextToken());	// 행성계 반지름

				dPowStart = (int)(Math.pow(x1 - cx,2) + Math.pow(y1 - cy,2));
				dPowEnd = (int)(Math.pow(x2 - cx,2) + Math.pow(y2 - cy,2));


				boolean StartInner = false;	//	행성계 원안에 시작점이 들어가있다면 true, 아니면 false
				boolean EndInner = false;	//	행성계 원안에 도착점이 들어가있다면 true, 아니면 false

				if(r*r > dPowStart) {	// 행성계가 시작점 좌표를 둘러싸고 있는 경우
					StartInner = true;
				}
				if(r*r > dPowEnd) {		// 행성계가 도착점 좌표를 둘러싸고 있는 경우
					EndInner = true;
				}

				if((StartInner && !EndInner) || (!StartInner && EndInner)) {	// 시작점이 원안에있을때 도착점이 원밖에 있거나, 도착점이 원 안에있을 때 시작점이 원 밖에 있는 경우
					result++;
				}
			}

			bw.write(String.valueOf(result) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}