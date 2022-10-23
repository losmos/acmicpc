/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3053
 	문제번호 : 3053
 	알고리즘 : 수학, 기하학
*/
package Step_13_기하1.a3053_택시기하학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int R = Integer.parseInt(br.readLine());	// 1제곱미터의 넓이에 자라는 참외의 개수

		double pi = Math.PI;
		bw.write(String.valueOf(R*R*pi) + "\n");
		bw.write(String.valueOf(R*R*2));
		
		br.close();
		bw.flush();
		bw.close();
	}
}