/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4948
 	문제번호 : 4948
 	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package Step_08_기본수학2.a4948_베르트랑공준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
	
	// _M 이상 _N이하의 수 중 소수인경우 출력
	public void printPrimeNumberCnt(double _M, int _N) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int resultCnt = 0;
		
		int M = (int)_M;
		int squreRoot = 0;				// 제곱근

		for( M=M+1; M <=_N; M++)				// _M이상 _N 이하의 수를 하나씩 loop 돌면서
		{
			squreRoot = (int)Math.sqrt(M);
			if(M == 2 || M == 3 || M == 5)		// _M값이 2,3,5 라면
			{
				resultCnt++;	// 소수임
				continue;
			}
			
			/*  소수인지 검사, i<=_M/6 + 1 인 이유를 24가 소수인지 판별하는 예시로 보자면
			 * 2 * 12 = 24
			 * 3 * 8 = 24
			 * 4 * 6 = 24
			 * -----------
			 * 6 * 4 = 24
			 * 8 * 3 = 24
			 * 12 * 2 = 24
			 * 
			 * a * b = 24를 만족하는 자연수 a,b가 존재할때. 이 24라는 수는 소수가 아니다라고 판별해 낼 수 있음.
			 * 근데 a * b 의 구성을보면 a 와 b의 순서만 바뀌면서 한번 반복되는 형태임을 알 수 있음.
			 * 따라서 반복되는 시점부터 계속 loop를 돌며 검사하는건 무의미함.
			 * 그러면 소수인지 판별하고자 하는 숫자를 2로나눈값까지만 검사하면 될까? 아님. 더 효율을 낼 수 있음.
			 * 위의 예시에서보면 a숫자는 늘어나고 b숫자는 줄어들다가 특정시점에서 역전되며 반복하게되는데
			 * 저 반복되는 지점을 특정지을 수가 있음.
			 * 바로 a * b = 24에서 a,b 두 수가 같아지는 지점이 역전되는 지점임.
			 * 따라서 어떠한 수 n이 주어졌을때 루트n 까지만 검사하면됨. 그 이후는 a,b 위치만바꿔 반복검사하는 경우이므로 불필요하게 검사할 필요 없음.
			 */
			for(int i=2; i <= squreRoot; i++)		
			{
				if(M % i == 0)
				{
					break;		// 소수가 아님
				}
				
				if(i == squreRoot)	// 끝까지살아남았다니. 넌 소수다
				{
					resultCnt++;
				}
			}
		}
		
		bw.write(String.valueOf(resultCnt)+"\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			
			main.printPrimeNumberCnt(n, 2*n);	// printPrimeNumber 메소드 호출
		}
	}
}