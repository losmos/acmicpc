/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2587
 	문제번호 : 2587
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_10_정렬.a2587_대표값2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[5];

		int sum = 0;
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];	// 입력값의 누적 합
		}

		Arrays.sort(arr);	// 정렬

		br.close();
		bw.write(String.valueOf(sum/5) + "\n");		// 평균
		bw.write(String.valueOf(arr[2]) + "\n");	// 중앙값
		bw.flush();
		bw.close();
	}
}