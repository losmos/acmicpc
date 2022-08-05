/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9020
 	문제번호 : 9020
 	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package Step_08_기본수학2.a006_골드바흐의추측;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
	
	public boolean conjectureGoldBach(int _n) throws IOException
	{
		int squreRoot = 0;				// 제곱근

		squreRoot = (int)Math.sqrt(_n);
		if(_n == 2 || _n == 3 || _n == 5)		// _n값이 2,3,5 라면
		{
			return true;
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
			if(_n % i == 0)
			{
				break;		// 소수가 아님
			}
			
			if(i == squreRoot)	// 끝까지살아남았다니. 넌 소수다
			{
				return true;
			}
		}

		return false;
		
	}
	
	/*
	 * 입력값 n의 절반값을 기준으로 a+b=n 일때 a,b가 소수인지 판별.
	 * 소수가 아닐경우 a++, b-- 해주면서 소수인지 계속해서 판별
	 * a,b가 둘다 소수일경우 출력
	 */
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)	// 테스트케이스 t 만큼 반복
		{
			int n = Integer.parseInt(br.readLine());	// input
	
			int a = n / 2;	// 입력값을 2로 나눈값
			int b = n - a;	// 입력값을 2로 나눈값 인데 나누기보다 - 연산이 좀더 빨라서 빼기로 구해줌
			
			boolean primeNum;
			for(int i = 0; i < a; i++)
			{
				primeNum = false;
				primeNum = main.conjectureGoldBach(a);	// printPrimeNumber 메소드 호출
				if(primeNum)
				{
					primeNum = main.conjectureGoldBach(b);
					if(primeNum)
					{
						bw.write(String.valueOf(a) + " " + String.valueOf(b) + "\n");
						break;
					}
				}
				a--;
				b++;
			}
		}

		bw.flush();
		bw.close();
	}
}