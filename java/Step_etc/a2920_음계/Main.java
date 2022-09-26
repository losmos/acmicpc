/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2920
 	문제번호 : 2920
 	알고리즘 : 구현
*/
package Step_etc.a2920_음계;

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

        int check = 0;  // check변수 활용안하면 (1 or 8) (2 or 7) (3 or 6) (4 or 5) (5 or 4) (6 or 3) (7 or 2) (8 or 1) 입력값이 왔다갔다 핑퐁치는걸 캐치하지 못함.
        for(int i = 1; i <= 8; i++) {
            int input = Integer.parseInt(st.nextToken());

            if(input == i) {
                check+=i;
                if(i == 8) {
                    if(check == 36) {
                        bw.write("ascending");
                    } else {
                        bw.write("mixed");
                    }
                }
            } else if (input + i == 9) {
                check-=i;
                if(i == 8) {
                    if(check == -36) {
                        bw.write("descending");
                    } else {
                        bw.write("mixed");
                    }
                } 
            } else {
                bw.write("mixed");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
	}
}