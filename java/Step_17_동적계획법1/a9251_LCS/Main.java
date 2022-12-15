/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9251
 	문제번호 : 9251
 	알고리즘 : 다이나믹 프로그래밍, 문자열
*/
package Step_17_동적계획법1.a9251_LCS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 문제의 예시인
 * ACAYKP
 * CAPCAK
 * 두개의 문자열이 주어질경우 같은문자열 끼리 전깃줄처럼 이어주면된다. 
 * 위에 문자열기준으로 B문자열에서 문자를 하나씩 검사해서 이어주면되는데, .. 아 아니다 어렵네 이거
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();

		for(int i = 0, range = arr1.length; i < range; i++) {

		}
	}
}