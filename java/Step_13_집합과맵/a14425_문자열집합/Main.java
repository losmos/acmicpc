/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14425
 	문제번호 : 14425
 	알고리즘 : 자료구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
*/
package Step_12_집합과맵.a14425_문자열집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

	/**
	 * map을 써보자.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<String, Boolean> map = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), true);	// map에 put
		}

		int resultCnt = 0;
		for(int i = 0; i < M; i++) {
			// map.get 값이 null 이 아니고 true일경우를 만족하면
			if(Boolean.TRUE.equals(map.containsKey(br.readLine()))) {
				resultCnt++;
			} 
		}

		bw.write(String.valueOf(resultCnt));
		br.close();
		bw.flush();
		bw.close();

	}
}