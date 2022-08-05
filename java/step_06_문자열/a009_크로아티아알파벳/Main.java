/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2941
 	문제번호 : 2941
 	알고리즘 : 구현, 문자열
*/
package Step_06_문자열.a009_크로아티아알파벳;

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

		String[] croatia = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		sb.append(br.readLine());		// 문자열 입력받음
		
		String sbStr = sb.toString();	// 입력받은 문자열 sbStr 변수에 담음
		String replaceStr = sbStr;			// replace한 결과 임시로 담을 변수
		
		int checkLength = sbStr.length();
		int wordCount = 0;
		for(int i=0; i<croatia.length; i++)
		{
			replaceStr = replaceStr.replaceAll(croatia[i], "0");		// 0으로 replace 수행
			if(checkLength != replaceStr.length())				// replaceAll로 변한값이 있다면
			{
				wordCount += (checkLength - replaceStr.length()) / (croatia[i].length()-1);	// 변한만큼의 길이를 계산해서 단어 수 counting (-1을 해주는건 replaceAll을통해 "0"으로 바꿔주기때문에 "0"만큼의 length를 고려함)
				checkLength = replaceStr.length();
			}
		}
		
		wordCount += replaceStr.length() - (replaceStr.length() - replaceStr.replaceAll("0", "").length());	// replaceAll 하고 남은 나머지 문자는 크로아티아 알파벳이 아니므로, length 1개당 문자 1개씩 취급해서 더해줌
		
		bw.write(String.valueOf(wordCount));
		bw.flush();
		bw.close();
		
	}
}