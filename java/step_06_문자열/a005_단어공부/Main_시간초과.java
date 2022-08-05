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

class Main_�ð��ʰ� {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		sb.append(br.readLine().toUpperCase());		// ���� UpperCase()
		int resultLength = 0;
		char resultStr = '\0';
		boolean commonVictory = false;				// ���� �ټ��� ������ ���� ������ 2�� �̻��̶��  true. ���������� "?"���ڸ� ����
	
		// ����for������ ���� �ð��ʰ�
		for(int i=0; i<sb.length(); i++)
		{
			char getSplitChar = sb.charAt(i);		// �˻��� ���� ����
			
			int charLength = 0;
			
			for(int j=0; j<sb.length(); j++)
			{
				if(sb.charAt(j) == getSplitChar)	// �˻��ҹ��ڰ� ���ڿ����� ����� ���
				{
					charLength ++;					// �� ����� Ƚ���� counting �ϱ� ���� +1
				}
			}
			
			if(resultLength < charLength)			// �ִ����Ƚ���� ���ŵȴٸ�
			{
				resultStr =  getSplitChar;			// �ִ������ ������ ���� ����
				resultLength = charLength;			// ����(����)�� Ƚ��
				commonVictory = false;
			}
			else if(resultLength == charLength && resultStr != getSplitChar)
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