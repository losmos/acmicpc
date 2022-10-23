/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10816
 	문제번호 : 10816
 	알고리즘 : 자료구조, 정렬, 이분탐색, 해시를 사용한 집합과 맵
*/
package Step_13_집합과맵.a10816_숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

	/**
	 * map을 <String, Integer> 형태로만들고. input값을 받았을 때 이미 map에 key가 있다면 value +1 해주는형태로 풀면될듯.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		String input = "";
		for(int i = 0; i < N; i++) {
			input = st.nextToken();
			if(map.containsKey(input)) {	// map에 이미 input값을 가지는 key가 있다면 
				map.replace(input, map.get(input) + 1);	// value값에다 1을 더해줌
			} else {
				map.put(input, 1);	// put
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < M; i++) {
			input = st.nextToken();
			if(map.containsKey(input)) {		// input값을 가지는 key가 있으면
				bw.write(map.get(input) + " ");	// 매핑되는 value 출력
			} else {	// 없으면 "0" 출력
				bw.write("0" + " ");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}