/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1018
 	문제번호 : 1018
 	알고리즘 : 브루트포스 알고리즘
*/
package Step_10_브루트포스.a1018_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	/** 특정 index로부터시작하는 8 x 8 칸짜리 slice를 만들어서 return */
	public String[][] getSlice(String[][] _board, int _startX, int _startY) {
		String[][] slice = new String[8][8];


		int index = 0;
		int skipCnt = 0;
		for(String[] item : _board) {
			if(index == 8) {
				break;
			}

			if(skipCnt++ < _startX) {
				continue;
			}

			slice[index++] = Arrays.copyOfRange(item, _startY, _startY + 8);
		}
		return slice;
	}

	/** 8 x 8 짜리 칠판모양 배열을 넘겨받아 체스판으로 완성하기위해 필요한 최소 painting 횟수를 return 
	 * 맨왼쪽 위 색깔이 white로 시작하는 경우와 black으로 시작하는 총 두가지경우 중에 최소 painting 횟수를 return함
	*/
	public int howManyPaint(String[][] _board) {

		// 맨왼쪽 위가 white인경우 색칠 cnt
		int caseWhiteCnt = 0;
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 8; j ++) {
				if((i + j) % 2 == 0) {	// 짝수인경우 white 칠할차례
					if(!_board[i][j].equals("W")) {
						// _board[i][j]="W";
						caseWhiteCnt += 1;
					}
				} else {	// 홀수인 경우 black 칠할 차례
					if(!_board[i][j].equals("B")) {
						// _board[i][j]="B";
						caseWhiteCnt += 1;
					}
				}
			}
		}

		// 맨왼쪽 위가 black인경우 색칠 cnt
		int caseBlackCnt = 0;
		for(int i = 0; i < 8; i ++) {
			for(int j = 0; j < 8; j ++) {
				if((i + j) % 2 == 0) {	// 짝수인경우 black 칠할차례
					if(!_board[i][j].equals("B")) {
						// _board[i][j]="B";
						caseBlackCnt += 1;
					}
				} else {	// 홀수인 경우 white 칠할 차례
					if(!_board[i][j].equals("W")) {
						// _board[i][j]="W";
						caseBlackCnt += 1;
					}
				}
			}
		}

		if(caseWhiteCnt < caseBlackCnt) {
			return caseWhiteCnt;
		} else {
			return caseBlackCnt;
		}
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		String[][] board = new String[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

		for(int i = 0; i < board.length; i ++) {		// 칠판 초기화
			String input = br.readLine();
			for(int j = 0; j < board[0].length; j ++) {
				board[i][j] = String.valueOf(input.charAt(j));
			}
		}

		int minResult = 64;
		for(int i = 0; i <= board.length - 8; i++) {			// 행 길이
			for(int j = 0; j <= board[0].length - 8; j++) {		// 열 길이
				int paintingCnt = main.howManyPaint(main.getSlice(board, i, j));
				if(paintingCnt < minResult) {	// 체스판을 만들기위한 최소 painting횟수 갱신
					minResult = paintingCnt;
				}
			}
		}

		bw.write(String.valueOf(minResult));
		bw.flush();
		bw.close();
	}
}