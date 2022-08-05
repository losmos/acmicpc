/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/11720
 	������ȣ : 11720
 	�˰��� : ����, ����, ���ڿ�
*/
package step_06_���ڿ�.a002_��������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());		// �Է��������� ������ ����
		
		sb.append(br.readLine());						// ���ӵ� ���� �Է¹���. ���ڱ��̴� 100�����̹Ƿ�, ������ Type���ι����� ������
		
		String[] splitStr = sb.toString().split("");	// �ѱ��ھ� split�ؼ� String �迭�� ����
		
		int result = 0;
		for(int i=0; i < splitStr.length; i++)
		{
			result += Integer.parseInt(splitStr[i]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}