/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15652
 	문제번호 : 15652
 	알고리즘 : 백트래킹
*/
package Step_16_백트래킹.a9663_NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문제풀이 컨셉
 * 퀸이 위치할수있는 체스판의 2차원배열 정보를 recursive call 할때마다 사본을만들어서 파라미터로 던졌었는데
 * 메모리초과가 났다.
 * 
 * 문제풀이 방식을 바꿔서 진행할 예정.
 * 배열은 1차원 배열로도 충분하단것을 알았고, 퀸이 위치할수 체스판 정보를 따로 가지고있지않고,
 * 재귀를 탈때마다 세로,대각선 방향으로 이미 다른 퀸이 있는지 검사하는방식을 진행할것임.
 */

class Main {

	int result = 0;

	// 
	public boolean canPlaceQueen(int[] whereisQueen, int nowDepth) {

		for(int i = 0; i < nowDepth; i++) {
			if(whereisQueen[nowDepth] == whereisQueen[i]) {	// 세로축에 퀸이 있다면
    				return false;
			}

			if(Math.abs(nowDepth - i) == Math.abs(whereisQueen[nowDepth] - whereisQueen[i])) {	// 대각선에 퀸이 있다면
				return false;
			}
		}

		return true;
	}

	// 퀸이 위치할 수 있는지 검사하고 위치할 수 있다면 퀸을 배치시키는 함수
	public void dfs(int[] whereisQueen, int nowDepth, int N) {
		if(nowDepth == N) {
			result++;
			return;
		}

		for(int i = 0; i < N; i++) {
			whereisQueen[nowDepth] = i;	// 퀸을 (x,y)좌표 (nowDepth,i) 값놓아본다.
			if(canPlaceQueen(whereisQueen, nowDepth)) {	// (x,y)좌표 (nowDepth,i)위치에 놓은 퀸을 그대로 두어도 되는지 검사
				dfs(whereisQueen, nowDepth+1, N);
			}
		}

		// 퀸위치 출력용
		/*
		for(int v : whereisQueen) {
			System.out.print(v + " ");
		}
		System.out.println();
		 */

		return;
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 퀸의 위치를 저장할 배열 생성. 1차원 배열만으로도 퀸의 x,y 좌표값을 알 수 있는 이유는
		// i번째 index값인 i값을 기본적으로 x좌표로 두고 생략 할 수 있기때문. 배열값은 y좌표.
		// ex) whereisQueen[3] 값이 2 라면. queen은 (x,y) = (3,2) 위치에 있는 것임.
		int[] whereisQueen = new int[N];			

		main.dfs(whereisQueen, 0, N);

		bw.write(main.result + "");
		br.close();
		bw.flush();
		bw.close();
	}
}