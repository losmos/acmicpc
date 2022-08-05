/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5622
 	문제번호 : 5622
 	알고리즘 : 구현
*/
package step_06_문자열.a008_다이얼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char A = 'A';
		char Z = 'Z';
		
		// dial 전화기 번호 순서대로 소요시간값을 넣었음
		int[] dial = new int[]{2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10,13};
		
		sb.append(br.readLine());
		
		int result = 0;
		
		for(int i=0; i<sb.length(); i++)
		{
			result += dial[sb.toString().charAt(i) - A + 1];
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}
}