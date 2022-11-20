/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11053
 	문제번호 : 11053
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a11053_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 15
 * 4 5 6 7 2 3 1 4 3 5 8 6 7 8 9 
 * 
 * 위 문제에서 가장 긴 증가하는 부분 수열은 4번째인덱스부터 시작하는 2 3 4 5 6 7 8 9 이다.
 * 하지만 더 낮은숫자로부터 시작하는 1 3 5 6 7 8 9 부분 수열이 더 길지 짧을지는 어떻게아나?. 
 * 보다시피 더 작은숫자로 시작하는 부분수열이 무조건적으로 더 길지는 않다.
 * 결국은 각 숫자로부터 시작하는 부분수열을 하나 하나 전부 검사해야 될거라고 생각이 들었다.
 * 그렇다면 어떻게??
 * 
 * 12
 * 1 3 4 5 6 7 2 3 4 5 6 7
 * 라는 문제가 주어졌을경우에
 * 처음에는 1을 start 요소로 지정한다음 뒤따라오는 3 4 5 6 7 를 붙여서 부분수열을 만들수도 있지만, 사실
 * 문제수열의 후반부에 나오는 2 3 4 5 6 7 을 붙이는게 더 긴 부분수열이된다.
 * 따라서 똑같이 1로시작하는 부분수열이라고 하더라도 1 3 4 5 6 7 이만들어 질수도 있고, 1 2 3 4 5 6 7 이 만들어 질 수도 있다.
 * 
 * 하지만 문제뒷부분이 조금 변형되서, 아래와 같다면
 * 10
 * 1 3 4 5 6 7 2 3 4 5 
 * 1 3 4 5 6 7 부분수열이 만들어 질 수도있고, 1 2 3 4 5 에서 끝나는 부분수열이 만들어 질 수도 있다. (편의상 전자를 부분수열a, 후자를 부분수열b라고 칭하겠음)
 * 그렇기때문에 1로 시작하는 부분수열을 만든다면, 부분수열a가 더 긴 부분수열일지, 부분수열b가 더 긴 부분수열일지는 각각의 부분수열열 케이스를 가지고 계산해놔야(각각의 케이스를 메모이제이션을 해놔야)
 * 길이가 N인 배열을 끝까지 검사한 뒤에야 비로소 부분수열a가 더긴지, 부분수열b가 더 긴지 알수가있다.
 * 기존의 dp처럼 길이가 N인 1차원 배열을 "1회 순회"하면서 누적값을 잘 만들어내는 계산방식(ex: 2156번, 포도주시식문제)의 dp는 사용할수가 없다. (시간복잡도 O(N))
 * 그렇다고 n*n 만큼 순회하면 당연히 시간초과뜨거나 메모리제한에 걸리겠지.
 * 
 * =================================================
 * (추가+)
 * 고민을 며칠동안이나 했다.
 * 어떻게든 시간복잡도 O(N)으로 풀려고 시간을 오래쏟고, 오래 고민했다.
 * DP문제라서 당연히(?) 여지껏 DP문제와 같이 O(N)으로 풀수 있을줄 알았다. 좀더 고민하면 방법을 찾을 수 있을줄 알았음.
 * give up 하고, 검색해보니 시간복잡도 O(N)으로 푸는 방법은 없는거 같고, 잘해봐야 O(N logN)으로 풀수있었다.
 * 그냥 O(N^2)으로 풀어도 되는 문제였으나, 한번에 잘 풀어보려고 욕심냈던게 오히려 독이됐달까.
 * 나름 괜찮다고 생각이 들거나, 될것같은 알고리즘이 떠오르면 그냥 구현해서 제출해 봐야겠단 생각이 듦.
 * 
 * (그렇다고 O(N^2) 시간복잡도를 가지는 점화식을 세우는게 쉽지는 않았음.)
 * 참고사이트 : https://developer-mac.tistory.com/71
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = 1;	// arr[i]일때의 LIS값은 부분수열 1개인 경우로, 최소한 값은 1이 된다.
			for(int j = 0; j < i; j++) {

				// dp를 활용하면서, arr[i]의 부분수열 최대값은 이미 메모이제이션 해뒀던 arr[j]의 부분수열 최대값에 +1을 해주면 되는데, 조건이있음
				// arr[i]의값이 arr[j]보다 크면서(값이 증가한다는 뜻) && dp[i]의 값이 j일때 부분수열의 최대길이 보다 작을경우, 값을 갱신해주면됨.
				// (dp[i]값이 이미 최대값을 찍었는데 dp[j] 값 + 1을 무조건적으로 해주면 max값을 유지할 수 없기때문에 dp[i] <= d[j]일때만 dp[i]값을 갱신해줌)
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if(dp[i] > max) {	// LIS 최대값 갱신조건
				max = dp[i];
			}	
		}

		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}