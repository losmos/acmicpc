/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2742
 	문제번호 : 2742
 	알고리즘 : 구현
*/
package Step_03_반복문.a2742_기찍N;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0)
		{
			bw.write(N+1 + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
