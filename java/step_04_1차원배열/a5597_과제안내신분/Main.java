/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5597
 	문제번호 : 5597
 	알고리즘 : 구현
*/
package Step_04_1차원배열.a5597_과제안내신분;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] students = new boolean[30+1];	// 특별과제 제출한 학생의 번호는 true. (0번인덱스는 사용하지 않음)
		
		for(int i = 1; i <= 28; i++) {
			students[Integer.parseInt(br.readLine())] = true;	// 과제 냈음
		}

		for(int i = 1; i <= 30; i++) {	// 입력은 28개받지만, 출력은 30개중에서 false를 찾아야함
			if(!students[i]) {	// 과제 안낸학생 색출
				bw.write(i + "\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}