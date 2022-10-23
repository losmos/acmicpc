/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2477
 	문제번호 : 2477
 	알고리즘 : 수학, 구현, 기하학
*/
package Step_14_기하1.a2477_참외밭;

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

		int K = Integer.parseInt(br.readLine());	// 1제곱미터의 넓이에 자라는 참외의 개수
		int[] directionArr = new int [6];	// 입력순서대로 방향정보를 저장한다.
		int[] meterArr = new int [6];		// 입력순서대로 거리정보를 저장한다.
		int[] countArr = new int [4];		// 주소 : 방향값-1, value : 움직인 횟수(카운트)

		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			directionArr[i] = Integer.parseInt(st.nextToken());
			meterArr[i] = Integer.parseInt(st.nextToken());
			countArr[directionArr[i]-1]++;
		}

		int fullSquare = 0;		// 사각형의 전체넓이
		int emptySquare = 0;	// 빼줘야할 빈공간 emptySquare 넓이
		int emptyWH1 = 0;		// emptySquare를 이루는 첫번째 변길이
		int emptyWH2 = 0;		// emptySquare를 이루는 두번째 변길이
		for(int i = 0; i < 4; i++) {	// countArr[i] 검사할거임
			if(countArr[i] == 1) {	// countArr[i] 값이 꺾이지않은 변의 길이인 경우, 그러니까 온전한 변의길이인경우라면(i+1값은 방향, 0번인덱스부터 사용했으므로)
				for(int j = 0; j < directionArr.length; j++) {
					if(directionArr[j] == i+1) {	// i+1 값은 방향
						if(fullSquare == 0) {	//  fullSquare변수에 한번도 값을 할당한적 없으면
							fullSquare = meterArr[j];	// j-2 값에 해당하는 meter값이 empty 사각형을 이루는 변임
							emptyWH1 = meterArr[(j+3)%6];	// j+3%6해주면 emptySquare의 변의길이를 구할수있음. 그려가며 규칙찾다보니 찾긴했는데. 이게 왜 가능한지에대해서 명쾌하게 설명은 못하겠다.
							break;
						} else {	// fullSquare변수에 값이 이미있다면 변의길이이므로. 곱해서 넓이를 구해줌
							fullSquare = fullSquare * meterArr[j];	// j+2 값에 해당하는 meter값이 empty 사각형을 이루는 변임
							emptyWH2 = meterArr[(j+3)%6];	// j+3%6해주면 emptySquare의 변의길이를 구할수있음. 그려가며 규칙찾다보니 찾긴했는데. 이게 왜 가능한지에대해서 명쾌하게 설명은 못하겠다.
						}
					}
				}
			}
		}

		emptySquare = emptyWH1 * emptyWH2;

		bw.write((fullSquare - emptySquare) * K + "");
		br.close();
		bw.flush();
		bw.close();
	}
}