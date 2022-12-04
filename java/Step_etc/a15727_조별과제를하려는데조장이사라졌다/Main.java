/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15727
 	문제번호 : 15727
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a15727_조별과제를하려는데조장이사라졌다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		int result = L / 5;

		if(L % 5 != 0) {
			result += 1;
		}

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();

	}
}