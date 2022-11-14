/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1264
 	문제번호 : 1264
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_etc.a1264_모음의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public boolean checkVowel(char _param) {
        
        if(_param == 'a' || _param == 'e' || _param == 'i' || _param == 'o' || _param == 'u' || _param == 'A' || _param == 'E' || _param == 'I' || _param == 'O' || _param == 'U') {
            return true;
        } else {
            return false;
        }
    }

	public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int cnt = 0;
            String input = br.readLine();
            if(input.equals("#")) {
                break;
            }

            char[] line = input.toCharArray();
            for(int i = 0, range = line.length; i < range; i++) {
                if(main.checkVowel(line[i])) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}