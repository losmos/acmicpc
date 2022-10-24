/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2563
 	문제번호 : 2563
 	알고리즘 : 구현
*/
package Step_05_2차원배열.a2563_색종이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		boolean[][] whiteBoard = new boolean[100][100];	// 흰색 도화지

		int n = Integer.parseInt(br.readLine());	// 덮어씌울 색종이 개수

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 색종이의 좌표(행)
			int b = Integer.parseInt(st.nextToken());	// 색종이의 좌표(열)

			for(int j = a, range1 = j + 10; j < range1; j++) {
				for(int k = b, range2 = k + 10; k < range2; k++) {
					if(!whiteBoard[j][k]) {
						whiteBoard[j][k] = true;
					}
				}
			}
		}

		int sum = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(whiteBoard[i][j]) {	// 색종이가 붙어있는 범위인지 체크
					sum++;
				}
			}
		}

		br.close();
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}