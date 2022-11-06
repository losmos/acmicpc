/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5337
 	문제번호 : 5337
 	알고리즘 : 구현
*/
package Step_etc.a5337_웰컴;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(".  .   .");
        bw.write("\n");
        bw.write("|  | _ | _. _ ._ _  _");
        bw.write("\n");
        bw.write("|/\\|(/.|(_.(_)[ | )(/.");
        bw.flush();
        bw.close();
	}
}