/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2908
 	문제번호 : 2908
 	알고리즘 : 수학, 구현
*/
package step_06_문자열.a007_상수;

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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		String strA = st.nextToken();	// 첫번? 세자리 숫자
		String strB = st.nextToken();	// 두번째 세[자리 숫자

		int multiple = 100;
		int tempNumA = Integer.parseInt(strA);	// int로 변환
		int tempNumB = Integer.parseInt(strB);	// int로 변환
		
		int numA = 0;
		int numB = 0;
		
		for(int i=0; i<3; i++)
		{
			numA += tempNumA % 10 * multiple;	// 맨 뒷 자리수에 multiple 만큼 곱한값을 결과에 담음
			tempNumA = tempNumA / 10;
			
			numB += tempNumB % 10 * multiple;
			tempNumB = tempNumB / 10;
			
			multiple = multiple / 10;			// multiple은 loop를 돌때마다 나누기 10해줌
		}
		
		if(numA > numB)
		{
			bw.write(String.valueOf(numA));
		}
		else
		{
			bw.write(String.valueOf(numB));
		}
		
		bw.flush();
		bw.close();
		
	}
}