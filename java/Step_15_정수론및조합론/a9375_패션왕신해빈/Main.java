/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9375
 	문제번호 : 9375
 	알고리즘 : 수학, 자료구조, 조합론, 해시를 사용한 집합과 맵
*/
package Step_15_정수론및조합론.a9375_패션왕신해빈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	/**
	 * 쉽게 생각하면 어렵지않다.
	 * 상의, 하의, 신발이 있다고할때 상의 중에서 고를수있는 가지수 x 하의 고를수 있는 가지수 x 신발 고를 수 있는 가지수를 계산하면
	 * 입을 수 있는 모든 경우의 수가 나온다.
	 * 단, 위처럼 계산하면 상의,하의,신발 을 반드시 입고있는 상태의 경우만이기 때문에 부분적으로 안입는 경우를 고려하지 못한상태임.(예를들어 상의를 벗고 하의,신발을 입는다던지)
	 * 따라서 의상가지수에 아무것도 입지않은 상태의 가지수 +1을 해주고 계산을 해주어야 함
	 * (상의 가지수 +1) * (하의 가지수 +1) * (신발 가지수 + 1) 해주고. 전부벗는 1가지의 경우의수를 빼주면된다.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		Map<String, Integer> map = null;
		
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			map = new HashMap<>();

			int n = Integer.parseInt(br.readLine());	// 의상 수
			for(int j = 0; j < n; j ++) {	// 의상 수 만큼 loop 
				st = new StringTokenizer(br.readLine());
				st.nextToken();	// 의상 이름, 사용하지 않기 때문에 변수에 할당하지 않았음
				String key = st.nextToken();	// key : 의상 카테고리(종류)

				if(map.containsKey(key)) {
					map.put(key, map.get(key) + 1);	// 같은 카테고리(종류)의 의상이 있다면 해당카테고리 의상개수 + 1
				} else {
					map.put(key, 1);
				}
			}

			int result = 1;
			for (int v : map.values()) {
				result = result * (v+1);
			}
			bw.write(String.valueOf(result-1) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}