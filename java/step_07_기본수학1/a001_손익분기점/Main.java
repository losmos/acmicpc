/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1712
 	������ȣ : 1712
 	�˰��� : ����, ��Ģ����
*/
package step_07_�⺻����1.a001_���ͺб���;

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
		
		st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());	// ������
		long B = Long.parseLong(st.nextToken());	// �����
		long C = Long.parseLong(st.nextToken());	// �ǸŰ�
		
		long result = 0;

		//C-B�� 1���Ǹ��Ҷ����� ���� ������
		if(C-B <= 0)	//�ȼ��� ���ض��
		{
			bw.write("-1");
		}
		else
		{
			result = A/(C-B) + 1;
			bw.write(String.valueOf(result));
		}
		
		bw.flush();
		bw.close();
		
	}
}
