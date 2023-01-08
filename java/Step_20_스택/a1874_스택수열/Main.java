/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/1874
문제번호 : 1874
알고리즘 : 자료 구조, 스택
*/

package Step_20_스택.a1874_스택수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 입력된 수열을 만들기 불가능한경우 NO를 출력하는데
 * 입력을 받으면서 NO인 경우인지를 우선적으로 판별한다.
 * 
 * 01. boolean[] noCheck 배열을만들고. pop되는숫자값을 true로한다.
 * 02. 숫자가 차례로입력 되는데, 입력되는 수가 내림차순이 될 경우, 연속적으로 줄어들어야만 함.
 * 하지만, 불연속적으로 줄어드는 경우에도(ex 8 7 5) 예를들어 중간숫자 6이 true 인경우에는 통과한다. 만일 false일경우에는 불가능한 경우이므로 NO를 출력한다.
 * 
 * 그외는 수열을 만들수 있는 경우이므로, 차례대로 기호를 출력해준다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		boolean[] noCheck = new boolean[n+1];
		boolean noCheckResult = false;	// true : 수열생성이 불가능한경우, false : 수열 생성이 가능한 경우

		
		int prev = Integer.parseInt(br.readLine());
		arr[1] = prev;
		noCheck[prev] = true;

		outer: for(int i = 2; i <= n; i++) {	// 불가능한 경우인지 먼저 판별한다.
			int input = Integer.parseInt(br.readLine());
			arr[i] = input;
			if(input < prev) {	// 값이 내림차순으로 입력되고 있을 때
				for(int j = input+1; j < prev; j++) {	// input ~ prev 사이 값이
					if(!noCheck[j]) {	// pop이 되어있지 않다면, 즉 예를들어서 8을 pop하고 6을pop하기위해선 7이 pop이 되어있어야하는데 그런경우가 아니라면
						noCheckResult = true;	// 수열생성이 불가능한경우이다.
						sb.append("NO");	// 출력할 sb
						break outer;
					}
				}
			}
			noCheck[input] = true;
			prev = input;
		}

		if(!noCheckResult) {	// 수열을 만들 수 있는경우
			int pointer = 0;
			for(int i = 1; i <= n; i++) {
				if(arr[i] < pointer) {	// 내림차순으로 입력되는 경우
					sb.append("-").append("\n");	// pop
				} else {	// 오름차순으로 입력되는 경우
					for(int j = pointer; j < arr[i]; j++) {
						sb.append("+").append("\n");	// push
					}
					sb.append("-").append("\n");	// pop
				}
	
				if(arr[i] > pointer) {	// 현재 스택의 맨 꼭대기를 가리키는 포인터위치 조정
					pointer = arr[i];
				}
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}