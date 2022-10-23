/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25501
 	문제번호 : 25501
 	알고리즘 : 구현, 문자열, 재귀
*/
package Step_11_재귀.a25501_재귀의귀재;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class PalindromeInfo {
	String str = "";
	int totalCallCnt = 0;	// recursion함수 총 호출횟수 저장할 변수
	int isPalindrome;		// 1 : 팰린드롬, 0 : 팰린드롬 아님
}

public class Main{

	public PalindromeInfo recursion(PalindromeInfo pd, int left, int right){
		pd.totalCallCnt++;
        if(left >= right) {	// 팰린드롬인 경우
			pd.isPalindrome = 1;
			return pd;
		} else if(pd.str.charAt(left) != pd.str.charAt(right)) {	//팰린드롬 아닌 경우
			pd.isPalindrome = 0;
			return pd;
		} else {	// 재귀 call
			return recursion(pd, left+1, right-1);
		}
    }

    public PalindromeInfo isPalindrome(PalindromeInfo pd){
        return recursion(pd, 0, pd.str.length()-1);
    }

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		PalindromeInfo pd = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			pd = new PalindromeInfo();
			pd.str = br.readLine();
			pd = main.isPalindrome(pd);

			bw.write(pd.isPalindrome + " " + pd.totalCallCnt + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}