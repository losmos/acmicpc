/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/6603
 	문제번호 : 6603
 	알고리즘 : 수학, 조합론, 백트래킹, 재귀
*/
package Step_10_재귀.a6603_로또;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * [문제풀이 컨셉]
 * dfs로 풀거임.
 * kArr에 있는 숫자중에서 6개를 조합으로 뽑음
 * 오름차순으로만 구성된 로또번호 경우의수기때문에 prev 변수를 두고 사용
 */

class LottoInfo {
	int k;
	int[] kArr;	// 배열에있는 숫자중에서 6개를 조합으로 뽑음
	int[] pickedLotto = new int[6];	// 뽑은 로또번호 저장 배열
	int pickedLottoIdx = 0;			// pickedLotto 배열에 로또번호를 저장할때 포인터(index)역할
	boolean[] visited;				// dfs 방문여부
	int prev = 0;					// 직전에 저장한 로또번호 index
	StringBuilder sb = new StringBuilder();

	LottoInfo(int k) {
		this.k = k;
		kArr = new int[k];
		visited = new boolean[k];
	}
}

public class Main {

	public void dfs(LottoInfo lottoInfo, int nowDepth) {
		if(nowDepth == 6) {
			for(int i = 0; i < 6; i++) {
				lottoInfo.sb.append(lottoInfo.pickedLotto[i]).append(" ");
			}
			lottoInfo.sb.append("\n");
			return;
		}

		for(int i = lottoInfo.prev; i < lottoInfo.k; i++) {
			if(!lottoInfo.visited[i]) {
				lottoInfo.visited[i] = true;
				lottoInfo.prev = i;
				lottoInfo.pickedLotto[lottoInfo.pickedLottoIdx] = lottoInfo.kArr[i];	// 로또번호 저장
				lottoInfo.pickedLottoIdx++;
				dfs(lottoInfo, nowDepth+1);		// dfs call
				lottoInfo.pickedLottoIdx--;
				lottoInfo.visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}

			LottoInfo lottoInfo = new LottoInfo(k);
			for(int i = 0; i < k; i++) {
				lottoInfo.kArr[i] = Integer.parseInt(st.nextToken());
			}

			main.dfs(lottoInfo, 0);
			bw.write(lottoInfo.sb.toString());
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}