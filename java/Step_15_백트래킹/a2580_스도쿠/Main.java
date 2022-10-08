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
 * 가로,세로,3x3사각형 영역에서 숫자가 들어갈 수 있는지 검사함
 */
class Sudoku {
	int[][] sudoku = new int[9][9];

	Sudoku() {

	}
}

public class Main {
	
	public void dfs(Sudoku sd) {
		
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		Sudoku sd = new Sudoku();
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sd.sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}


	}
}
