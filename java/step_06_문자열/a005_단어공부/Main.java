/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1157
 	������ȣ : 1157
 	�˰��� : ����, ���ڿ�
*/
package step_06_���ڿ�.a005_�ܾ����;

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
		
		sb.append(br.readLine().toUpperCase());		// ���� UpperCase()
		
		char A = 'A';
		char Z = 'Z';
		
		int[] alphabet = new int[Z - A + 1];	// A ~ Z ���ڰ�����ŭ�� �迭 �ʱ�ȭ
		
		char resultStr = '\0';					// �ִ� ���� ���ڸ� ���� ����
		int resultLength = 0;					// �ִ� ���� ���� Ƚ���� ���� ����
		
		boolean commonVictory = false;				// ���� �ټ��� ������ ���� ������ 2�� �̻��̶��  true. ���������� "?"���ڸ� ����
		
		for(int i=0; i<sb.length(); i++)
		{
			alphabet[sb.charAt(i) - A] ++;			// A ~ Z �� �������ִ� �ƽ�Ű�ڵ尪��ŭ�� �迭�� �����ϸ� ���ҽ�����. ����ּҷ� �������� A��ŭ�� �ƽ�Ű�ڵ尪�� ����
		}
		
		for(int i=0; i<alphabet.length; i++)
		{
			if(alphabet[i] > resultLength)			// ������ �����߾���  �ִ����� ���� Ƚ���� �����Ѵٸ�
			{
				resultLength = alphabet[i];			// �ִ����� ���ڰ��� ���� 
				resultStr = (char)(i+A);			// �ִ����� ���� ����
				commonVictory = false;
			}
			else if(alphabet[i] == resultLength && resultStr != (char)i)
			{
				commonVictory = true;
			}
		}
		
		if(commonVictory)
		{
			bw.write("?");
		}
		else
		{
			bw.write(resultStr);
		}
		
		bw.flush();
		bw.close();
	}
}