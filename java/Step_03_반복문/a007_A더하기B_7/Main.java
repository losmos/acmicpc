/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/11021
 	������ȣ : 11021
 	�˰��� : ����, ����, ��Ģ����
*/
package Step_03_�ݺ���.a007_A���ϱ�B_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int index = 1;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			sb.append("Case #" + index++ + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
