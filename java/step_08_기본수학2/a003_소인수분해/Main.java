/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/11653
 	������ȣ : 11653
 	�˰��� : ����, ������, �Ҽ� ����
*/
package step_08_�⺻����2.a003_���μ�����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �Ҽ����� Ŭ����
class PrimeNumberInfo
{
	public int primeNumber;				// ���μ����� ���� ��(�Ҽ�)
	public int remainder;				// ���μ������ϰ� ���� ��������
	public boolean continueYn; 			// ���μ����� continue ����. true��� ��� ����. false��� ���μ����� Stop
	
	//������ �����ε�
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
			if(_N % i == 0)	// ���μ����� ����
			{
				return new PrimeNumberInfo(i, _N/i, true);	// i:������(�Ҽ�), _N/i:��������, true:���μ����� ����ؼ� ��
			}
		}
		
		// for�� �ȿ��� return ���ϰ� ��������°Ÿ� ���̻� ���μ� ���ٴ��ǹ���.
		// _N : �Ҽ�, -1 : �ǹ̾��� ������, false : ���μ����� Stop flag
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
		
		PrimeNumberInfo pni = main.getFactorizationInfo(N);	// ù��° getFactorizationInfo �޼ҵ� ���ϸ鼭 pni �ʱ�ȭ
		bw.write(String.valueOf(pni.primeNumber)+"\n");		// ���

		while(pni.continueYn)								// ���μ����� Continue Flag(PrimeNumberInfo.continueYn)�� true�϶����� ��� ����
		{
			pni = main.getFactorizationInfo(pni.remainder);	// getFactorizationInfo call
			bw.write(String.valueOf(pni.primeNumber)+"\n");	// ���
		}

		bw.flush();
		bw.close();
	}
}