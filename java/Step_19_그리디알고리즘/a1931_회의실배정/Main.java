/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/1931
문제번호 : 1931
알고리즘 : 그리디 알고리즘, 정렬
*/

package Step_19_그리디알고리즘.a1931_회의실배정;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 2차원배열 arr[i][j] 에 회의시간정보를 담는다. 
 * j 기준으로 오름차순 정렬을 한다. (회의가 끝나는 시간 기준으로 오름차순 정렬)
 * 
 * 회의를 시작하고, 회의가 종료된시간에 가장 가까운 시작시간으로 회의를다시 시작하는 그리디알고리즘 진행
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		// 회의시간정보 arr에 할당
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]){
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		// 정렬결과 출력용
		/* 
		System.out.println("=========================");
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i][0] + " ");
			System.out.println(arr[i][1]);
		}
		System.out.println("=========================");
		*/

		int result = 0;
		int meetingEndTime = -1;
		for(int i = 0; i < N; i++) {
			if(arr[i][0] >= meetingEndTime) {	// 회의 시작시간이, 아까전에 끝난 회의 종료시간 이후라면
				meetingEndTime = arr[i][1];
				result++;
			}
		}

		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}