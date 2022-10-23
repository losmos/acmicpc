/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2004
 	문제번호 : 2004
 	알고리즘 : 수학, 정수론
*/
package Step_15_정수론및조합론.a1676_팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

class Main {

	/**
	 * factorial을 연산하기위한 for문안에서 매번 1의자리수가 0인지 체크를함.
	 * 1의자리수가 0이라면 result++ 해주고, 나누기 10해주면서 0을 없앰.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		BigInteger factorial = new BigInteger("1");	// 팩토리얼 숫자

		int result = 0;	// 최종 출력할 0의개수 담을 변수
		for(int i = N; i > 0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
			
			// 10으로 나눴다가 다시 10으로곱해준값이 원래값과 동일하다는 뜻은. 1의자리수가 0이라는 의미.
			if(factorial.divide(BigInteger.valueOf(10)).multiply(BigInteger.valueOf(10)).equals(factorial)) {
				result++;	// 0의 개수 +1
				factorial = factorial.divide(BigInteger.valueOf(10));	// factorial를 10으로나눠주면서 1의자리수 0을 없앰(오른쪽으로 시프트)
			}
		}

		bw.write(String.valueOf(result));
		br.close();
		bw.flush();
		bw.close();
	}
}