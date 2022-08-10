/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1316
 	문제번호 : 1316
 	알고리즘 : 구현, 문자열
*/
package Step_06_문자열.a1316_그룹단어체커;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	
	public boolean checkGroupWord(StringBuilder _checkingWord)
	{
		StringBuilder checkingWord = null;
		
		int index = 0;
		for(int i=0; i<_checkingWord.length(); i++)
		{
			checkingWord = new StringBuilder(_checkingWord.toString());			// 검사할 문자열 초기화
			index = checkingWord.toString().indexOf(_checkingWord.charAt(i));	// 검사할 char 문자가 최초로나온 index 저장
			
			// replace하면서 문자를 하나씩없애가며 indeOf함수로 체크하며 불연속적으로 위치할때 return false
			for(int j=0; j<_checkingWord.length(); j++)
			{
				if(checkingWord.toString().indexOf(_checkingWord.charAt(i)) - index > 0)
					
				{
					return false;	// 그룹함수 아님
				}
				
				checkingWord = checkingWord.replace(i, i+1, "");
			}
			
		}
		
		return true;		// 검사를 모두 통과했다면 그룹단어임.
	}
	
	public static void main(String[] args) throws IOException
	{
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 시행횟수 N
		
		
		int result = 0;
		while(N-- > 0)
		{
			st = new StringTokenizer(br.readLine());			// 문자열 입력
			if(main.checkGroupWord(sb.append(st.nextToken())))	//그룹단어 체크 메소드 호출
			{
				result ++;				// 그룹단어를 의미하는 return true일경우 result값 +1
			}
			
			sb.delete(0,sb.length());	//sb clear
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		

		
	}
}