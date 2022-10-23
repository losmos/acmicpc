/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1934
 	문제번호 : 1934
 	알고리즘 : 수학, 정수론, 유클리드 호제법
*/
package Step_15_정수론및조합론.a1934_최소공배수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	// 최소공배수 구하는 메소드
	public int getLCM(int input1, int input2, int gcf) {
		return input1/gcf * input2/gcf * gcf;
	}

	// 최대공약수 구하는 메소드
	public int getGCD(int input1, int input2) {
		int mod = 0;
		while(true) {
			mod = input1 % input2;
			if(mod == 0) {
				break;
			}
			input1 = input2;
			input2 = mod;
		}
		return input2;
	}
	/**
	 * 먼저 유클리드 호제법으로 최대공약수를 구하고
	 * 두 수를 최대공약수로 나눈값을 곱한뒤, 다시한번더 최대공약수를곱해주면 최소공배수를 구할 수 있음.
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			int input2 = Integer.parseInt(st.nextToken());

			int gcd = 0;	// 최대 공약수(Greatest Common Divisor)
			int lcm = 0;	// 최소 공배수(Least Common Multiple)
	
			gcd = main.getGCD(input1, input2);			// 최대공약수
			lcm = main.getLCM(input1, input2, gcd);		// 최소공배수
	
			bw.write(String.valueOf(lcm) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}