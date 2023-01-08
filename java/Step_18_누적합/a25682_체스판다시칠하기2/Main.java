/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25682
 	문제번호 : 25682
 	알고리즘 : 누적 합
*/
package Step_18_누적합.a25682_체스판다시칠하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * (누적합 알고리즘 방식은 개인적으로 정리해둔 "문제풀이 설명.pptx" 참고)
 * 
 * 다시 칠해야될 개수 누적합을 구한다.(B로시작하는 경우, W로시작하는경우를 각각 따로 구해둔다.)
 * 다 구한뒤에는 반복문을통해 K범위만큼의 누적합의 구간합(K * K 범위)을 빠르게 구한뒤, 그 중 가장 최소값을 출력한다.
 */
public class Main {
	/**
	 * (0,0) 좌표가 startColor로 시작하는경우의 누적합 배열을 만들어주는 메소드
	 * @param board : 지민이가 찾은 보드
	 * @param _prefixSum : 최종적으로 만들 누적합 배열
	 * @param startColor : (0,0) 시작 색깔
	 * @param N : 보드 세로길이
	 * @param M : 보드 가로길이
	 */
	public void fillPrefixSumm(char[][] board, int[][] _prefixSum, char startColor, int N, int M) {

		char nowColor = startColor;
		if(board[0][0] != nowColor) {	// (0,0) 좌표 초기화
			_prefixSum[0][0] = 1;		// 시작 색깔이 다를경우, 고쳐야될횟수를 의미하는 1을 넣어주고 시작
		}

		// board[i][0] 세로방향 누적합 구하기
		for(int i = 1; i < N; i++) {
			nowColor = changeColor(startColor, i, 0);	// 현재 좌표에 칠해야될 색깔
			if(board[i][0] != nowColor) {
				_prefixSum[i][0] = _prefixSum[i-1][0] + 1;
			} else {
				_prefixSum[i][0] = _prefixSum[i-1][0];
			}
		}
		
		// board[0][j] 가로방향 누적합 구하기
		for(int j = 1; j < M; j++) {
			nowColor = changeColor(startColor, 0, j);	// 현재 좌표에 칠해야될 색깔
			if(board[0][j] != nowColor) {
				_prefixSum[0][j] = _prefixSum[0][j-1] + 1;
			} else {
				_prefixSum[0][j] = _prefixSum[0][j-1];
			}
		}

		// 인접한 왼쪽값, 인접한 윗쪽값, 인접한 왼쪽위대각값을 가지고 누적합구하기
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				nowColor = changeColor(startColor, i, j);
				_prefixSum[i][j] = _prefixSum[i][j-1] + _prefixSum[i-1][j] - _prefixSum[i-1][j-1];

				if(nowColor != board[i][j]) {	
					_prefixSum[i][j]++;	// 현재 좌표도 색을칠해야된다면 + 1 해준다.
				}
			}
		}
	}

	// 시작점(0,0)의 기준색깔을 기준으로, 특정 좌표일때 칠해져야하는 색깔을 return 해준다.
	public char changeColor(char basicColor, int i, int j) {
		char changeColor;
		if(basicColor == 'W') {
			changeColor = 'B';
		} else {
			changeColor = 'W';
		}

		if((i + j) % 2 == 0) {
			return basicColor;
		} else {
			return changeColor;
		}
	}

	// K * K 크기의 체스판을 검사한다. 색깔을바꾸는 최소값을 구해서 return 함.
	public int checkChessBoard(int[][] _prefuxSum, int N, int M, int K) {
		int min = K * K;	// 최대값은 K * K 전부다 바꾸는 경우의 수

		for(int i = K-1; i < N; i++) {
			for(int j = K-1; j < M; j++) {

				int calcCnt = 0;
				int result = _prefuxSum[i][j];	// 최종적으로 색깔을 바꿔야되는 횟수
				if(i-(K-1) > 0) {	// 위쪽방향으로 빼야될 누적합값이 있다면
					result -= _prefuxSum[i-K][j];
					calcCnt++;
				}
				
				if(j-(K-1) > 0) {	// 왼쪽방향으로 빼야될 누적합값이 있다면
					result -= _prefuxSum[i][j-K];
					calcCnt++;
				}

				if(calcCnt == 2) {	// 왼쪽방향, 위쪽방향 한번씩 누적값을 빼줬다면 북서대각방향 좌표값을 중복으로 두번 빼줬기 때문에, 더해서 보정해준다.
					result += _prefuxSum[i-K][j-K];
				}

				if(result < min) {	// 색깔을 바꾸는 경우의 최소값 갱신
					min = result;
				}
			}
		}

		return min;
	}	

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 세로 길이
		int M = Integer.parseInt(st.nextToken());	// 가로 길이
		int K = Integer.parseInt(st.nextToken());	// 잘라낼 체스판 K * K 에서의 길이

		char[][] board = new char[N][M];		//  지민이 저택에서 찾은 보드
		int[][] W_prefixSum = new int[N][M];	//  보드의 (0,0)좌표가 W부터 시작하는 경우일때의 누적합 배열 
		int[][] B_prefixSum = new int[N][M];	//  보드의 (0,0)좌표가 B부터 시작하는 경우일때의 누적합 배열

		for(int i = 0; i < N; i ++) {	// 저택에서 찾은 보드 초기화
			board[i] = br.readLine().toCharArray();
		}

		main.fillPrefixSumm(board, W_prefixSum, 'W', N, M);	// (0,0) 좌표가 W로 시작하는경우의 누적합 배열 생성
		main.fillPrefixSumm(board, B_prefixSum, 'B', N, M);	// (0,0) 좌표가 B로 시작하는경우의 누적합 배열 생성
		
		int result = Math.min(main.checkChessBoard(W_prefixSum, N, M, K), main.checkChessBoard(B_prefixSum, N, M, K));	// 다시 칠해야 하는 정사각형 개수의 최소값 계산

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.flush();
	}
}