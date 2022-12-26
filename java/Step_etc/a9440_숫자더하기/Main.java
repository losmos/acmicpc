/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9440
 	문제번호 : 9440
 	알고리즘 : 그리디 알고리즘, 정렬
*/

package Step_etc.a9440_숫자더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            int[] arr = new int[N];
            int zeroCount = 0;
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == 0) {
                    zeroCount++;
                }
            }

            Arrays.sort(arr);

            // 0 카운트만큼 배열 수 스왑
            if(zeroCount > 0) {
                for(int i = 0; i < zeroCount; i++) {
                    int temp = arr[i];
                    arr[i] = arr[i+zeroCount];
                    arr[i+zeroCount] = temp;
                }
            }

            int num1 = 0;
            int num2 = 0;
            boolean switchFlag = false;
            for(int i = 0; i < N; i++) {
                if(!switchFlag) {
                    num1 = num1 * 10 + arr[i];
                } else {
                    num2 = num2 * 10 + arr[i];
                }
                switchFlag = !switchFlag;
            }

            sb.append(num1+num2).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}