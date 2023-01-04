/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/18111
 	문제번호 : 18111
 	알고리즘 : 구현, 브루트포스 알고리즘
*/
package Step_etc.a18111_마인크래프트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 입력되는 벌럭의 높이 범위(Math.max(최저높이, 높이평균) ~ 최고높이)의 각 소요시간을 브루트포스로 계산해본다.
 * 
 * 예를들어
 * 3 4 0
 * 63 63 63 63
 * 63 63 63 63
 * 63 63 63 1
 * 
 * 일경우 최저높이인 1의높이까지 검사해보기엔 비효율.
 * 블럭의 개수를 전부다 합한다음 블럭이 들어설 자리의 개수로 나누면
 * 블럭의 평균 높이가나오는데, 이 높이 아래로 땅을 파서, 땅을 고르게하는 계산을 하는건 불필요한 계산.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		int highest = 0;
		int lowest = 256;
		int avg = 0;

		// 마인크래프트 블럭 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				arr[i][j] = height;
				avg += height;

				if(height > highest) {	// 최고높이 갱신
					highest = height;
				}
				if(height < lowest) {	// 최저높이 갱신
					lowest = height;
				}
			}
		}

		avg = avg / (N*M);
		int bestWorkingTime = 500*500*256*2;
		int bestHeight = 256;

		// 땅 다지기
		outer: for(int b = highest, range = Math.max(avg, lowest); b >= range; b--) {
			int bCopy = B;
			int workingTime = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] > b) {	// 현재 블럭의 높이가 목표높이(b)보다 크다면 파내야하고
						int gap = arr[i][j] - b;
						bCopy += gap;
						workingTime += gap*2;
					} else {	// 아니라면 블럭을 추가해야한다.
						int gap = b - arr[i][j];
						bCopy -= gap;
						workingTime += gap;
					}
				}
			}

			if(bCopy < 0) {	// 소유한 B블럭 개수가 마이너스가 되는 경우(소유한것보다 더 많은 블럭이 요구되는 경우)
				continue outer;
			}

			if(workingTime < bestWorkingTime) {
				bestWorkingTime = workingTime;
				bestHeight = b;
			}

			// System.out.println("높이 : " + b);
			// System.out.println("남은블럭 : " + bCopy);
			// System.out.println("소요시간 : " + workingTime);
		}

		br.close();
		bw.write(bestWorkingTime + " " + bestHeight);
		bw.flush();
		bw.close();
	}
}