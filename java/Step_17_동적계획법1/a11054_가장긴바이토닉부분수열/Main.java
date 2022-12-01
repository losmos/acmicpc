/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11054
 	문제번호 : 11054
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a11054_가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * ==========================================================
 * [잘못 설계했었던 문제풀이 컨셉]
 * 오름차순으로 증가하는 가장 긴 부분수열을(LIS) 찾고, 내림차순으로 감소하는 가장 긴 부분수열을(LDS) 찾은다음 두개를 합친다.
 * Step01. LIS를 찾은 다음 마지막 index 그 뒤부터 LDS를 찾아본다.
 * Step02. LDS를 찾은 다음 처음 index, 그 앞부터 LIS를 찾아본다.
 * 위 두 케이스 중 더 긴 케이스를 출력한다.
 * (단, Step01.을 수행하는데있어 LIS dp의 max값이 배열의 마지막에 위치하는 상황이라면, 늘어났다줄어드는 바이토닉 수열을 이루지 못하기 때문에 
 * LIS뒤에오는 내림차순값을 찾는게 의미 없으므로(다음에오는 내림차순 값이 없기때문에) Step02를 검사하기위해 넘어간다.)
 * 
 * (내용추가+)
 * 반례
 * 10
 * 1 2 5 2 1 84 3 60 3 61
 * answer : 6 (1-2-5-84-60-3)
 * 
 * 위 반례를보면 알 수 있듯이 LIS와 LDS를 합치는방식이 꼭 가장긴 바이토닉수열을 이루는건 아니다.
 * 설계대로라면 output : 5가 나오는데, 정답은 6이다.
 * 설계가 잘못되었음.
 * ==========================================================
 * [문제풀이 컨셉]
 * 가장 긴 바이토닉수부분열은 오름차순으로 올라가다가, 어느지점에서부터는 내림차순으로 내려가는 형태를 띈다.
 * 그 올라가다 꺾여 내려가는 꼭대기지점을 peak라고 칭한다고 했을 때,
 * 이 peak를 arr[]배열의 index 0 부터 length만큼 오른쪽으로 한칸씩 옮겨가며 구해본다.
 * 예를들어 peak index가 3이라면, 0 ~ 3까지는 LIS를 구하고. 3 ~ arr.length 까지는 LDS를구해본다.
 * 
 * 
 * 좀더 구체적으로, peak index가 3일때의 바이토닉수열max값을 구해보고, peak index가 4일떄의 바이토닉수열 max값을 구해보고, peak index가 5일때..., peak index가 6일때..
 * 이런식으로 구해보면 시간복잡도상으로 엄청나게 비효율적인것을 알 수 있다.
 * 따라서 peak가 N일때
 * peak가 0일때의 케이스를 메모이제이션 해주고
 * peak가 1일때의 케이스를 메모이제이션 해주고
 * peak가 2일때의 케이스를 메모이제이션 해주고
 * peak가 3일때의 케이스를 메모이제이션 해주고...
 * peak가 N일때의 케이스 를 각기달리 구해가며 메모이제이션을 해준다면. 중첩for문을 한번 돌고나서 이 검사를 끝낼 수가 있다.
 * 따라서 중첩for가 진행됨에따라 검사하기위해서 arr배열의 개수는 N만큼 더 가지고있어야한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[N][N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		// i=0 일때 peak는 0
		// i=1 일때 peak는 1 
		// i=n 일때 peak는 n...
		// peak전까지는 LIS, peak 이후에는 LDS를 구한다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dp[i][j] = 1;	// arr[i][j]일때의 부분수열 길이는 본인 길이인, 최소의 값 1이다.
				for(int k = 0; k < j; k++) {
					if(k < i) {
						if(arr[j] > arr[k] && dp[i][j] <= dp[i][k]) {
							dp[i][j] = dp[i][k] + 1;
						}
					} else {
						if(arr[j] < arr[k] && dp[i][j] <= dp[i][k]) {
							dp[i][j] = dp[i][k] + 1;
						}
					}
				}
				if(dp[i][j] > max) {	// LIS 최대값 갱신조건
					max = dp[i][j];
				}
			}
		}

		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}