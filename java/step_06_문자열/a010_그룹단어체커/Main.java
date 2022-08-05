/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1316
 	������ȣ : 1316
 	�˰��� : ����, ���ڿ�
*/
package step_06_���ڿ�.a010_�׷�ܾ�üĿ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	
	public boolean checkGroupWord(StringBuilder _checkingWord)
	{
		StringBuilder checkingWord = null;
		
		int index = 0;
		for(int i=0; i<_checkingWord.length(); i++)
		{
			checkingWord = new StringBuilder(_checkingWord.toString());			// �˻��� ���ڿ� �ʱ�ȭ
			index = checkingWord.toString().indexOf(_checkingWord.charAt(i));	// �˻��� char ���ڰ� ���ʷγ��� index ����
			
			// replace�ϸ鼭 ���ڸ� �ϳ������ְ��� indeOf�Լ��� üũ�ϸ� �ҿ��������� ��ġ�Ҷ� return false
			for(int j=0; j<_checkingWord.length(); j++)
			{
				if(checkingWord.toString().indexOf(_checkingWord.charAt(i)) - index > 0)
					
				{
					return false;	// �׷��Լ� �ƴ�
				}
				
				checkingWord = checkingWord.replace(i, i+1, "");
			}
			
		}
		
		return true;		// �˻縦 ��� ����ߴٸ� �׷�ܾ���.
	}
	
	public static void main(String[] args) throws IOException
	{
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// ����Ƚ�� N
		
		
		int result = 0;
		while(N-- > 0)
		{
			st = new StringTokenizer(br.readLine());			// ���ڿ� �Է�
			if(main.checkGroupWord(sb.append(st.nextToken())))	//�׷�ܾ� üũ �޼ҵ� ȣ��
			{
				result ++;				// �׷�ܾ �ǹ��ϴ� return true�ϰ�� result�� +1
			}
			
			sb.delete(0,sb.length());	//sb clear
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		

		
	}
}