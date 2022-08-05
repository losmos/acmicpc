/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2581
 	������ȣ : 2581
 	�˰��� : ����, ������, �Ҽ� ����
*/
package step_08_�⺻����2.a002_�Ҽ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// �Ҽ����� Ŭ����
class PrimeNumberInfo
{
	public int sumNumber;	// �Ҽ��� �� �հ�
	public int minNumber;	// �Ҽ��� min ��
	
	//������
	public PrimeNumberInfo(int sumNumber, int minNumber) {
		this.sumNumber = sumNumber;
		this.minNumber = minNumber;
	}
}

public class Main {
	
	// _M�̻� ~ _N���� ������ �ڿ��� �� �Ҽ��ΰ͵��� ����Ʈ�� �־ return ���� 
	public List<Integer> getPrimeNumberList(int _M, int _N)
	{
		List<Integer> primNumberList = new ArrayList<Integer>();	// �Ҽ�List ����
		
		for(; _M<=_N; _M++)				// _M�̻� _N ������ ���� �ϳ��� loop ���鼭
		{
			if(_M == 2 )				// _M���� 2���
			{
				primNumberList.add(_M);	// �Ҽ���
				continue;
			}
			
			for(int i=2; i<_M; i++)		// �Ҽ����� �˻�
			{
				if(_M % i == 0)
				{
					break;		// �Ҽ��� �ƴ�
				}
				
				if(i == _M-1)	// ��������Ƴ��Ҵٴ�. �� �Ҽ���
				{
					primNumberList.add(_M);		// _M�� �Ҽ���
				}
			}
		}
		
		return primNumberList;
	}
	
	// �Ҽ�List�� �޾Ƽ� �Ҽ��� �������� min����. �Ҽ�List�� ��δ� ���� sum���� ���� ��ü(PrimeNumberInfo)�� return ��
	public PrimeNumberInfo getResult(List<Integer> _primeNumberList)
	{
		int sum = _primeNumberList.get(0);		// 0�� index�� get
		int min = _primeNumberList.get(0);		// 0�� index�� get
		
		for(int i=1; i<_primeNumberList.size(); i++)	// 1�� index���� loop
		{
			sum += _primeNumberList.get(i);				// loop ���鼭 �Ҽ� �� ������
			
			if(_primeNumberList.get(i) < min)			// min�� ��������
			{
				min = _primeNumberList.get(i);
			}
		}
		
		return new PrimeNumberInfo(sum, min);			// PrimeNumberInfo ��ü sum�� min�� �ʱ�ȭ�ϸ鼭 return
	}
	
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> primeNumberList = main.getPrimeNumberList(M, N);	// �Ҽ� List �޾ƿ�
		
		if(primeNumberList.size() == 0)	// �Ҽ��� �ϳ������ٸ� -1 return
		{
			bw.write("-1");
		}
		else	// �Ҽ��� �ϳ��� �ִٸ�
		{
			PrimeNumberInfo pni = main.getResult(primeNumberList);	// sum, min�� ���ϴ� method ȣ��
			bw.write(String.valueOf(pni.sumNumber));
			bw.newLine();
			bw.write(String.valueOf(pni.minNumber));
		}
		
		bw.flush();
		bw.close();
		
		
	}
}