/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/8370
 	문제번호 : 8370
 	알고리즘 : 수학, 사칙연산
*/
package Step_etc.a8370_Plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
	}
}