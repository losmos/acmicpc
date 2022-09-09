/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10872
 	문제번호 : 10872
 	알고리즘 : 수학, 구현, 조합론
*/
package Step_09_재귀.a10872_팩토리얼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
	
	public int runFactorial(int _N) {
		if(_N == 1 || _N == 0) {	// _N - 1하면서 재귀호출하다가 _N 이 1이되면 return 1, 0 입력일경우 0! 도 = 1
			return 1;
		}
		
		return _N * runFactorial(_N - 1);
	}

	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int result = main.runFactorial(n);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}