/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1932
 	문제번호 : 1932
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_16_동적계획법1.a1932_정수삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 *         7
 *       3   8
 *     8   1   0
 *   2   7   4   4
 * 4   5   2   6   5
 * 
 * 예를들어 위 삼각형이 있을때 두번째줄 3,8은 바로위 7을 더해주면되고
 * 세번째줄에서 1을 기준으로 봤을때, 대각선윗줄의 왼쪽 or 오른쪽 숫자중 max값을 골라서 더해주면됨. (위에줄에있는 숫자또한 누적해서 더해온 값임)
 * 그 아래줄도 계속해서 마찬가지 경우.
 * 
 * 점화식을 찾아보면
 * arr[n][m] 은 대각선방향 위에있는 arr[n-1][m] 또는 arr[n-1][m-1] 을 받아서 더할수가 있음, 둘중 더 큰값을 골라서 맨 아래까지 누적으로 더해줘가면 됨.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i != 0 && j != 0) {	// 인덱스 벗어나지 않도록, 조건 명시
					arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);	// 대각선 위쪽 두개의 숫자중, 더 큰수를 더함
				} else if (i != 0 && j ==0) {
					arr[i][j] += arr[i-1][j];	// 바로 위 숫자를 더해줌
				}
			}	
		}

		int max = arr[n-1][0];
		for(int i = 1; i < n; i++) {
			if(arr[n-1][i] > max) {		// 삼각형 맨 밑바닥 줄에서 max값을 찾음
				max = arr[n-1][i];
			}
		}

		br.close();
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}