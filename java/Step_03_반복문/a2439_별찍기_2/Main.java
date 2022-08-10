/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2439
 	문제번호 : 2439
 	알고리즘 : 구현
*/
package Step_03_반복문.a2439_별찍기_2;

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
