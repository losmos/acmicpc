/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1157
 	문제번호 : 1157
 	알고리즘 : 구현, 문자열
*/
package Step_06_문자열.a005_단어공부;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_메모리초과 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		sb.append(br.readLine().toUpperCase());		// 문자 UpperCase()
		int resultLength = 100000;
		String resultStr = "";
		boolean commonVictory = false;				// 제일 다수개 출현한 문자 개수가 2개 이상이라면  true. 최종적으로 "?"문자를 리턴
		String getSplitChar = "";
		String replacedStr = "";
		
		// 아마도 replaceAll로 인한 메모리초과
		for(int i=0; i<sb.length(); i++)
		{
			getSplitChar = String.valueOf(sb.charAt(i));
			
			replacedStr = sb.toString().replaceAll(getSplitChar, "");	// 검사하고자하는 문자를 공백("")으로 replaceAll 함
			
			if(resultLength > replacedStr.length())		// replaceAll한 문자길이가 제일 짧다면, sb.charAt(i) 문자가 제일 많이 들어가있다는 의미
			{
				resultStr =  getSplitChar;
				resultLength = replacedStr.length();
				commonVictory = false;
			}
			else if(resultLength == replacedStr.length() && !resultStr.equals(getSplitChar))	// 문자출현이 횟수가 동률이면서, 같은문자가 아닌경우
			{
				commonVictory = true;		
			}
		}
		
		if(commonVictory)
		{
			resultStr = "?";
		}
		
		bw.write(resultStr);
		bw.flush();
		bw.close();
		
	}
}