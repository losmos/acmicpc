/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2941
 	������ȣ : 2941
 	�˰��� : ����, ���ڿ�
*/
package step_06_���ڿ�.a009_ũ�ξ�Ƽ�ƾ��ĺ�;

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

		String[] croatia = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		sb.append(br.readLine());		// ���ڿ� �Է¹���
		
		String sbStr = sb.toString();	// �Է¹��� ���ڿ� sbStr ������ ����
		String replaceStr = sbStr;			// replace�� ��� �ӽ÷� ���� ����
		
		int checkLength = sbStr.length();
		int wordCount = 0;
		for(int i=0; i<croatia.length; i++)
		{
			replaceStr = replaceStr.replaceAll(croatia[i], "0");		// 0���� replace ����
			if(checkLength != replaceStr.length())				// replaceAll�� ���Ѱ��� �ִٸ�
			{
				wordCount += (checkLength - replaceStr.length()) / (croatia[i].length()-1);	// ���Ѹ�ŭ�� ���̸� ����ؼ� �ܾ� �� counting (-1�� ���ִ°� replaceAll������ "0"���� �ٲ��ֱ⶧���� "0"��ŭ�� length�� �����)
				checkLength = replaceStr.length();
			}
		}
		
		wordCount += replaceStr.length() - (replaceStr.length() - replaceStr.replaceAll("0", "").length());	// replaceAll �ϰ� ���� ������ ���ڴ� ũ�ξ�Ƽ�� ���ĺ��� �ƴϹǷ�, length 1���� ���� 1���� ����ؼ� ������
		
		bw.write(String.valueOf(wordCount));
		bw.flush();
		bw.close();
		
	}
}