/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10951
 	문제번호 : 10951
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a10951_A더하기B_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			
			
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
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
	}
}
