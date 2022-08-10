/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3003
 	문제번호 : 3003
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_01_입출력과_사칙연산.a3003_킹퀸룩비숍나이트폰;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] kqbnp = {1, 1, 2, 2, 2, 8};
		String[] str = br.readLine().split(" ");

		for(int i=0; i<6; i++) {
			bw.write(kqbnp[i] - Integer.parseInt(str[i]) + " ");
		}
		
		bw.flush();
		bw.close();
	}
}

