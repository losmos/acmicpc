/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2741
 	문제번호 : 2741
 	알고리즘 : 구현
*/
package Step_03_반복문.a005_N찍기;

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
		int result = 1;
		while(N-- > 0)
		{
			bw.write(result++ + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
