/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11720
 	문제번호 : 11720
 	알고리즘 : 수학, 구현, 문자열
*/
package Step_06_문자열.a002_숫자의합;

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
		
		int N = Integer.parseInt(br.readLine());		// 입력은받지만 쓰이진 않음
		
		sb.append(br.readLine());						// 연속된 숫자 입력받음. 숫자길이는 100이하이므로, 숫자형 Type으로받으면 에러남
		
		String[] splitStr = sb.toString().split("");	// 한글자씩 split해서 String 배열에 넣음
		
		int result = 0;
		for(int i=0; i < splitStr.length; i++)
		{
			result += Integer.parseInt(splitStr[i]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}