/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1712
 	문제번호 : 1712
 	알고리즘 : 수학, 사칙연산
*/
package Step_07_기본수학1.a001_손익분기점;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());	// 고정비
		long B = Long.parseLong(st.nextToken());	// 생산비
		long C = Long.parseLong(st.nextToken());	// 판매가
		
		long result = 0;

		//C-B가 1대판매할때마다 남는 순이익
		if(C-B <= 0)	//팔수록 손해라면
		{
			bw.write("-1");
		}
		else
		{
			result = A/(C-B) + 1;
			bw.write(String.valueOf(result));
		}
		
		bw.flush();
		bw.close();
		
	}
}
