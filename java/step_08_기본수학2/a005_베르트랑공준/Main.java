/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1929
 	문제번호 : 1929
 	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package step_08_기본수학2.a005_베르트랑공준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
	
	// _M 이상 _N이하의 수 중 소수인경우 출력
	public void printPrimeNumber(int _M, int _N) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(; _M<=_N; _M++)				// _M이상 _N 이하의 수를 하나씩 loop 돌면서
		{
			if(_M == 2 )				// _M값이 2라면
			{
				bw.write(String.valueOf(_M)+"\n");	// 소수임. 출력
				continue;
			}
			
			for(int i=2; i<_M; i++)		// 소수인지 검사
			{
				if(_M % i == 0)
				{
					break;		// 소수가 아님
				}
				
				if(i == _M-1)	// 끝까지살아남았다니. 넌 소수다
				{
					bw.write(String.valueOf(_M)+"\n");	// 출력
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		main.printPrimeNumber(M, N);	// printPrimeNumber 메소드 호출
	}
}