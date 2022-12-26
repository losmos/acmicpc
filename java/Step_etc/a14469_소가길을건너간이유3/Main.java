/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14469
 	문제번호 : 14469
 	알고리즘 : 그리디 알고리즘, 정렬
*/
package Step_etc.a14469_소가길을건너간이유3;

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
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]){
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		// 정렬결과 출력용
		/* 
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i][0] + " ");
			System.out.println(arr[i][1]);
		}
		*/

		int totalTime = 0;
		for(int i = 0; i < N; i++) {
			if(totalTime > arr[i][0]) {
				// Nothing
			} else {
				totalTime += arr[i][0] - totalTime;
			}

			totalTime += arr[i][1];
		}

		br.close();
		bw.write(totalTime + "");
		bw.flush();
		bw.close();
	}
}