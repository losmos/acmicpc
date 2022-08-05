/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10757
 	문제번호 : 10757
 	알고리즘 : 수학, 구현, 사칙연산, 임의 정밀도/큰 수 연산
*/
package step_07_기본수학1.a008_큰수A더하기B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public int[] convertArr(String _paramStr)
	{
		char[] charArray = _paramStr.toCharArray();
		
		int[] intArray = new int[charArray.length];
	
		for(int i=0; i<charArray.length; i++)
		{
			intArray[i] = Character.getNumericValue(charArray[i]);
		}
		
		return intArray;
	}
	
	public String calc(int[] _aArr, int[] _bArr)
	{
		int length = _aArr.length >= _bArr.length ? _aArr.length : _bArr.length;
		String result = "";
		int carry = 0;

		boolean _aArrOvered = true;	// true : loop도는중에 _aArr의 length를 넘지않았음. false : 넘었음
		boolean _bArrOvered = true; // true : loop도는중에 _bArr의 length를 넘지않았음. false : 넘었음
		
		int overedIndexA = 0;
		int overedIndexB = 0;
		
		for(int i=0; i<length+1; i++)
		{
			int a = 0;		// A문자열의 맨 끝 1자리 추출
			int b = 0;		// B문자열의 맨 끝 1자리 추출
			
			
			if(_aArrOvered)				// 아직 length 안넘었다면
			{
				a = _aArr[_aArr.length-1-i];
			}
			else						// 넘었으면 0
			{
				a = 0;
			}
			
			if(_bArrOvered)				// 아직 length 안넘었다면
			{
				b = _bArr[_bArr.length-1-i];
			}
			else
			{
				b = 0;					// 넘었으면 0
			}
			
			
			if(carry == 0 && (!_aArrOvered || !_bArrOvered))	// carry가 발생하지않았고, A나 B의 문자열중 짧은한쪽의 숫자까지 모두다 더했을경우.
			{
				if(!_aArrOvered)		// 짧은게 A라면 B의 나머지 문자열을 result 앞에다가 붙임
				{
					int remainLength = _bArr.length - overedIndexA - (i - overedIndexA);
					for(int j=0; j<remainLength; j++)
					{
						result = _bArr[remainLength-1-j] + result;
					}
				}
				else if(!_bArrOvered)	// 짧은게 B라면 A의 나머지 문자열을 result 앞에다가 붙임
				{
					int remainLength = _aArr.length - overedIndexB - (i - overedIndexB);
					for(int j=0; j<remainLength; j++)
					{
						result = _aArr[remainLength-1-j] + result;
					}
				}
				
				break;
			}
			
			int plus = a + b + carry;
			result = plus%10 + result;	// result 문자열 만들기
			
			if(plus >= 10 && (_aArrOvered || _bArrOvered))	// carry가 발생했다면
			{
				carry = plus / 10;
			}
			else
			{
				carry = 0;
			}
			
			
			if(i == _aArr.length-1)
			{
				_aArrOvered = false;	// length 넘었음
				overedIndexA = i+1;		// over된 시점의 index i값 저장
			}
			if(i == _bArr.length-1)
			{
				_bArrOvered = false;	// length 넘었음
				overedIndexB = i+1;		// over된 시점의 index i값 저장
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int[] aIntArray = main.convertArr(A);
		int[] bIntArray = main.convertArr(B);
		
		String result = main.calc(aIntArray, bIntArray);
		
		bw.write(result);
		bw.flush();
		bw.close();
	}
}