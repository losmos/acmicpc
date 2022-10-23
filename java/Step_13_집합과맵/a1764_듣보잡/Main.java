/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1764
 	문제번호 : 1764
 	알고리즘 : 자료구조, 문자열, 정렬, 해시를 사용한 집합과 맵
*/
package Step_13_집합과맵.a1764_듣보잡;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

	/**
	 * map 사용하면 될듯. <String, Boolean> 타입으로만들고 출력하면되는데,
	 * 총 개수를 먼저출력해야되므로 StringBuilder에 숫자먼저 넣고. 뒤에 결과를 append 해주면 될듯.
	 * 
	 * (추가+). 출력할때 정렬해서 출력해야되네. StringBuilder 필요없음. 문제 잘읽자.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> resultStr = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), true);	// put
		}
		
		String input = "";
		int resultCnt = 0;
		for(int i = 0; i < M; i++) {
			input = br.readLine();

			if(Boolean.TRUE.equals(map.containsKey(input))) {	// map에 input값을 가지는 key가 있다면
				resultCnt++;
				resultStr.add(input);
			}
		}

		Collections.sort(resultStr);	// 알파벳 순서대로 정렬

		// 출력
		bw.write(String.valueOf(resultCnt) + "\n");
		for(String item : resultStr) {
			bw.write(item + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}