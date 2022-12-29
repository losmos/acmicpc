/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10986
 	문제번호 : 10986
 	알고리즘 : 수학, 누적 합
*/
package Step_18_누적합.a10986_나머지합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 이중for문으로 시간복잡도 O(N^2)를 가지는 풀이로 시간초과가 났다.
 * 어떻게하면 시간복잡도를 줄일 수 있을지 아무리 고민해봐도 떠오르지 않았음.
 * 
 * 결국, 풀이방식을 검색해서 찾았다.
 * 공부하다보면, 나중에 이런 알고리즘문제 풀이방식도 혼자 고민해서 스스로 찾을 수 있을까? 어렵다 어려워.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] prefixSumCnt = new int[M];	// prefixSum배열값의 카운팅값(ex. prefixSum배열 전체에 2라는 값이 15개가 있다면 prefixSumCNt[2] = 15 다.)
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken()) % M;
			prefixSumCnt[sum%M]++;
		}

		long result = 0;
		for(int i = 0; i < M; i++) {
			if(prefixSumCnt[i] > 0) {

				/**
				 * 모듈러값의 카운팅숫자 n의 조합의 개수를 구하면 된다.
				 * 왜냐하면 아래와 같이 문제의 테스트케이스 조건을 예시로 들때
				 * 5 3
				 * 1 2 3 1 2 의 누적합의 모듈러연산값은
				 * 1 0 0 1 0 이고
				 * 0-0을 이루는 i,j쌍은 (2,3)(2,5)(3,5) 이고, 이 세개의 쌍(n=3)을 가지고 문제의 조건을 만족하는 구간합을 구한다는 것은
				 * i,j쌍 n=3, r=2(쌍 2개를 뽑으므로)일때의 "오름차순으로 나열된" 순열의 개수와 같은 의미이고,(== (2,3)쌍이 (2,5)쌍보다 더 뒤에 올 수 없다)
				 * 이는 또다시 조합의 개수와 의미가 같다.
				 * 따라서 n이 카운팅값, r=2일때의 nCr 조합의 개수를 구하면 된다.
				 * nCr 조합 공식	: n! / (n-r)! r!
				 * 				=>	: n! / (n-2)! 2!
				 * 				=>	: n * (n-1) / 2
				 */
				result += ((long)prefixSumCnt[i] * (prefixSumCnt[i]-1) / 2);
			}
		}
		result += prefixSumCnt[0];	// 누적합의 모듈러연산값이 0인경우의 구간합(단독값이 아닌경우) 개수는 구했지만 0은 혼자만으로도 문제으 조건(%M == 0)을 만족한다. 따라서 별도로 한번더 계산해 주어야 함.

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}