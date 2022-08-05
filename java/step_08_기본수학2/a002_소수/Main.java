/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2581
 	문제번호 : 2581
 	알고리즘 : 수학, 정수론, 소수 판정
*/
package step_08_기본수학2.a002_소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 소수정보 클래스
class PrimeNumberInfo
{
	public int sumNumber;	// 소수의 총 합계
	public int minNumber;	// 소수중 min 값
	
	//생성자
	public PrimeNumberInfo(int sumNumber, int minNumber) {
		this.sumNumber = sumNumber;
		this.minNumber = minNumber;
	}
}

public class Main {
	
	// _M이상 ~ _N이하 사이의 자연수 중 소수인것들을 리스트에 넣어서 return 해줌 
	public List<Integer> getPrimeNumberList(int _M, int _N)
	{
		List<Integer> primNumberList = new ArrayList<Integer>();	// 소수List 저장
		
		for(; _M<=_N; _M++)				// _M이상 _N 이하의 수를 하나씩 loop 돌면서
		{
			if(_M == 2 )				// _M값이 2라면
			{
				primNumberList.add(_M);	// 소수임
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
					primNumberList.add(_M);		// _M은 소수임
				}
			}
		}
		
		return primNumberList;
	}
	
	// 소수List를 받아서 소수중 제일작은 min값과. 소수List를 모두다 더한 sum값을 가진 객체(PrimeNumberInfo)를 return 함
	public PrimeNumberInfo getResult(List<Integer> _primeNumberList)
	{
		int sum = _primeNumberList.get(0);		// 0번 index값 get
		int min = _primeNumberList.get(0);		// 0번 index값 get
		
		for(int i=1; i<_primeNumberList.size(); i++)	// 1번 index부터 loop
		{
			sum += _primeNumberList.get(i);				// loop 돌면서 소수 다 더해줌
			
			if(_primeNumberList.get(i) < min)			// min값 갱신조건
			{
				min = _primeNumberList.get(i);
			}
		}
		
		return new PrimeNumberInfo(sum, min);			// PrimeNumberInfo 객체 sum값 min값 초기화하면서 return
	}
	
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> primeNumberList = main.getPrimeNumberList(M, N);	// 소수 List 받아옴
		
		if(primeNumberList.size() == 0)	// 소수가 하나도없다면 -1 return
		{
			bw.write("-1");
		}
		else	// 소수가 하나라도 있다면
		{
			PrimeNumberInfo pni = main.getResult(primeNumberList);	// sum, min값 구하는 method 호출
			bw.write(String.valueOf(pni.sumNumber));
			bw.newLine();
			bw.write(String.valueOf(pni.minNumber));
		}
		
		bw.flush();
		bw.close();
		
		
	}
}