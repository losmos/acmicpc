/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2231
 	문제번호 : 2231
 	알고리즘 : 브루트포스 알고리즘
*/
package Step_12_브루트포스.a2231_분해합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {

	/** 파라미터로 넘어오는 int값의 생성자를 구하는 메소드 */
	public int getResult(int _number) {
		int number = _number;
		while(true) {
			if (_number < 10) {
				number = number + _number;
				break;
			}

			number = number + (_number % 10);	// 1의자리수 를 더해줌
			_number = _number / 10;				// >> 쉬프트
		}
		return number;
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());	// 입력값N의 가장 작은 생성자를 구할거임

		for(int i = 0; i < N; i ++)  {
			if (main.getResult(i) == N) {		// i의 분해합이 N인경우(== i가 N의 생성자인경우)
				bw.write(String.valueOf(i));
				break;
			}

			if(i == N-1) {						// 루프 마지막까지 조건을 만족 못할경우
				bw.write("0");				// 생성자 없음
			}
		}

		bw.flush();
		bw.close();
	}
}