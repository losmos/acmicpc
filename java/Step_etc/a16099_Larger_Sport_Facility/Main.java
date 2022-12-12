/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/16099
 	문제번호 : 16099
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a16099_Larger_Sport_Facility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		BigInteger lt = null;
		BigInteger wt = null;
		BigInteger le = null;
		BigInteger we = null;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			lt = new BigInteger(st.nextToken());
			wt = new BigInteger(st.nextToken());
			le = new BigInteger(st.nextToken());
			we = new BigInteger(st.nextToken());

			BigInteger areaT = lt.multiply(wt);
			BigInteger areaE = le.multiply(we);

			if(areaT.compareTo(areaE) == 0) {
				sb.append("Tie");
			} else if(areaT.compareTo(areaE) == -1) {
				sb.append("Eurecom");
			} else if(areaT.compareTo(areaE) == 1) {
				sb.append("TelecomParisTech");
			}
			sb.append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}