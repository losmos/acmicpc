/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14888
 	문제번호 : 14888
 	알고리즘 : 브루트포스 알고리즘, 백트래킹
*/
package Step_16_백트래킹.a14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/**
	 * [문제풀이 컨셉]
	 * dfs로 푼다.
	 * operator를 배열에 넣는데 개수만큼의 length를 할당함
	 * operator 기준으로 dfs를 돌리는데 nowDepth가 1씩증가할때마다 numbersIndex++ 해주면서 numbers[]에서 꺼내씀
	 */

class CalcInfo {
	int N;
	int[] numbers;
	int[] operator;
	int numbersIndex = 0;	// numbers 배열 포인터역할
	boolean[] visitedOp;	// operator visited Info
	int min = 1000000000;
	int max = -1000000000;
	int nowDepth = 0;		// dfs 현재 depth
	int targetDepth;		// dfs 목표 depth

	CalcInfo(int N) {
		this.N = N;
		numbers = new int[N];
		operator = new int[N-1];
		visitedOp = new boolean[N-1];
		targetDepth = N-1;
	}
}

class Main {

	public void dfsReady(CalcInfo calcInfo) {

		for(int i = 0; i < calcInfo.targetDepth; i++) {
			calcInfo.numbersIndex = 1;

			calcInfo.visitedOp[i] = true;
			calcInfo.nowDepth++;
			dfs(calcInfo, calcInfo.numbers[calcInfo.numbersIndex], calcInfo.operator[i], calcInfo.numbers[0]);
			calcInfo.nowDepth--;
			calcInfo.visitedOp[i] = false;
		}
	}

	public void dfs(CalcInfo calcInfo, int num, int op, int sum) {
		// 0 : 덧셈, 1 : 뺄셈, 2 : 곱셈, 3 : 나눗셈
		if(op == 0) {
			sum += num;
		} else if (op == 1) {
			sum -= num;
		} else if (op == 2) {
			sum *= num;
		} else if (op == 3) {
			sum /= num;
		}

		if(calcInfo.nowDepth == calcInfo.targetDepth) {
			if(sum < calcInfo.min) {
				calcInfo.min = sum;
			}
			if(sum > calcInfo.max) {
				calcInfo.max = sum;
			}
			return;
		}

		for(int j = 0; j < calcInfo.targetDepth; j++) {
			if(!calcInfo.visitedOp[j]) {
				calcInfo.visitedOp[j] = true;
				calcInfo.numbersIndex++;
				calcInfo.nowDepth++;
				dfs(calcInfo, calcInfo.numbers[calcInfo.numbersIndex], calcInfo.operator[j], sum);
				calcInfo.nowDepth--;
				calcInfo.numbersIndex--;
				calcInfo.visitedOp[j] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		CalcInfo calcInfo = new CalcInfo(N);

		// input numbers
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			calcInfo.numbers[i] = Integer.parseInt(st.nextToken());
		}
	
		// input operator
		st = new StringTokenizer(br.readLine());
		int index = 0;
		for(int i = 0; i < 4; i++) {
			int operTemp = Integer.parseInt(st.nextToken());

			if(operTemp == 0) {
				continue;
			}

			for(int j = 0; j < operTemp; j++) {
				calcInfo.operator[index++] = i;
			}
		}

		main.dfsReady(calcInfo);

		bw.write(calcInfo.max + "\n");
		bw.write(calcInfo.min + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}