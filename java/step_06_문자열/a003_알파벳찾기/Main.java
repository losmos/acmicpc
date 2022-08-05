/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11720
 	문제번호 : 11720
 	알고리즘 : 수학, 구현, 문자열
*/
package Step_06_문자열.a003_알파벳찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	
	/*
	 * param1 : 입력받은 최초의 문자열
	 * param2 : a ~ z 중 현재 검사할 문자열
	 */
	public String findIdx(StringBuilder _inputStr, char _targetChar)
	{
		for(int i=0; i<_inputStr.length(); i++)
		{
			if(_inputStr.charAt(i) == _targetChar)
			{
				return String.valueOf(i);
			}
		}
		
		return "-1";
	}
	
	public static void main(String[] args) throws IOException
	{
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char startChar = 'a';		// 입력받을수있는 범위의 a ~ z 숫자중 첫번째 문자 아스키 코드값
		char endChar = 'z';			// 입력받을수있는 범위의 a ~ z 숫자중 마지막 문자 아스키 코드값
		sb.append(br.readLine());

		String result = "";			// 최종 결과를 담을 변수
		
		for(; startChar <= endChar; startChar++)		// 아스키코드 a ~ z 까지 loop
		{
			result += main.findIdx(sb, startChar) + " ";	// findIdx 메소드 호출
			
		}

		bw.write(result);
		bw.flush();
		bw.close();
		
	}
}