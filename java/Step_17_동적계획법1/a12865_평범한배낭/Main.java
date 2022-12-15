/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/12865
 	문제번호 : 12865
 	알고리즘 : 다이나믹 프로그래밍, 배낭 문제
*/
package Step_17_동적계획법1.a12865_평범한배낭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 혼자 머리싸매고 끙끙대봤지만, 역시 쉽지않은 문제였고,
 * 배낭 알고리즘이라고, 별도의 알고리즘 개념이었음
 * 
 * 참조 : https://fbtmdwhd33.tistory.com/60
 * 
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arrW = new int[N];
		int[] arrV = new int[N];
		int[] dpW = new int[N];
		int[] dpV = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrW[i] = Integer.parseInt(st.nextToken());
			arrV[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 0; i < N; i++) {
			if(arrW[i] <= K) {
				dpW[i] = arrW[i];
				dpV[i] = arrV[i];
			}

			for(int j = 0; j < i; j++) {
				if(dpW[j] + arrW[i] <= K && arrV[j] != 0) {
					if(dpV[j] + arrV[i] > dpV[i]) {
						dpV[i] = dpV[j] + arrV[i];
						dpW[i] = dpW[j] + arrW[i];
					}
				}
			}

			if(dpV[i] > max) {
				max = dpV[i];
			}
		}

		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}