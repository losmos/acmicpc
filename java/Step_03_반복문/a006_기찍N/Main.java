/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2741
 	������ȣ : 2741
 	�˰��� : ����
*/
package Step_03_�ݺ���.a006_����N;

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
