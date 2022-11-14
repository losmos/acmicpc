/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10170
 	문제번호 : 10170
 	알고리즘 : 구현
*/
package Step_etc.a10170_NFC_West_vs_North;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            sb.append("NFC West       W   L  T").append("\n");
            sb.append("-----------------------").append("\n");
            sb.append("Seattle        13  3  0").append("\n");
            sb.append("San Francisco  12  4  0").append("\n");
            sb.append("Arizona        10  6  0").append("\n");
            sb.append("St. Louis      7   9  0").append("\n").append("\n");
            
            sb.append("NFC North      W   L  T").append("\n");
            sb.append("-----------------------").append("\n");
            sb.append("Green Bay      8   7  1").append("\n");
            sb.append("Chicago        8   8  0").append("\n");
            sb.append("Detroit        7   9  0").append("\n");
            sb.append("Minnesota      5  10  1");

            bw.write(sb.toString());
            bw.flush();
            bw.close();
    }
}