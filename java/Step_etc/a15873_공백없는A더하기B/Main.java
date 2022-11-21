/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15873
 	문제번호 : 15873
 	알고리즘 : 수학, 사칙연산, 많은 조건 분기
*/
package Step_etc.a15873_공백없는A더하기B;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        int result = 0;
        for(int i = 0, range = input.length; i < range; i++) {
            if(input[i] == '0') {   // 0이오는경우는 10의숫자가 오는경우에서 나오는 0인 경우밖에 없으므로, 0이 나온다면 직전에는 무조건 1이 나온거임. 따라서 +9를 해주면 10이된다.
                result += 9;
            } else {
                result += Integer.parseInt(input[i] + "");
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
	}
}