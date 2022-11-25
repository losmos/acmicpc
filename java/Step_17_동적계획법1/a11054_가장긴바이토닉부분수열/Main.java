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
 * [문제풀이 컨셉]
 * 
 * 오름차순으로 증가하는 가장 긴 부분수열을(LIS) 찾고, 내림차순으로 감소하는 가장 긴 부분수열을(LDS) 찾은다음 두개를 합친다.
 * Step01. LIS를 찾은 다음 마지막 index 그 뒤부터 LDS를 찾아본다.
 * Step02. LDS를 찾은 다음 처음 index, 그 앞부터 LIS를 찾아본다.
 * 위 두 케이스 중 더 긴 케이스를 출력한다.
 * (단, Step01.을 수행하는데있어 LIS dp의 max값이 배열의 마지막에 위치하는 상황이라면, 늘어났다줄어드는 바이토닉 수열을 이루지 못하기 때문에 
 * LIS뒤에오는 내림차순값을 찾는게 의미 없으므로(다음에오는 내림차순 값이 없기때문에) Step02를 검사하기위해 넘어간다.)
 */
public class Main {

	public int step01(int[] arr, int startIdx, int N) {
		int[] tempDp = new int[N];
		int max = 0;
		for(int i = startIdx; i < N; i++) {
			tempDp[i] = 1;
			for(int j = startIdx; j < i; j++) {
				if(arr[i] < arr[j] && tempDp[i] <= tempDp[j]) {	// LDS 찾기
					tempDp[i] = tempDp[j] + 1;
				}
			}

			if(tempDp[i] > max) {
				max = tempDp[i];
			}	
		}
		return max;
	}

	public int step02(int[] arr, int lastIdx, int N) {
		int[] tempDp = new int[N];
		int max = 0;
		for(int i = 0; i <= lastIdx; i++) {
			tempDp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && tempDp[i] <= tempDp[j]) {	// LIS 찾기
					tempDp[i] = tempDp[j] + 1;
				}
			}

			if(tempDp[i] > max) {
				max = tempDp[i];
			}	
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dpAsc = new int[N];	// LIS
		int[] dpDesc = new int[N];	// LDS
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ascMaxLength = 0;			// 가장 긴 증가하는 부분수열(LIS)중 가장 length가 긴 부분수열의 길이값
		int ascMaxIdx = -1;				// 가장 긴 증가하는 부분수열에서 max값의 index
		for(int i = 0; i < N; i++) {	// 가장 긴 증가하는 부분수열 만듦
			dpAsc[i] = 1;				// arr[i]일때의 LIS값은 부분수열 1개인 경우로, 최소한 값은 1이 된다.
			for(int j = 0; j < i; j++) {

				// dp를 활용하면서, arr[i]의 부분수열 최대값은 이미 메모이제이션 해뒀던 arr[j]의 부분수열 최대값에 +1을 해주면 되는데, 조건이있음
				// arr[i]의값이 arr[j]보다 크면서(값이 증가한다는 뜻) && dp[i]의 값이 j일때 부분수열의 최대길이 보다 작을경우, 값을 갱신해주면됨.
				// (dp[i]값이 이미 최대값을 찍었는데 dp[j] 값 + 1을 무조건적으로 해주면 max값을 유지할 수 없기때문에 dp[i] <= d[j]일때만 dp[i]값을 갱신해줌)
				if(arr[i] > arr[j] && dpAsc[i] <= dpAsc[j]) {
					dpAsc[i] = dpAsc[j] + 1;
				}
			}
			
			if(dpAsc[i] > ascMaxLength) {	//LIS 갱신조건
				ascMaxLength = dpAsc[i];
				ascMaxIdx = i;				// 최대값(max)의 index
			}	
		}

		if(ascMaxIdx != arr.length-1) {	// LIS가 끝점이 length-1이 아닐경우(== 바이토닉 수열일경우)
			ascMaxLength += main.step01(arr, ascMaxIdx, N) -1;
		}

		int descMaxLength = 0;				// 가장 긴 감소하는 부분수열(LDS)중 가장 length가 긴 부분수열의 길이값
		int descMaxIdx = -1;			// 가장 긴 감소하는 부분수열에서 max값의 index
		for(int i = 0; i < N; i++) {	// 가장 긴 감소하는 부분수열 만듦
			dpDesc[i] = 1;				// arr[i]일때의 LDS값은 부분수열 1개인 경우로, 최소한 값은 1이 된다.
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j] && dpDesc[i] <= dpDesc[j]) {
					dpDesc[i] = dpDesc[j] + 1;
				}
			}

			if(dpDesc[i] > descMaxLength) {	//LDS 갱신조건
				descMaxLength = dpDesc[i];
				descMaxIdx = i;				// 최대값(max)의 index
			}	
		}

		int max = dpDesc[descMaxIdx];
		int lastIdx = 0;
		for(int i = descMaxIdx; i >= 0; i--) {
			if(dpDesc[i] == max - 1) {
				lastIdx = i;
				max--;
			}
		}

		if(lastIdx != 0) {	// LDS 시작점이 0번째 index가 아닐경우(== 바이토닉 수열일경우)
			descMaxLength += main.step02(arr, lastIdx, N) -1;
		}

		br.close();
		bw.write((ascMaxLength > descMaxLength ? ascMaxLength : descMaxLength) + "");
		bw.flush();
		bw.close();
	}
}