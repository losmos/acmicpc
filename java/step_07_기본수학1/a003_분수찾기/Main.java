/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1193
 	������ȣ : 1193
 	�˰��� : ����, ����
*/
package step_07_�⺻����1.a003_�м�ã��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 ~   1		// �Ÿ�:1
		 2   3		// �Ÿ�:2		
		 4   6		// �Ÿ�:3
		 7   10		// �Ÿ�:4
		 11  15		// �Ÿ�:5
		 16  21		// ...
		 */
		
		// �������� �������� ����. �������乮����.
		// ��Ʈ(�Ÿ�)���� �Ÿ��� 1�� �����ϴ� ��������
		// ��� N �� �Էµ����� loop ���鼭 ���� coordinate�� ����������ŭ�� ���� ��� �����ؼ� �����ִٰ�  �� coordinate���� N���� �����ϴ� index���� ���ϸ� �Ÿ����� �� ������.
		// �Ÿ����� ���ߴٸ� �ش�Ÿ����� 
		
		int N = Integer.parseInt(br.readLine());
		
		int coordinate = 0;
		int index = 0;
		while(true)
		{
			
			coordinate += index;		// ��������
			if(coordinate >= N)
			{
				break;
			}
			index++;
			
		}
		int numerator = coordinate - N + 1;			// �и�
		int denominator = N - (coordinate-index);	// ���ڰ�, ���������� �ʰ��Ҷ� break�ǹǷ� �Է°�N����, �ʰ��ϴ� �� �� ������������ ���� �ش� distance���� �������� ���Ҽ��ְ�
													// �� ���������� index���� �������� ��ĭ�� ���ư������� ����� �� �� �ִ�.
		
		// ���ڰ� ������׷� �����߳�...
		if(index % 2 == 1)
		{
			bw.write(String.valueOf(numerator)+"/"+String.valueOf(denominator));
		}
		else
		{
			bw.write(String.valueOf(denominator)+"/"+String.valueOf(numerator));
		}
		bw.flush();
		bw.close();
		
	}
}
