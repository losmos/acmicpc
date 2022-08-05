/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1152
 	������ȣ : 1152
 	�˰��� : ����, ���ڿ�
*/
package step_06_���ڿ�.a006_�ܾ��ǰ���;

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
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");	// ���ڿ� �Է¹���
		
		int count = 0;
		
		while(st.hasMoreTokens())	// ���鱸������ Tokenize �� ���ڰ� �� �ִٸ� ��� loop
		{
			st.nextToken();			// Token ������ ����
			count++;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
}