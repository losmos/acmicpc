/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2566
 	문제번호 : 2566
 	알고리즘 : 구현
*/
package Step_05_2차원배열.a2566_최댓값;

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

		int[][] arr = new int [9][9];
		int max = 0, maxI = 1, maxJ = 1;	// max : max값, maxI : max값이나온 i인덱스, maxJ : max값이나온 j 인덱스

		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	// input

				if(arr[i][j] > max) {
					max = arr[i][j];
					maxI = i+1;
					maxJ = j+1;
				}
			}
		}

		br.close();
		bw.write(max + "\n");
		bw.write(maxI + " " + maxJ + "\n");
		bw.flush();
		bw.close();
	}
}