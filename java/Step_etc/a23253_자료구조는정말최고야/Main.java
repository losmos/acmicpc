/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/23253
 	문제번호 : 23253
 	알고리즘 : 구현, 자료 구조, 애드 혹, 스택
*/
package Step_etc.a23253_자료구조는정말최고야;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 일반적인방법인 스택으로 풀어도 되지만. 뭔가 조금더 효율적으로 풀고싶어서 고민 좀 함.
 * 
 * 책 번호를 입력받을 때, 책더미별로 내림차순으로만 입력받는것이 보장된다면 
 * 올바른 순서대로 교과서를 꺼낼 수 있어보임.
 * 구현 ㄱㄱ
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		st.nextToken();	// (사용 안함) 교과서 수
		int M = Integer.parseInt(st.nextToken());	// 교과서 더미 수
		boolean result = true;	// 기본값 : "Yes"

		outer: for(int i = 0; i < M; i++) {
			br.readLine();	// 사용 안함.
			st = new StringTokenizer(br.readLine());
			int prevBookNumber = 200001;
			while(st.hasMoreTokens()) {
				int bookNumber = Integer.parseInt(st.nextToken());
				if(bookNumber >= prevBookNumber) {
					result = false;	// 결과 "No"
					break outer;
				} else {
					prevBookNumber = bookNumber;
				}
			}
		}
		
		br.close();
		if(result) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}
		bw.flush();
		bw.close();
	}
}