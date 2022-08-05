/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1978
 	������ȣ : 1978
 	�˰��� : ����, ������, �Ҽ� ����, �����佺�׳׽��� ü
*/
package step_08_�⺻����2.a001_�Ҽ�ã��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());		// �Է��� �Ҽ��� ����. ��������Ұ���
		st = new StringTokenizer(br.readLine(), " ");	// �Էµ� ���� " " ����������� Tokenizer ��
		
		int primeNumberCount = 0;	// ��Ż �Ҽ����� ���� 
		
		while(st.hasMoreTokens())	// ��ū�� ���������� ���� loop
		{
			int inputNumber = Integer.parseInt(st.nextToken());	// ���� ��ū��
			
			if(inputNumber == 2 )		// �Է°��� 2��� �Ҽ���
			{
				primeNumberCount++;		// �Ҽ����� +1
				continue;
			}
			
			// i�� 0�̳� 1���ͽ������ʿ� ����.
			for(int i=2; i<inputNumber; i++)
			{
				if(inputNumber%i == 0)			// �Ҽ��� ������. i�� ���� �������� 0�̶�� �Ҽ��� �ƴ�. 
				{
					break;		// �Ҽ��� �ƴ�
				}
				
				if(i == inputNumber-1)			// �Է¼��� - 1���� �˻��ߴµ��� �����������°Ծ�����
				{
					primeNumberCount++;			// �Ҽ��ϱ� �Ҽ����� +1
				}
				
			}
		}
		
		bw.write(String.valueOf(primeNumberCount));	// ���
		bw.flush();
		bw.close();
		
	}
}