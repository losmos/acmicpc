/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5086
 	문제번호 : 5086
 	알고리즘 : 수학, 사칙연산
*/
package Step_15_정수론및조합론.a5086_배수와약수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			int input2 = Integer.parseInt(st.nextToken());

			if(input1 == 0 && input2 == 0) {
				break;
			}

			if(input2 % input1 == 0) {
				bw.write("factor" + "\n");
			} else if(input1 % input2 == 0) {
				bw.write("multiple" + "\n");
			} else {
				bw.write("neither" + "\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}