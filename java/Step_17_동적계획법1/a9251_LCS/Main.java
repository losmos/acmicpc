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

/**
 * [문제풀이 컨셉]
 * 어떤식으로 접근해야할지 고민고민하다 결국 검색함. 어렵다 어려워
 * 참조사이트 : https://st-lab.tistory.com/139
 * 참조사이트 : https://sskl660.tistory.com/90
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 예시 문자열)
		// ACAYKP
		// CAPCAKKK
		char[] str1 = br.readLine().toCharArray();	// input 문자열1
		char[] str2 = br.readLine().toCharArray();	// input 문자열2

		int lengthStr1 = str1.length;	// str1의 길이
		int lengthStr2 = str2.length;	// str2의 길이

		int[][] dp = new int[lengthStr2+1][lengthStr1+1];	// dp 할당

		for(int i = 1, range1 = lengthStr2; i <= range1; i++) {		// str2의 문자 하나와
			for(int j = 1, range2 = lengthStr1; j <= range2; j++) {	// str1문자 전체를 비교검사한다.
				if(str2[i-1] == str1[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					// dp[i][j] = dp[i-1][j]를 기본으로하지만,
					// inner for문 검사중에 일치하는 문자가 나와서 LCK가 +1이 됐을 경우에는 매칭되는 최대문자 개수가 갱신됐으므로 메모이제이션 값을
					// 증가시켜주어야 한다. 따라서 증가된 dp[i][j-1]값과, 원래 기존에 메모이제이션 해뒀던 dp[i-1][j]값 중 더 큰 값을 할당해준다.
				}
			}
		}

		br.close();
		bw.write(dp[lengthStr2][lengthStr1] + "");
		bw.flush();
		bw.close();
	}
}