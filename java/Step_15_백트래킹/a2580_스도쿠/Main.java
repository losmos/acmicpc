/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2580
 	문제번호 : 2580
 	알고리즘 : 백트래킹
*/
package Step_15_백트래킹.a2580_스도쿠;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * dfs로 푼다.
 * 가로,세로,3x3 영역에대한 각각의 boolean 타입의 visited[][]배열 (사이즈:9)을 만들고.
 * 입력받을때부터 1~9까지의 visited true/false 여부를 저장해두면
 * 검사를 빠르게 할 수 있을것같음.
 */
class Sudoku {
	int[][] sudoku = new int[9+1][9+1];
	boolean[][] visitedH = new boolean[9+1][9+1];		// 가로(Horizontal)
	boolean[][] visitedV = new boolean[9+1][9+1];		// 세로(Vertical) 
	boolean[][] visitedS = new boolean[9+1][9+1];		// 3x3사각형(Square)
	int targetDepth = 0;
}

public class Main {

	// 스도쿠 i,j 좌표에 number숫자가 위치할수 있는지 판단하는 함수
	public boolean isNotPossible(Sudoku sd, int i, int j, int number) {

		// 가로 방향 체크
		if(sd.visitedH[i][number]) {
			return true;
		}

		// 세로 방향 체크
		if(sd.visitedV[j][number]) {
			return true;
		}

		// 3x3 사각형 체크
		int squareI = ((i-1)/3*3) + ((j-1)/3+1);
		if(sd.visitedS[squareI][number]) {
			return true;
		}
		return false;
	}


	public boolean dfs(Sudoku sd, int nowDepth) {
		if(nowDepth == sd.targetDepth) {
			return true;
		}

		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(sd.sudoku[i][j] == 0) {	// 스도쿠 숫자가 0이라면 검사 시작
					int squareI = ((i-1)/3*3) + ((j-1)/3+1);
					for(int k = 1; k <= 9; k++) {

						if(!isNotPossible(sd, i, j, k)) {	// i,j 위치에 숫자k가 위치할 수 있다면
							sd.sudoku[i][j] = k;
							sd.visitedH[i][k] = true;
							sd.visitedV[j][k] = true;
							sd.visitedS[squareI][k] = true;
							if(dfs(sd, nowDepth+1)) {
								return true;
							} else {
								sd.sudoku[i][j] = 0;
								sd.visitedH[i][k] = false;
								sd.visitedV[j][k] = false;
								sd.visitedS[squareI][k] = false;
							}
						}
						if(k == 9) {	// 여기 if까지 탔다면 1~9까지의 숫자를 골고루 다 넣지못했단의미. return하고 다시 dfs태운다.
							return false;
						}
					}

				}
			}
		}
		return false;
	}


	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		Sudoku sd = new Sudoku();
		
		for(int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= 9; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 0) {
					sd.targetDepth++;
					continue;
				}
				int squareI = ((i-1)/3*3) + ((j-1)/3+1);
				sd.sudoku[i][j] = input;	// 스도쿠 숫자 초기입력
				sd.visitedH[i][input] = true;	// 가로방향 visited 초기화
				sd.visitedV[j][input] = true;	// 세로방향 visited 초기화
				sd.visitedS[squareI][input] = true;	// 3x3 사각형 visited 초기화
			}
		}

		main.dfs(sd, 0);

		// 출력
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				bw.write(sd.sudoku[i][j] + " ");
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
