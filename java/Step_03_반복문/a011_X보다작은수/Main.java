/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10871
 	문제번호 : 10871
 	알고리즘 : 구현
*/
package Step_03_반복문.a011_X보다작은수;

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
