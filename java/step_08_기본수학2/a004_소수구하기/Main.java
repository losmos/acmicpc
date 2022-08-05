/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1929
 	������ȣ : 1929
 	�˰��� : ����, ������, �Ҽ� ����, �����佺�׳׽��� ü
*/
package step_08_�⺻����2.a004_�Ҽ����ϱ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
	
	// _M �̻� _N������ �� �� �Ҽ��ΰ�� ���
	public boolean[] printPrimeNumber(int _M, int _N) throws IOException
	{
		boolean[] numberList = new boolean[_N];	// default : false(�Ҽ�), true(�Ҽ��� �ƴ�)

		//�����佺�׳׽��� ü
		for(int i=2; i<=_N; i++)
		{
			for(int j=1; i*j<=_N; j++)
			{
				if(numberList[i*j-1] == false)
				{
					numberList[i*j-1] = true;		// �Ҽ��� �ƴѰ���̹Ƿ� true�� ����
				}
			}
		}
		
		numberList[1] = false;	// 2�� �Ҽ��̹Ƿ�
		
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
		
		boolean[] sieveOfEratosthenes = main.printPrimeNumber(M, N);	// printPrimeNumber �޼ҵ� ȣ��
		
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