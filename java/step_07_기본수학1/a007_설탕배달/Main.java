/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2839
 	������ȣ : 2839
 	�˰��� : ����, ���̳��� �˰���, �׸��� �˰���
*/
package step_07_�⺻����1.a007_�������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;		// �ּ� �������� ����
		
		if(N % 5 == 0)		// 5kg¥���� �� �����������ٸ� �׳� 5�� ������ �ּҰ�
		{
			result = N / 5;
		}
		else
		{
			while(true)
			{
				N = N - 3;				// 3kg¥���� �ϳ��� �����鼭, ������ ���� ���� 5kg���� �ִ��� ���̸���� �ִٸ�, �ּ� ���������� ���� �� ����.
				result = result + 1;	// 3kg¥�� �ϳ� ��������� �������� + 1
				
				if( N % 5 == 0)
				{
					result = result + (N / 5);
					break;
				}
				
				if(N <= 0)
				{
					result = -1;
					break;
				}
			}
		}
		
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
	}
}