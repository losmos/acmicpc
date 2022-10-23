/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1436
 	문제번호 : 1436
 	알고리즘 : 브루트포스 알고리즘
*/
package Step_11_브루트포스.a1436_영화감독숌;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	/** 666이 포함된 숫자일경우 return true */
	public boolean check666(int _param) {

		int consec = 0;		// 6이 3연속 오는지 판별할 때 쓰이는 변수

		while(_param > 0) {
			if(_param % 10 == 6) {
				consec += 6;
				if(consec / 6 == 3) {	// 6이 3연속 출현했다면
					return true;		// return true
				}
			} else {
				consec = 0;
			}
			_param = _param / 10;	// 숫자 >> 쉬프트
		}

		return false;	// 6이 3연속 X
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 666; ; i ++) {
			if(main.check666(i)) {	// 6이 3연속들어간 숫자라고 판별되면 true를 return받음
				N--;
			}

			if(N <= 0) {
				bw.write(String.valueOf(i));
				break;
			}
		}

		bw.flush();
		bw.close();
	}
}