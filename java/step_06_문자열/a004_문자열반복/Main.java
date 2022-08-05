/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2675
 	������ȣ : 2675
 	�˰��� : ����, ���ڿ�
*/
package step_06_���ڿ�.a004_���ڿ��ݺ�;

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
		
		int T = Integer.parseInt(br.readLine());		// �׽�Ʈ���̽� T
		
		for(int i=0; i<T; i++)
		{
			String result = "";

			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());	// �׽�Ʈ ���̽� �ݺ�Ƚ�� R
			String inputStr = "";
			
			inputStr = st.nextToken();					// �ݺ��� ������ input ���ڿ�
			
			for(int x=0; x<inputStr.length(); x++)
			{
				for(int j=0; j<R; j++)
				{
					result+=inputStr.charAt(x);			// �Էµ� ���ڿ����� �ѱ��ھ� �߶� �Էµ� R��ŭ �ݺ��ؼ� append
				}
			}
			bw.write(result.toString() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}