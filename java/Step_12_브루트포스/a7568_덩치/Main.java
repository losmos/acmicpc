/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/7568
 	문제번호 : 7568
 	알고리즘 : 구현, 브루트포스 알고리즘
*/
package Step_12_브루트포스.a7568_덩치;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Body {
	int weight;
	int height;

	public Body(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}

class Main {

	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Body[] bodyArr = new Body[N];

		for( int i = 0; i < N; i ++) {	// bodyArr 초기화
			st = new StringTokenizer(br.readLine(), " ");
			bodyArr[i] = new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 순위판정. 문제를 잘읽어야함.
		// 나보다 작은body가 몇명이냐를 세는게 아니라.
		// 나보다 큰놈이 몇명인지를세서 나의 순위를 정함. 예를들어서
		/* 아래 반례를보면 알 수 있듯이 제일 낮은순위가 N값이 아닐 수 있음. 아래 예시처럼 꼴등이 6위가 아니라 3등임을 알 수 있음.
		6
		55 181
		54 181
		56 181
		55 179
		56 182
		54 190
		2 2 1 3 1 1
		 */
		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i == j ) {
					continue;
				}

				if(getBiggerBody(bodyArr[j], bodyArr[i])) {
					rank++;
				}
			}

			bw.write(String.valueOf(rank) + " ");
		}

		bw.flush();
		bw.close();
	}

	/** body1이 body2보다 덩치가 더 클경우 return true */
	public boolean getBiggerBody(Body _body1, Body _body2) {
		if(_body1.height > _body2.height && _body1.weight > _body2.weight) {
			return true;	
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		main.run();
	}
}