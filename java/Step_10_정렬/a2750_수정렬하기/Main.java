/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2750
 	문제번호 : 2750
 	알고리즘 : 구현, 정렬
*/
package Step_10_정렬.a2750_수정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];

		// input 초기화
		for(int i = 0; i < N; i ++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}

		// 출제자의 의도대로 버블버블정렬
		for(int i = 0; i < (N - 1); i ++) {
			for(int j = 0; j < (N - 1); j ++) {
				if(inputArr[j] > inputArr[j+1]) {
					int swapTemp = inputArr[j+1];
					inputArr[j+1] = inputArr[j];
					inputArr[j] = swapTemp;
				}
			}
		}

		//출력
		for(int v : inputArr) {
			bw.write(String.valueOf(v)+"\n");
		}
		bw.flush();
		bw.close();
	}
}