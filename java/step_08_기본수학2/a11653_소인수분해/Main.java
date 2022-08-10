/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11653
 	문제번호 : 11653
 	알고리즘 : 수학, 정수론, 소수 판정
*/
package Step_08_기본수학2.a11653_소인수분해;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 소수정보 클래스
class PrimeNumberInfo
{
	public int primeNumber;				// 소인수분해 나눈 값(소수)
	public int remainder;				// 소인수분해하고 남은 나머지값
	public boolean continueYn; 			// 소인수분해 continue 여부. true라면 계속 진행. false라면 소인수분해 Stop
	
	//생성자 오버로딩
	public PrimeNumberInfo(int primeNumber, int remainder, boolean continueYn) {
		this.primeNumber = primeNumber;
		this.remainder = remainder;
		this.continueYn = continueYn;
	}
}

public class Main {
	
	public PrimeNumberInfo getFactorizationInfo(int _N)
	{
		for(int i=2; i<_N; i++)
		{
			if(_N % i == 0)	// 소인수분해 성공
			{
				return new PrimeNumberInfo(i, _N/i, true);	// i:나눈값(소수), _N/i:나머지값, true:소인수분해 계속해서 ㄱ
			}
		}
		
		// for문 안에서 return 못하고 여기까지온거면 더이상 소인수 없다는의미임.
		// _N : 소수, -1 : 의미없음 사용안함, false : 소인수분해 Stop flag
		return new PrimeNumberInfo(_N, -1, false);
	}
	
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1)
		{
			System.exit(0);
		}
		
		PrimeNumberInfo pni = main.getFactorizationInfo(N);	// 첫번째 getFactorizationInfo 메소드 콜하면서 pni 초기화
		bw.write(String.valueOf(pni.primeNumber)+"\n");		// 출력

		while(pni.continueYn)								// 소인수분해 Continue Flag(PrimeNumberInfo.continueYn)가 true일때까지 계속 수행
		{
			pni = main.getFactorizationInfo(pni.remainder);	// getFactorizationInfo call
			bw.write(String.valueOf(pni.primeNumber)+"\n");	// 출력
		}

		bw.flush();
		bw.close();
	}
}