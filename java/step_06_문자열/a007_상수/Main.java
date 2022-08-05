/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2908
 	������ȣ : 2908
 	�˰��� : ����, ����
*/
package step_06_���ڿ�.a007_���;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		String strA = st.nextToken();	// ù���� ���ڸ� ����
		String strB = st.nextToken();	// �ι�° ��[�ڸ� ����

		int multiple = 100;
		int tempNumA = Integer.parseInt(strA);	// int�� ��ȯ
		int tempNumB = Integer.parseInt(strB);	// int�� ��ȯ
		
		int numA = 0;
		int numB = 0;
		
		for(int i=0; i<3; i++)
		{
			numA += tempNumA % 10 * multiple;	// �� �� �ڸ����� multiple ��ŭ ���Ѱ��� ����� ����
			tempNumA = tempNumA / 10;
			
			numB += tempNumB % 10 * multiple;
			tempNumB = tempNumB / 10;
			
			multiple = multiple / 10;			// multiple�� loop�� �������� ������ 10����
		}
		
		if(numA > numB)
		{
			bw.write(String.valueOf(numA));
		}
		else
		{
			bw.write(String.valueOf(numB));
		}
		
		bw.flush();
		bw.close();
		
	}
}