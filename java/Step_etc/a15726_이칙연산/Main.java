/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15726
 	문제번호 : 15726
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a15726_이칙연산;


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
        long C = Integer.parseInt(st.nextToken());
        
        long result1 = A*B/C;
        long result2 = A/B*C;
        long result3 = A*C/B;

        br.close();
        bw.write(Math.max(result3, Math.max(result1,result2)) + "");
        bw.flush();
        bw.close();
	}
}