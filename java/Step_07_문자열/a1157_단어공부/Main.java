/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1157
 	문제번호 : 1157
 	알고리즘 : 구현, 문자열
*/
package Step_07_문자열.a1157_단어공부;

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
		
		sb.append(br.readLine().toUpperCase());		// 문자 UpperCase()
		
		char A = 'A';
		char Z = 'Z';
		
		int[] alphabet = new int[Z - A + 1];	// A ~ Z 문자개수만큼의 배열 초기화
		
		char resultStr = '\0';					// 최대 출현 문자를 담을 변수
		int resultLength = 0;					// 최대 출현 문자 횟수를 담을 변수
		
		boolean commonVictory = false;				// 제일 다수개 출현한 문자 개수가 2개 이상이라면  true. 최종적으로 "?"문자를 리턴
		
		for(int i=0; i<sb.length(); i++)
		{
			alphabet[sb.charAt(i) - A] ++;			// A ~ Z 가 가지고있는 아스키코드값만큼의 배열을 선언하면 리소스낭비. 상대주소로 쓰기위해 A만큼의 아스키코드값을 빼줌
		}
		
		for(int i=0; i<alphabet.length; i++)
		{
			if(alphabet[i] > resultLength)			// 변수에 저장했었던  최대출현 문자 횟수를 갱신한다면
			{
				resultLength = alphabet[i];			// 최대출현 문자개수 저장 
				resultStr = (char)(i+A);			// 최대출현 문자 저장
				commonVictory = false;
			}
			else if(alphabet[i] == resultLength && resultStr != (char)i)
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