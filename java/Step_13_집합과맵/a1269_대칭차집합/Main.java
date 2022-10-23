/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1269
 	문제번호 : 1269
 	알고리즘 : 자료구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
*/
package Step_12_집합과맵.a1269_대칭차집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	/**
	 * 집합의 원소는 중복허용 안되므로 map 쓰면 됨.
	 * A-B 와 B-A의 합집합의 개수를 구하는것이므로. 처음 A개수, B개수 입력받을때 A원소개수 + B원소개수를 가지고있다가 이 값에서
	 * A와B의 교집합 개수 * 2 만큼을 빼주고 출력해 주면됨.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<String, Boolean> map = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int totalCnt = A + B;
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < A; i++) {
			map.put(st.nextToken(), true);	// put
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < B; i++) {
			if(Boolean.TRUE.equals(map.containsKey(st.nextToken()))) {	// map에 input값을 가지는 key가 있다면
				totalCnt = totalCnt - 2;	// A에서도 제외, B에서도 제외해주므로 2를 빼줘야함
			}
		}

		// 출력
		bw.write(String.valueOf(totalCnt));

		br.close();
		bw.flush();
		bw.close();
	}
}