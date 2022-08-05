/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2675
 	문제번호 : 2675
 	알고리즘 : 구현, 문자열
*/
package step_06_문자열.a004_문자열반복;

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
		
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 T
		
		for(int i=0; i<T; i++)
		{
			String result = "";

			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());	// 테스트 케이스 반복횟수 R
			String inputStr = "";
			
			inputStr = st.nextToken();					// 반복을 수행할 input 문자열
			
			for(int x=0; x<inputStr.length(); x++)
			{
				for(int j=0; j<R; j++)
				{
					result+=inputStr.charAt(x);			// 입력된 문자열에서 한글자씩 잘라서 입력된 R만큼 반복해서 append
				}
			}
			bw.write(result.toString() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}