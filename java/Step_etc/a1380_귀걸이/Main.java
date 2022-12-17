/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1380
 	문제번호 : 1380
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a1380_귀걸이;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int testCaseNum = 1;
        while(true) {
            
            int n = Integer.parseInt(br.readLine());
            String[] nameInfo = new String[n+1];
            boolean[] result = new boolean[n+1];

            if(n == 0) {
                break;
            }

            for(int i = 1; i <= n; i++) {
                nameInfo[i] = br.readLine();
            }
    
            for(int i = 1; i <= 2*n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());
                st.nextToken(); // 사용하지않는 st.nextToken();

                result[number] = !result[number]; // true false 뒤바꿈
            }

            for(int i = 1; i < result.length; i++) {
                if(result[i]) {
                    sb.append(testCaseNum).append(" ").append(nameInfo[i]).append("\n");
                }
            }

            testCaseNum++;
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}