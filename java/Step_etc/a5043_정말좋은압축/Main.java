/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5043
 	문제번호 : 5043
 	알고리즘 : 수학
*/

package Step_etc.a5043_정말좋은압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 첫째줄에 N과 b가 주어졌을때
 * b가 가질 수 있는 경우의수의 누적합을 구해서 N보다 크면 yes를 출력, 작으면 no를 출력한다.
 *  -> 누적합을 반복문으로 돌려가며 구할필요없이 쉬프트연산으로 제곱해서 구해주면 된다.
 * 
 * 참고사이트 : https://ps-ps-ps.tistory.com/44
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long b = ((long) 2 << Long.parseLong(st.nextToken())) - 1;

		br.close();
		if(N <= b) {
			bw.write("yes");
		} else {
			bw.write("no");
		}
		bw.flush();
		bw.close();
	}
}