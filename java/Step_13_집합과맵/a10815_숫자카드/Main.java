/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10815
 	문제번호 : 10815
 	알고리즘 : 자료구조, 정렬, 이분탐색
*/
package Step_13_집합과맵.a10815_숫자카드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

	/**
	 * 첫째 줄 : 상근이가 가지고 있는 카드의 개수
	 * 둘쨰 줄 : 상근이가 가지고 있는 카드 숫자들
	 * 셋째 줄 : 검사할 기준이되는 카드 개수
	 * 넷째 줄 : 검사할 기준이되는 카드 숫자들
	 * 
	 * 둘째줄에서 받은 상근이 카드를 sorting 하고. 넷째줄에서 숫자를 받을때마다 이분탐색으로 존재유무 검사하면될거같긴 한데
	 * 시간복잡도 측면에서 보면 그냥 hashmap사용이 제일 빠를거같은데? 일단 해보자
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<Integer, Boolean> map = new HashMap<>();	// 상근이의 카드숫자들을 넣을 map 선언

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), true);	// map에 put
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		int hitCount = 0;				// 검사카드를 상근이카드랑 비교했을 때 일치하는 카드의 개수가 상근이가 가지고있는 카드개수 N까지 도달한다면, 
										// 두카드 숫자가 일치할수있는 최대개수를 만족한 상태임. loop를 돌면서 더 검사할 필요 없음. 낭비임.
		for(int i = 0; i < M; i++) {
			if(hitCount == N) {
				break;
			}
			
			// map.get 값이 null 이 아니고 true일경우를 만족하면
			if(Boolean.TRUE.equals(map.get(Integer.parseInt(st.nextToken())))) {
				hitCount++;
				bw.write("1" + " ");
			} else {
				bw.write("0" + " ");
			}
		}

		br.close();
		bw.flush();
		bw.close();

	}
}