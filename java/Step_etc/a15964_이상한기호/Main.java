/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15964
 	문제번호 : 15964
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a15964_이상한기호;

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

        st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        
        long result = (A+B)*(A-B);

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
	}
}