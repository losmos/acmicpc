/*
s 	������ó : BACKJOON, https://www.acmicpc.net/problem/8958
 	������ȣ : 8958
 	�˰��� : ����, ���ڿ�
*/
package step_04_1�����迭.a006_OX����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		String[] strArray = null;
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), "");
			strArray = st.nextToken().split("");

			int checkedNum = 1;
			int result = 0;
			
			for(String s : strArray)
			{
				if(s.equals("O"))
				{
					result += checkedNum;
					checkedNum ++;
				}
				else
				{
					checkedNum = 1;
				}
			}
			
			bw.write(String.valueOf(result)+"\n");

		}
		
		bw.flush();
		bw.close();
		
	}
}