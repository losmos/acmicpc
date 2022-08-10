/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11021
 	문제번호 : 11021
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a11021_A더하기B_7;

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
