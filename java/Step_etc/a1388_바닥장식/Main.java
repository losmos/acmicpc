/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1388
 	문제번호 : 1388
 	알고리즘 : 구현, 그래프 이론, 그래프 탑색, 너비 우선 탐색, 깊이 우선 탐색
*/
package Step_etc.a1388_바닥장식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[][] arr = new String[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");	// 바닥장식 모양 input받아서 배열에 담는다.
		}

		int count = 0;	// 최종적으로 출력할 나무판자 개수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(j == 0) {
					if(arr[i][j].equals("-")) {	//첫열의 모양이 "-"라면 나무판자개수 +1
						count++;
						continue;
					}
				}

				if(arr[i][j].equals("-")) {			// "-" 모양이 가로로 이어져있다면 Nothing, 이어져있지않다면 count++
					if(arr[i][j-1].equals("-")) {
						// Nothing
					} else {
						count++;
					}
				} else if(arr[i][j].equals("|")) {	// "|" 모양이 세로로 이어져있다면 Nothing, 이어져있지않다면 count++
					if(i == 0) {
						count++;
						continue;
					}
					
					if(arr[i-1][j].equals("|")) {
						// Nothing
					} else {
						count++;
					}
				}
			}
		}

		br.close();
		bw.write(count + "");
		bw.flush();
		bw.close();

	}
}