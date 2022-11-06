/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5522
 	문제번호 : 5522
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a5522_카드게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        for(int i = 0; i < 5; i++) {
            result += Integer.parseInt(br.readLine());
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
	}
}