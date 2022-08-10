/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4344
 	문제번호 : 4344
 	알고리즘 : 수학, 사칙연산
*/
package Step_04_1차원배열.a4344_평균은넘겠지;

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
		
		int C = Integer.parseInt(br.readLine());
		
		for(int i=0; i<C; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			int total = 0;
			double index = Double.parseDouble(st.nextToken());
			int[] score = new int[(int)index];

			int j = 0;
			while(st.hasMoreTokens())
			{
				score[j] = Integer.parseInt(st.nextToken());
				total += score[j];
				j++;
			}
			
			double avg = total/index;
			double resultCount = 0;
			for(int x = 0; x<score.length; x++)
			{
				if(score[x] > avg)
				{
					resultCount++;
				}
			}
			
			bw.write(String.format("%.3f%%", resultCount/index*100));
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}