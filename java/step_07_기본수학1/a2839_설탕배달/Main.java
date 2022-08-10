/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2839
 	문제번호 : 2839
 	알고리즘 : 수학, 다이나믹 알고리즘, 그리디 알고리즘
*/
package Step_07_기본수학1.a2839_설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;		// 최소 설탕봉지 개수
		
		if(N % 5 == 0)		// 5kg짜리로 딱 나눠떨어진다면 그냥 5로 나누면 최소값
		{
			result = N / 5;
		}
		else
		{
			while(true)
			{
				N = N - 3;				// 3kg짜리를 하나씩 만들어가면서, 나머지 남는 양을 5kg으로 최대한 많이만들수 있다면, 최소 봉지개수를 구할 수 있음.
				result = result + 1;	// 3kg짜리 하나 만들었으니 봉지개수 + 1
				
				if( N % 5 == 0)
				{
					result = result + (N / 5);
					break;
				}
				
				if(N <= 0)
				{
					result = -1;
					break;
				}
			}
		}
		
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
	}
}