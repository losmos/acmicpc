/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2292
 	������ȣ : 2292
 	�˰��� : ����
*/
package step_07_�⺻����1.a002_����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 ~   1		// �Ÿ�:1
		 2   7		// �Ÿ�:2		
		 8   19		// �Ÿ�:3
		 20   37	// �Ÿ�:4
		 38   61	// �Ÿ�:5
		 62   ...	// ...
		 */
		
		// �߽��� �ѷ��δ� ���������� �Ѳ�Ǯ �Ѳ�Ǯ �̷���ִ� �� ������ 6�� ����� �������� �̷��.
		// ��ġ 2������ ����Ҷ� 2^0, 2^1, 2^2... 2^n �������ϸ� 10������ ��ȯ�ϵ���
		// �Ѳ�Ǯ�� �����ִ� ��. �� ������ �Ÿ��� 6���������� �� �� �ִ�.
		// �� ù��° ��Ǯ���� 6^0��ŭ, �ι�°�� 6^1��ŭ, ����°�� 6^2... n��°�� 6^n ��ŭ�� ���ڰ� ���Եȴ�.
		// ���࿡ 61�̶�� ���� �Էµƴٸ� 61-1 (-1���ִ� ������ ���� index�� 1�̹Ƿ� )�� 60���� 6���γ������� 10�̶�� ���ڸ� ���� �� �ְ�
		// 6^10 �� ��ġ�� ��Ʈ�� ���°��Ʈ������ ����ϸ� ������ �Ÿ��� ��� �� �� �ִ�.
		// ù��°��Ʈ�� 1, �ι�°��Ʈ�� 2, ����°��Ʈ�� 3, �׹�°��Ʈ�� 4��ŭ ���Ƿ� 10�̶�� ���ڴ� 4����Ʈ�� ������ �� �� �ִ�(1+2+3+4 = 10)
		
		double N = Long.parseLong(br.readLine());
		long coordinate = (long)Math.ceil((N-1)/6);
		
		long index = 0;
		while(true)
		{
			coordinate = coordinate - index;
			
			if(coordinate <= 0)
			{
				break;
			}
			
			index++;
		}
		
		bw.write(String.valueOf(index+1));
		bw.flush();
		bw.close();
		
	}
}
