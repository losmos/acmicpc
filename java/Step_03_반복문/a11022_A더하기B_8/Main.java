/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11022
 	문제번호 : 11022
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a11022_A더하기B_8;

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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append("Case #" + index++ + ": " + a + " + " + b + " = " + (a+b) + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
