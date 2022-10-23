/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1152
 	문제번호 : 1152
 	알고리즘 : 구현, 문자열
*/
package Step_07_문자열.a1152_단어의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");	// 문자열 입력받음
		
		int count = 0;
		
		while(st.hasMoreTokens())	// 공백구분으로 Tokenize 된 문자가 더 있다면 계속 loop
		{
			st.nextToken();			// Token 꺼내서 없앰
			count++;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
}