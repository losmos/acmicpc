/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2439
 	������ȣ : 2439
 	�˰��� : ����
*/
package Step_03_�ݺ���.a010_�����_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++)
		{
			for(int j=0; j<T; j++)
			{
				if(j >= T-i-1)
				{
					sb.append("*");
				}
				else
				{
					sb.append(" ");
				}
					
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
