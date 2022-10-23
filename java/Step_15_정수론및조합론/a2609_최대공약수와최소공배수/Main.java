/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2609
 	문제번호 : 2609
 	알고리즘 : 수학, 정수론, 유클리드 호제법
*/
package Step_15_정수론및조합론.a2609_최대공약수와최소공배수;

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
	public int getGCF(int input1, int input2) {
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
		st = new StringTokenizer(br.readLine());

		int input1 = Integer.parseInt(st.nextToken());
		int input2 = Integer.parseInt(st.nextToken());
		int gcf = 0;	// 최대 공약수(Greatest Common Factor)
		int lcm = 0;	// 최소 공배수(Least Common Multiple)
		
		

		gcf = main.getGCF(input1, input2);			// 최대공약수
		lcm = main.getLCM(input1, input2, gcf);		// 최소공배수

		bw.write(String.valueOf(gcf) + "\n");
		bw.write(String.valueOf(lcm) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}
}