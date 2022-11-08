/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11718
 	문제번호 : 11718
 	알고리즘 : 구현, 문자열
*/
package Step_etc.a11718_그대로출력하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = "";
        
        // 파일의 끝 EOF가 올때까지 입력받는다.
        // while((input = br.readLine()) != null && !input.isEmpty()) {     //  && 앞에조건은 파일의 EOF, 뒤에는 키보드입력받으면서 테스트할때도 쓰일수있는 조건
        while((input = br.readLine()) != null) {        // 해당조건으로 제출하면, 정답판정나옴. 단, ide에서 테스트할때는 파일입력이 아니라서 정확하게 테스트가 안되긴했음.
            sb.append(input).append("\n");
        }
        
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}