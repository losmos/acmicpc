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

class Main_시간초과 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		sb.append(br.readLine().toUpperCase());		// 문자 UpperCase()
		int resultLength = 0;
		char resultStr = '\0';
		boolean commonVictory = false;				// 제일 다수개 출현한 문자 개수가 2개 이상이라면  true. 최종적으로 "?"문자를 리턴
	
		// 이중for문으로 인한 시간초과
		for(int i=0; i<sb.length(); i++)
		{
			char getSplitChar = sb.charAt(i);		// 검사할 문자 추출
			
			int charLength = 0;
			
			for(int j=0; j<sb.length(); j++)
			{
				if(sb.charAt(j) == getSplitChar)	// 검사할문자가 문자열에서 검출된 경우
				{
					charLength ++;					// 총 검출된 횟수를 counting 하기 위해 +1
				}
			}
			
			if(resultLength < charLength)			// 최대검출횟수가 갱신된다면
			{
				resultStr =  getSplitChar;			// 최대검출을 갱신한 문자 저장
				resultLength = charLength;			// 검출(출현)한 횟수
				commonVictory = false;
			}
			else if(resultLength == charLength && resultStr != getSplitChar)
			{
				commonVictory = true;		
			}
		}
		
		if(commonVictory)
		{
			bw.write("?");
		}
		else
		{
			bw.write(resultStr);
		}
		
		bw.flush();
		bw.close();
		
	}
}