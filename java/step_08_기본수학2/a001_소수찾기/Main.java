/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1978
 	문제번호 : 1978
 	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package Step_08_기본수학2.a001_소수찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());		// 입력할 소수의 개수. 사용은안할거임
		st = new StringTokenizer(br.readLine(), " ");	// 입력된 수를 " " 공백기준으로 Tokenizer 함
		
		int primeNumberCount = 0;	// 토탈 소수개수 저장 
		
		while(st.hasMoreTokens())	// 토큰이 남아있을때 까지 loop
		{
			int inputNumber = Integer.parseInt(st.nextToken());	// 다음 토큰값
			
			if(inputNumber == 2 )		// 입력값이 2라면 소수임
			{
				primeNumberCount++;		// 소수개수 +1
				continue;
			}
			
			// i는 0이나 1부터시작할필요 없음.
			for(int i=2; i<inputNumber; i++)
			{
				if(inputNumber%i == 0)			// 소수인 조건임. i로 나눈 나머지가 0이라면 소수가 아님. 
				{
					break;		// 소수가 아님
				}
				
				if(i == inputNumber-1)			// 입력숫자 - 1까지 검사했는데도 나눠떨어지는게없으면
				{
					primeNumberCount++;			// 소수니까 소수개수 +1
				}
				
			}
		}
		
		bw.write(String.valueOf(primeNumberCount));	// 출력
		bw.flush();
		bw.close();
		
	}
}