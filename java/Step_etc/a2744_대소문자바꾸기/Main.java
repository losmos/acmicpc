/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2744
 	문제번호 : 2744
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a2744_대소문자바꾸기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] alphabet = br.readLine().toCharArray();
        char gap = 'a' - 'A';
        for(int i = 0, range = alphabet.length; i < range; i++) {
                if(alphabet[i] >= 'a' && alphabet[i] <= 'z') {
                        alphabet[i] = (char)(alphabet[i] - gap);
                } else {
                        alphabet[i] = (char)(alphabet[i] + gap);
                }
                bw.write(String.valueOf(alphabet[i]));
        }

        br.close();
        bw.flush();
        bw.close();
	}
}