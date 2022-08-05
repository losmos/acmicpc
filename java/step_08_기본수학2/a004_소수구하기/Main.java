/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1929
 	문제번호 : 1929
 	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package step_08_기본수학2.a004_소수구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
	
	// _M 이상 _N이하의 수 중 소수인경우 출력
	public boolean[] printPrimeNumber(int _M, int _N) throws IOException
	{
		boolean[] numberList = new boolean[_N];	// default : false(소수), true(소수가 아님)

		//에라토스테네스의 체
		for(int i=2; i<=_N; i++)
		{
			for(int j=1; i*j<=_N; j++)
			{
				if(numberList[i*j-1] == false)
				{
					numberList[i*j-1] = true;		// 소수가 아닌경우이므로 true값 설정
				}
			}
		}
		
		numberList[1] = false;	// 2는 소수이므로
		
		return numberList;
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] sieveOfEratosthenes = main.printPrimeNumber(M, N);	// printPrimeNumber 메소드 호출
		
		for(int i=M-1; i<N; i++)
		{
			if(sieveOfEratosthenes[i] == false)
			{
				bw.write(String.valueOf(i+1)+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}