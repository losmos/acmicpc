/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2798
 	문제번호 : 2798
 	알고리즘 : 브루트포스 알고리즘
*/
package Step_11_브루트포스.a2798_블랙잭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;


		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// N : 카드개수
		int M = Integer.parseInt(st.nextToken());	// 맞춰야될 숫자

		String[] cards = br.readLine().split(" ");
		int result = 0;	// 최종 출력할 결과

		outer:
		for( int i = 0; i < N; i ++ ) {			// 첫번째 카드 loop
			for( int j = 0; j < N; j ++ ) {		// 두번째 카드 loop
				if( cards[j] == cards[i] || j <= i ) {	// 카드를 중복해서 뽑지않는 continue조건.  j<=i 조건으로 불필요하게 중복loop를 돌지 않음. (ex : 카드 5,6,7 뽑은 후에 5,7,6을 한번더 검사하는 중복검사 방지)
					continue;
				}

				for( int k = 0; k < N; k ++ ) {	// 세번째 카드 선택 loop
					if( cards[k] == cards[j] || cards[k] == cards[i] || k <= j) {	// 카드를 중복해서 뽑지않는 continue조건.  k<=j 조건으로 불필요하게 중복loop를 돌지 않음. (ex : 카드 5,6,7 뽑은 후에 5,7,6을 한번더 검사하는 중복검사 방지)
						continue;
					}
					int sumCardNumber = Integer.parseInt(cards[i]) + Integer.parseInt(cards[j]) + Integer.parseInt(cards[k]);
					if(sumCardNumber == M) {	// 세카드의 합이 목표로하는 숫자 M과 정확히 일치한다면 더이상 loop수행할필요없음. break
						result = sumCardNumber;
						break outer;
					}

					if(sumCardNumber <= M && sumCardNumber > result) {	// 3개의카드 숫자를 더한 값이 목표숫자인 M을넘지않으면서. N에 더 가까운 수 일경우
						result = sumCardNumber;
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();

	}
}