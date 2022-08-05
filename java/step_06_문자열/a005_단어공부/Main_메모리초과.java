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
import java.util.StringTokenizer;

class Main_�޸��ʰ� {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		sb.append(br.readLine().toUpperCase());		// ���� UpperCase()
		int resultLength = 100000;
		String resultStr = "";
		boolean commonVictory = false;				// ���� �ټ��� ������ ���� ������ 2�� �̻��̶��  true. ���������� "?"���ڸ� ����
		String getSplitChar = "";
		String replacedStr = "";
		
		// �Ƹ��� replaceAll�� ���� �޸��ʰ�
		for(int i=0; i<sb.length(); i++)
		{
			getSplitChar = String.valueOf(sb.charAt(i));
			
			replacedStr = sb.toString().replaceAll(getSplitChar, "");	// �˻��ϰ����ϴ� ���ڸ� ����("")���� replaceAll ��
			
			if(resultLength > replacedStr.length())		// replaceAll�� ���ڱ��̰� ���� ª�ٸ�, sb.charAt(i) ���ڰ� ���� ���� ���ִٴ� �ǹ�
			{
				resultStr =  getSplitChar;
				resultLength = replacedStr.length();
				commonVictory = false;
			}
			else if(resultLength == replacedStr.length() && !resultStr.equals(getSplitChar))	// ���������� Ƚ���� �����̸鼭, �������ڰ� �ƴѰ��
			{
				commonVictory = true;		
			}
		}
		
		if(commonVictory)
		{
			resultStr = "?";
		}
		
		bw.write(resultStr);
		bw.flush();
		bw.close();
		
	}
}