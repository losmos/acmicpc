/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3036
 	문제번호 : 3036
 	알고리즘 : 수학, 정수론, 유클리드 호제법
*/
package Step_14_정수론및조합론.a3036_링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	/**
	 * 각원의 둘레를 구하고, 첫번째원을 돌릴거기때문에 첫번재 원의 둘레에서 나머지 원의 둘레로 나누면 몇바퀴 도는지 알수있음.
	 * 
	 * (추가+) 위 방식처럼 풀려고했는데. 답이 분수형태가아니라 소수형태로나와서. 소수 => 분수로 변환해주는 작업이 추가로 들게됨
	 * 그래서 아래와 같이 방식을 바꿈
	 * 
	 * 첫번째 원의 반지름 r1과 다른 원의 반지름 r2의 최대공약수 gcd를구하고
	 * r1에서 최대공약수를 나눈 값 + "/" + r2서 최대공약수를 나눈값 으로 출력하면 됨.
	 */

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

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());	// 링의 개수
		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());	// 기준이 될 첫번째 원의 반지름
		for(int i = 1; i < N; i++) {
			int r = Integer.parseInt(st.nextToken());
			int gcd = main.getGCD(r1, r);	// 최대공약수

			bw.write(r1/gcd + "/" + r/gcd + "\n");	// 출력
		}

		br.close();
		bw.flush();
		bw.close();
	}
}