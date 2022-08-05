/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1929
 	������ȣ : 1929
 	�˰��� : ����, ������, �Ҽ� ����, �����佺�׳׽��� ü
*/
package step_08_�⺻����2.a005_����Ʈ������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
	
	// _M �̻� _N������ �� �� �Ҽ��ΰ�� ���
	public void printPrimeNumber(int _M, int _N) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(; _M<=_N; _M++)				// _M�̻� _N ������ ���� �ϳ��� loop ���鼭
		{
			if(_M == 2 )				// _M���� 2���
			{
				bw.write(String.valueOf(_M)+"\n");	// �Ҽ���. ���
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
					bw.write(String.valueOf(_M)+"\n");	// ���
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
		
		main.printPrimeNumber(M, N);	// printPrimeNumber �޼ҵ� ȣ��
	}
}