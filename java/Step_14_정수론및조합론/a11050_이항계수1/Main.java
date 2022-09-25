/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11050
 	문제번호 : 11050
 	알고리즘 : 수학, 구현, 조합론
*/
package Step_14_정수론및조합론.a11050_이항계수1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	/**
	 * N개의 물건 중 순서를 고려하지 않고 K개를 고르는 경우의 수, 이항 계수를 구하는 문제
	 * N K의 이항계수 구하는 공식 : N! / (N - K)! * K!
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if( K == 0 || N - K == 0) {
			bw.write("1");
		} else {
			int nFactorial = N;
			for (int i = N-1; i > 1; i--) {
				nFactorial = nFactorial * i;
			}
	
			int nk = N - K;
			int nkFacitroal = nk;
			for (int i = nk-1; i > 1; i--) {
				nkFacitroal = nkFacitroal * i;
			}
	
			int kFactorial = K;
			for (int i = K-1; i > 1; i--) {
				kFactorial = kFactorial * i;
			}
	
			// 위의 if에서 0처리해 주지 않으면 0으로나누면서 "java.lang.ArithmeticException: / by zero" Exception 발생함
			bw.write(String.valueOf(nFactorial / (nkFacitroal * kFactorial)));
		}

		br.close();
		bw.flush();
		bw.close();
	}
}