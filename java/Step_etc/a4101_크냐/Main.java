/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4101
 	문제번호 : 4101
 	알고리즘 : 구현
*/
package Step_etc.a4101_크냐;

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

        while(true) {
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            if(input1 == 0 && input2 == 0) {
                break;
            }

            if(input1 > input2) {
                bw.write("Yes");
            } else {
                bw.write("No");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
	}
}