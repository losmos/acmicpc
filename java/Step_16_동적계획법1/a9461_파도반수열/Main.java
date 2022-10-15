/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9461
 	문제번호 : 9461
 	알고리즘 : 수학, 다이나믹 프로그래밍
*/
package Step_16_동적계획법1.a9461_파도반수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 
 * n = 1 : 1
 * n = 2 : 1
 * n = 3 : 1
 * n = 4 : 2,	n[1] + n[3]
 * n = 5 : 2,		 + n[4]
 * n = 6 : 3,	n[1] + n[5]
 * n = 7 : 4,	n[2] + n[6]
 * n = 8 : 5,	n[3] + n[7]
 * n = 9 : 7,	n[4] + n[8]
 * n = 10: 9,	n[5] + n[9]
 * n = 11: 12,	n[6] + n[10]
 * 
 * n[i] = n[i-5] + n[i-1]	(단, N>=6일때부터)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		long[] waveArr = new long[101];	// int형은 100입력했을때 overFlow남
		
		waveArr[1] = 1;
		waveArr[2] = 1;
		waveArr[3] = 1;
		waveArr[4] = 2;
		waveArr[5] = 2;

		for(int i = 6; i < 101; i++) {
			waveArr[i] = waveArr[i-5] + waveArr[i-1];
		}

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			sb.append(waveArr[Integer.parseInt(br.readLine())]).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}