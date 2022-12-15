/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2167
 	문제번호 : 2167
 	알고리즘 : 구현, 누적 합
*/
package Step_etc.a2167_2차원배열의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];    // 입력값 담을 배열
        
        // 배열에 값 넣어줌
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int z = 0; z < K; z++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int a = i; a <= x; a++) {
                for(int b = j; b <= y; b++) {
                    sum += arr[a][b];
                }
            }
            sb.append(sum).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();        
	}
}