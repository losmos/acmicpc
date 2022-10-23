/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/24416
 	문제번호 : 24416
 	알고리즘 : 수학, 다이나믹 프로그래밍
*/
package Step_16_동적계획법1.a24416_알고리즘수업_피보나치수1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * [문제풀이 컨셉]
 * 메모이제이션 활용.
 * 코드1 실행횟수는 코드1번에서의 return 1 이 몇번 호출됐냐와 동일한 의미. 결국 피보나치수를 구한다면 그 수가 호출횟수.
 * 코드2의 실행횟수는 n-2 번 수행
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] fibonacci = new int[n];
		fibonacci[0] = 1;
		fibonacci[1] = 1;

		for(int i = 2; i < n; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}

		bw.write(fibonacci[n-1] + " " + (n-2));
		br.close();
		bw.flush();
		bw.close();
	}
}