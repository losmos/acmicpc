/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/17219
 	문제번호 : 17219
 	알고리즘 : 자료 구조, 해시를 사용한 집합과 맵
*/
package Step_etc.a17219_비밀번호찾기;

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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
	}
}