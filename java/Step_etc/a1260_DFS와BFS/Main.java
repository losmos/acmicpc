/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1260
 	문제번호 : 1260
 	알고리즘 : 그래프 이론, 그래프 탑색, 너비 우선 탐색, 깊이 우선 탐색
*/
package Step_etc.a1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class NodeInfo {
	int N;
	boolean[][] arr = null; // arr[n][m] == true 일경우 노드 n과 m은 간선으로 연결되어있다.
	boolean[] visited = null;

	StringBuilder sb = new StringBuilder();

	NodeInfo(int N, int M) {
		this.N = N;
		arr = new boolean[N+1][N+1];
		visited = new boolean[N+1];
	}
}

public class Main {

	public NodeInfo dfs(NodeInfo nodeInfo, int index) {

		for(int i = index; i <= nodeInfo.N; i++) {
			if(!nodeInfo.visited[i]) {
				nodeInfo.visited[i] = true;
				nodeInfo.sb.append(i).append(" ");
			} else {
				continue;
			}

			for(int j = 1; j <= nodeInfo.N; j++) {
				if(nodeInfo.arr[i][j] && !nodeInfo.visited[j]) {	// i와j가 간선으로 연결되어있고, 한번도 방문 한적 없으면
					dfs(nodeInfo, j);
				}
			}
		}

		return nodeInfo;
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		
		int N = Integer.parseInt(st.nextToken());	// 정점(노드)의 개수
		int M = Integer.parseInt(st.nextToken());	// 간선의 개수
		int V = Integer.parseInt(st.nextToken());	// 출발 노드번호
		
		NodeInfo nodeInfo = new NodeInfo(N, M);

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodeInfo.arr[node1][node2] = true;
			nodeInfo.arr[node2][node1] = true;
		}

		nodeInfo = main.dfs(nodeInfo, V);	// node번호는 1번부터 시작함

		br.close();
		bw.write(nodeInfo.sb.toString());
		bw.flush();
		bw.close();
	}
}