/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14889
 	문제번호 : 14889
 	알고리즘 : 브루트포스 알고리즘, 백트래킹
*/
package Step_16_백트래킹.a14889_스타트와링크;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * 1 2 3 4 5 6
	 * 
	 * 1 2 3    4 5 6
	 * 1 2 4    3 5 6
	 * 1 2 5    3 4 6
	 * 1 2 6    3 4 5	N=6일때 절반값 3만큼을 뽑는 조합의 수인데, 조건이 있다.
	 * 1 3 4    2 5 6	1은 고정값으로 두고 나머지 N/2 - 1 만큼의 개수만큼만 뽑아서 조합하는데
	 * 1 3 5    2 5 6	오름차순으로만 뽑으면 된다.(1,3,5 뽑고 1,5,3을 다시 뽑을 필요 없음)
	 * 1 3 6    2 4 5	그렇게 만들고나면 나머지 절반값은 남는걸로 자동으로 할당해주면 된다.
	 * 1 4 5    2 3 6
	 * 1 4 6    2 3 5
	 * 1 5 6    2 3 4
	 */

class SIJ {
	int N;
	int halfN;
	boolean[] visited;
	int[][] S;
	int minGap = 1000;
	int prev = 0;		// dfs태울때 직전에 선택한 팀번호.

	SIJ(int N) {
		this.N = N;
		halfN = N/2;
		visited = new boolean[N];
		S = new int[N][N];
	}
}

class Main {

	public void dfs(SIJ sij, int nowDepth) {
		if(nowDepth == sij.halfN) {		// N/2만큼만 dfs 돌면됨.
			int startTeam = 0;
			int linkTeam = 0;
			for(int i = 0; i < sij.N; i++) {
				for(int j = 0; j < sij.N; j++) {
					if(i == j) {
						continue;
					}

					if(sij.visited[i] && sij.visited[j]) {
						startTeam += sij.S[i][j];
					} else if(!sij.visited[i] && !sij.visited[j]) {
						linkTeam += sij.S[i][j];
					}
				}
			}

			if(sij.minGap > Math.abs(startTeam - linkTeam)) {
				sij.minGap = Math.abs(startTeam - linkTeam);	// 두 팀의 스텟차이 최소값 갱신
			}

			return;
		}

		for(int i = sij.prev; i < sij.N; i++) {
			if(nowDepth > i) {		// 조합의 오름차순 조건
				continue;
			}

			if(!sij.visited[i]) {
				sij.visited[i] = true;
				sij.prev = i;
				dfs(sij, nowDepth+1);
				if(sij.minGap == 0) {
					return;
				}
				sij.visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		SIJ sij = new SIJ(N);

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				sij.S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sij.visited[0] = true;
		main.dfs(sij, 1);

		br.close();
		bw.write(sij.minGap + "");
		bw.flush();
		bw.close();
	}
}