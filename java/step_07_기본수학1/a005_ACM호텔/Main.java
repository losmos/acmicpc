/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/10250
 	������ȣ : 10250
 	�˰��� : ����, ����, ��Ģ����
*/
package step_07_�⺻����1.a005_ACMȣ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());	// �׽�Ʈ���̽� T
		
		for(int i=0; i<T; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());	// ȣ�� ����
			int W = Integer.parseInt(st.nextToken());	// ȣ�� �ʺ�
			int N = Integer.parseInt(st.nextToken());	// ȣ�ڿ� �����ϴ� N��°�մ�
			
			int column = (int)(N / H);		// ��(���ȣ), �����ε����� 0�� ���ͽ���
			
			if( N % H == 0)
			{
				column = column -1;			// N / H ���� �� �������� �ش� ������ ����� �����ִٰ� �Ǵ��ϰԵǴµ�, ����� �� �� �÷�(��) ������ �����ֱ⶧���� ifó��
			}
			
			if(N <= H)	// N��°�մ��� H ������ �� ��ä��� ���ڶ��
			{
				column = 0;
			}
			
			int row = 0;					// ��(ȣ����)
			if(column == 0)	// �� column�� ���������ʱ⶧����. (column) * H) ������� �̹� ������ִ� �մԼ��� ������� ����.
			{
				row = N;
			}
			else
			{
				row = (N - ((column) * H));	// �մ��� column * H ����ŭ �濡 ������
			}
			
			System.out.printf(row +""+ "%02d\n", column+1);
		}
		
	}
}