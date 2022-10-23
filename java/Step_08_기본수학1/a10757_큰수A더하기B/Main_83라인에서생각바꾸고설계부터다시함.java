/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10757
 	문제번호 : 10757
 	알고리즘 : 수학, 구현, 사칙연산, 임의 정밀도/큰 수 연산
*/
package Step_07_기본수학1.a10757_큰수A더하기B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_83라인에서생각바꾸고설계부터다시함 {
	
	public int calc(StringBuilder _A, StringBuilder _B, int _carry)
	{
		int a = Character.getNumericValue(_A.charAt(_A.length()-1));	// A 문자열 맨 뒷자리수 추출
		int b = Character.getNumericValue(_B.charAt(_B.length()-1));	// B 문자열 맨 뒷자리수 추출
		int plus = a + b + _carry; 
		
		return plus;
	}
	
	public static void main(String[] args) throws IOException {
		Main_83라인에서생각바꾸고설계부터다시함 main = new Main_83라인에서생각바꾸고설계부터다시함();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder A = new StringBuilder();	// 입력값 A
		StringBuilder B = new StringBuilder();	// 입력값 B
		String result = "";						// 최종결과값
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		A.append(st.nextToken());
		B.append(st.nextToken());

		
		int ALength = A.length();	// A문자열 길이
		int BLength = B.length();	// B문자열 길이
		int carry = 0;				// 올림자리수
		
		for(int i=0; i<(ALength>=BLength?BLength:ALength); i++)	// A랑 B중에서 더 짧은 문자열 length만큼 loop 돎
		{
			int plus = main.calc(A, B, carry);
			
			if(plus >= 10)	// 자리 올림수가 발생했을경우 올림수 저장
			{
				carry = plus / 10;
			}
			else
			{
				carry = 0;
			}
			
			A.delete(A.length()-1, A.length());	// A맨 뒤 문자 삭제
			B.delete(B.length()-1, B.length());	// B맨 뒤 문자 삭제
			
			result = plus%10 + result;			// A+B더한 문자 하나하나씩 차곡차곡 result에 쌓음
		}
		
		
		if(ALength == BLength)					// A와 B의길이가 같다면
		{
			if(carry > 0)
			{
				bw.write(carry + result);		// carry가 발생했을경우 맨앞에다 붙여줌
			}
			else
			{
				bw.write(result);				// carry 없으면 그냥 출력
			}
			
		}
		else if(ALength > BLength)
		{
			if(carry > 0)	// carry가 발생했을경우, 맨끝자리 숫자와 carry를 더해줌
			{
				int secondPlus = Character.getNumericValue(A.charAt(A.length()-1)) + carry;
				int secondCarry = 0;
				if(secondPlus > 10)		// 또 캐리가 발생할경우 두수를 또 더해주는..... 아 이건 아니다싶다.
				{
					for(int i=0; i<1; i++)
					{
						
					}
				}
				else
				{
					A.replace(A.length()-2, A.length()-1, String.valueOf(secondPlus));
				}
				
			}
			else
			{
				bw.write(A + result);
			}
			
		}
		else if(ALength < BLength)
		{
			if(carry > 0)
			{
				B.replace(B.length()-2, B.length()-1, String.valueOf(Character.getNumericValue(B.charAt(B.length()-1)) + carry));
			}
			
			bw.write(B.toString() + result);
		}
		
		bw.flush();
		bw.close();
		
	}
}