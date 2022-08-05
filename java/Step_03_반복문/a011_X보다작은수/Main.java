/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/10871
 	������ȣ : 10871
 	�˰��� : ����
*/
package Step_03_�ݺ���.a011_X����������;

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
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++)
		{
			int temp = Integer.parseInt(st.nextToken());
			if(temp < X)
			{
				sb.append(temp + " ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
