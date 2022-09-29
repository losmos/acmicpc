/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1920
 	문제번호 : 1920
 	알고리즘 : 자료 구조, 이분 탑색
*/
package Step_etc.a1920_수찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제의 의도는 이분탐색인거 같지만.
 * 딱봐도 map쓰고싶은 문제임.
 * map을 써보겠음.
 */
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> inputList = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inputList.put(Integer.parseInt(st.nextToken()),true);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(inputList.containsKey(Integer.parseInt(st.nextToken()))) {
                sb.append("1" + "\n");
            } else {
                sb.append("0" + "\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
	}
}