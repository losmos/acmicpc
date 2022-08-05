/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10952
 	문제번호 : 10952
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a012_A더하기B_5;

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
		
		while(true)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0)
			{
				break;
			}
			
			sb.append((a+b)+"\n");
		}
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
