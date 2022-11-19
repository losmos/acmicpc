/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2559
 	문제번호 : 2559
 	알고리즘 : 누적 합, 두 포인터, 슬라이딩 윈도우
*/
package Step_18_누적합.a2559_수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 누적합 배열을 먼저 생성하고.
 * K일동안의 누적합온도를 구하면서 max값을 찾는다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		

		st = new StringTokenizer(br.readLine());
		int max = -100000000;
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());	// 온도의 누적합
			if(i >= K) {	// K열이 지나기전에 아래코드가 계산되면 arr[i-K]부분에서 인덱스를 벗어나게된다.
				int temperature = arr[i] - arr[i-K];	// 연속된 K일간의 온도 누적합
				if(temperature > max) {	// max값 갱신조건
					max = temperature;
				}
			}
		}

		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}