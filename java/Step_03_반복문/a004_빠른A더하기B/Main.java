/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15552
 	문제번호 : 15552
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a004_빠른A더하기B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
