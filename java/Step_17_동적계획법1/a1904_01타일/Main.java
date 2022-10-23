/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1904
 	문제번호 : 1904
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a1904_01타일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * [문제풀이 컨셉]
 * 
 * N = 1 : 1	1		1
 * N = 2 : 2	2		00 11
 * N = 3 : 3	3		001 100 111
 * N = 4 : 5	5		0000 0011 1100 1001 1111
 * N = 5 : 8	8		00001 00111 11100 10000 00100 11111 10011 11001
 * 
 * N[i] = N[i-1] + N[i-2] 의 피보나치형태의 점화식을 가짐.
 * 문제의 조건은 mod 15746값을 구하는 것이기 때문에, 모듈러 분배법칙 적용해서 풀어줌
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] tile = new int[N+1];

		tile[1] = 1;
		if(N > 1) {		// if문 없으면, N = 1 입력했을때 tile[2] 에접근하기때문에 인덱스 에러남.
			tile[2] = 2;
		}

		for(int i = 3; i <= N; i++) {
			tile[i] = ((tile[i-1] % 15746) + (tile[i-2] % 15746)) % 15746;
		}

		br.close();
		bw.write(tile[N] + "");
		bw.flush();
		bw.close();
	}
}