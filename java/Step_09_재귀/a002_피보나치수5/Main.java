/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10870
 	문제번호 : 10870
 	알고리즘 : 수학, 구현
*/
package Step_09_재귀.a002_피보나치수5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public int getFibonacci(int _preVal1, int _preVal2, int _index, int _n) {
		if(_index == _n)	// 입력값 n에도달하면 _preVal1 값 return
		{
			return _preVal1;
		}

		int preVal = _preVal2;
		int nowVal = _preVal1 + _preVal2;	// 현재단계의 피보나치 수는, 넘어온 파라미터 _preVal + _nowVal이 현재값임.

		return getFibonacci(preVal, nowVal, _index + 1, _n);	// 다음단계의 피보나치 수를 파라미터로 넘김
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int result = main.getFibonacci(0, 1, 0, n);		// 피보나치 수열 시작

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}