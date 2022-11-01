/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10807
 	문제번호 : 10807
 	알고리즘 : 구현
*/
package Step_04_1차원배열.a10807_개수세기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];	// 입력숫자를 담을 배열
		int cnt = 0;	// v값이 나온 횟수

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			if(arr[i] == v) {	// v가 몇개인지 검사
				cnt++;
			}
		}

		br.close();
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}