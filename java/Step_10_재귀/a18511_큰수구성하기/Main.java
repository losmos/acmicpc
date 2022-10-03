/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/18511
 	문제번호 : 18511
 	알고리즘 : 브루트포스 알고리즘, 재귀
*/
package Step_10_재귀.a18511_큰수구성하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * [문제풀이 컨셉]
 * dfs로 풀거임.
 * 숫자 N이 입력되고 차례대로 K의 원소를 kArr 배열에 담는다. 그리고 kArr배열을 오름차순으로 정렬해줌
 * dfs 태우면서 nowDepth가 마지막까지 도달하면 검사를 종료하고 return하는데, 단 조건이있음.
 * 일단 브루트포스로 전체 100% 다 검사하지 않을거임. 정렬된 kArr의 맨뒤 숫자부터(제일 큰 숫자값) 꺼내가지고 sb.append해줘 본다음에,
 * 이 sb에들어간 숫자 뒤로. nSize 자리수만큼 0으로채웠을때 N보다크다면 해보나마나 dfs를 태워봐야 N보다 숫자가 커질거기때문에 더이상 검사를 진행하지 않고 return해줌.
 * 다음 숫자로 다시dfs를 태우는 식으로 반복.
 * 
 * 그런데, 이렇게되면 최초 입력된 숫자 N의 자리수와 "동일한 자리수"를 가진조건하에만 숫자를 만들어 검사할 수 있음. 아래 반례조건 참고.
 * 반례) 
 * 100000000 1
 * 1
 * answer: 11111111
 * 
 * 따라서. 입력된 K 숫자로 N보다 작거나같은 수를 만들 수 없을때(동일한 자리수를 가지는)
 * 자리수를 1개 줄여야됨.
 * 따라서 targetDepth를 -1해주고, changedTargetDepth = true로 바꿔서. 타겟뎁스가 변경됐다고 표시해주고
 * dfs를 한번 더태우면 결과를 정상적으로 출력 할 수 있음.
 */

class KInfo {
	int N;
	int K;
	int nSize;
	int targetDepth;
	boolean changedTargetDepth;
	int[] kArr;
	boolean[] visited;
	StringBuilder sb;

	KInfo(int N, int K, String nStr) {
		this.N = N;
		this.K = K;
		nSize = setNsize(nStr);
		targetDepth = nSize;
		kArr = new int[K];
		visited = new boolean[nSize+1];
		sb = new StringBuilder();
	}

	public int setNsize(String nStr) {
		return nStr.length();
	}
}

public class Main {

	public boolean dfs(KInfo kInfo, int nowDepth) {
		// K숫자의 조합으로 N의 자리수만큼 숫자를 완성했다면
		if(nowDepth == kInfo.targetDepth) {
			if(Integer.parseInt(kInfo.sb.toString()) > kInfo.N) {
				return false;
			} else {
				return true;
			}
		}

		// kInfo.changedTargetDepth가 false일경우에만 진입함. 자세한내용은 맨위 문제풀이 컨셉 참고.
		if(!kInfo.changedTargetDepth && kInfo.sb.length() != 0) {
			int snapNumber = Integer.parseInt(kInfo.sb.toString());	// 완성되어가고 있는 숫자의 snapshot number
			if(!kInfo.visited[nowDepth]) {	// 해당 depth에 최초 진입
				kInfo.visited[nowDepth] = true;

				if(snapNumber * Math.pow(10, kInfo.nSize-nowDepth) > kInfo.N) {	// snapNumber로는 N보다 작거나같은수를 만들수 없을 때
					kInfo.visited[nowDepth] = false;	// 다음검사를 위해 visited false로 초기화
					return false;
				}
			}
		}

		// kInfo.kArr은 오름차순 정렬되어있음. 뒤에서부터 숫자를 하나씩넣어봄
		for(int i = kInfo.K-1; i >= 0; i--) {
			kInfo.sb.append(kInfo.kArr[i]);

			if(dfs(kInfo, nowDepth+1)) {
				return true;	// 숫자 완성됐음!
			} else {
				kInfo.sb.delete(kInfo.sb.length()-1, kInfo.sb.length());
				kInfo.visited[nowDepth] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		String nStr = st.nextToken();
		int N = Integer.parseInt(nStr);
		int K = Integer.parseInt(st.nextToken());
		KInfo kInfo = new KInfo(N, K, nStr);

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			kInfo.kArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(kInfo.kArr);	// kARr배열 오름차순 정렬
		if(!main.dfs(kInfo, 0)) {	// 맨위 [문제풀이 컨셉] 참고. targetDepth를 하나 줄여서 dfs 한번 더 call
			kInfo.targetDepth -= 1;
			kInfo.changedTargetDepth = true;
			main.dfs(kInfo, 0);
		}

		bw.write(kInfo.sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}
