/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9322
 	문제번호 : 9322
 	알고리즘 : 자료 구조, 문자열, 해시를 사용한 집합과 맵
*/
package Step_etc.a9322_철벽보안알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		Map<String, Integer> publicKey1 = new HashMap<>();
		Map<Integer, String> encrypt = new HashMap<>();
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {	// 테스트케이스만큼 반복
			int n = Integer.parseInt(br.readLine());
			int[] publicKey2 = new int[n];

			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {	// 제 1 공개키
				publicKey1.put(st.nextToken(), j);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {	// 제 2 공개키
				publicKey2[j] = publicKey1.get(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {	// 암호문
				encrypt.put(publicKey2[j], st.nextToken());
			}

			for(int j = 0; j < n; j++) {
				sb.append(encrypt.get(j)).append(" ");
			}

			sb.append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}