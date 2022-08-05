/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/11720
 	������ȣ : 11720
 	�˰��� : ����, ����, ���ڿ�
*/
package step_06_���ڿ�.a003_���ĺ�ã��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	
	/*
	 * param1 : �Է¹��� ������ ���ڿ�
	 * param2 : a ~ z �� ���� �˻��� ���ڿ�
	 */
	public String findIdx(StringBuilder _inputStr, char _targetChar)
	{
		for(int i=0; i<_inputStr.length(); i++)
		{
			if(_inputStr.charAt(i) == _targetChar)
			{
				return String.valueOf(i);
			}
		}
		
		return "-1";
	}
	
	public static void main(String[] args) throws IOException
	{
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char startChar = 'a';		// �Է¹������ִ� ������ a ~ z ������ ù��° ���� �ƽ�Ű �ڵ尪
		char endChar = 'z';			// �Է¹������ִ� ������ a ~ z ������ ������ ���� �ƽ�Ű �ڵ尪
		sb.append(br.readLine());

		String result = "";			// ���� ����� ���� ����
		
		for(; startChar <= endChar; startChar++)		// �ƽ�Ű�ڵ� a ~ z ���� loop
		{
			result += main.findIdx(sb, startChar) + " ";	// findIdx �޼ҵ� ȣ��
			
		}

		bw.write(result);
		bw.flush();
		bw.close();
		
	}
}