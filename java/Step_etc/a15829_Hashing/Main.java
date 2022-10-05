/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15829
 	문제번호 : 15829
 	알고리즘 : 문자열, 해싱
*/
package Step_etc.a15829_Hashing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
        
        public static final int M = 1234567891;

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] strArr = str.toCharArray();
        long result = 0L;

        /**
         * 모듈러 분배법칙
         * (A + B) mod C = (A mod C + B mod C) mod C
         * (A - B) mod C = (A mod C - B mod C) mod C
         * (A * B) mod C = (A mod C * B mod C) mod C
         */
        for(int i = 0; i < L; i++) {
                // result += (strArr[i] - 'a' + 1) * Math.pow(31, i);
                int a = (strArr[i] - 'a' + 1);
                long r = 1;
                for(int j = 0; j < i; j++) {    // Math.pow를쓰면 정밀도에의해서 오차생길수있음. 수동으로 제곱 계산.
                        r = (r * 31) % M;
                }
                r %= M; // mod 분배법칙
                result = (result % M) + (a % M) * (r % M);      // mod 분배법칙
        }

        bw.write(result % M + "");
        br.close();
        bw.flush();
        bw.close();
	}
}