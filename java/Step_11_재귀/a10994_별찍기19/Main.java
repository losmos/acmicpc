/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10994
 	문제번호 : 10994
 	알고리즘 : 구현, 재귀
*/
package Step_11_재귀.a10994_별찍기19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * [문제풀이 컨셉]
 * N 이 입력되면  2차원배열을 만들고 밖에서부터 안쪽으로 재귀를태우면서 별을 찍을거임
 */

public class Main {

	public String[][] drawStar(String[][] whiteBoard, int nowDepth, int targetDepth) {
		if(nowDepth == targetDepth) {	// 재귀 다 타면 return
			return whiteBoard;
		}

		// 아래 그리는 방식은. 처음부터 어떻게 그려야겠다고 설계하고 그린건 아니고, 디버깅으로 그려보면서 값을 조정해줌.
		// 그래서 왜 저런값들이 나왔는지는 딱히 설명하긴힘들고, 그냥 저런식으로 하니깐 잘 그려졌음.
		int startV = nowDepth * 2;	// 재귀를타면서 nowDepth가 증가할수록 별찍는 범위가 점점 좁아짐
		int x = 1 + (targetDepth - nowDepth - 1) * 4;	// 재귀를 탈수록 inner사각형 크기가 작아져야됨. 
		for(int i = startV, range = i + x; i < range; i++) {
			for(int j = startV; j < range; j++) {
				if(i == startV || j == startV || i == range-1 || j == range-1) {	// 최외각만 별을 그린다.
					whiteBoard[i][j] = "*";
				} else {
					whiteBoard[i][j] = " ";
				}
			}
		}

		drawStar(whiteBoard, nowDepth+1, targetDepth);
		return whiteBoard;

	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arrSize = 1 + (N-1)*4;
		String[][] whiteBoard = new String[arrSize][arrSize];

		whiteBoard = main.drawStar(whiteBoard, 0, N);

		for(int i = 0; i < arrSize; i++) {
			for(int j = 0; j < arrSize; j++) {
				bw.write(whiteBoard[i][j]);
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}