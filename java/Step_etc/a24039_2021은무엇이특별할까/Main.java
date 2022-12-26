/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/24039
 	문제번호 : 24039
 	알고리즘 : 수학, 정수론, 소수 판정
*/

package Step_etc.a24039_2021은무엇이특별할까;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 에라토스테네스의 체 활용해서 소수를 구하고
 * 연속된 소수의 곱이 N이넘으면 출력한다.
 */
public class Main {

	public void useEratosthenes(int N) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] primeNums = new boolean[103+1];	// 최종값 false에 해당하는 주소값이 소수임

		// 에라토스 테네스의 체를 활용해서 소수 구하기
		for(int i = 2; i*i <= 103; i++) {
			if(primeNums[i]) {	// 이미 에라토스테네스의 체에 걸러졌으면 continue
				continue;
			}

			for(int j = i*i; j <= 103; j+=i) {
				primeNums[j] = true;	// 소수아닌건 true로
			}
		}

		// 소수 출력용
		/*
		for(int i = 2; i <= 103; i++) {
			if(!primeNums[i]) {
				System.out.println(i);
			}
		}
		*/

		int prev = 0;
		for(int i = 2; i <= 103; i++) {
			if(!primeNums[i]) {
				if(prev * i > N) {
					bw.write((prev * i) + "");
					break;
				} else {
					prev = i;
				}
			}
		}

		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Main main = new Main();
		main.useEratosthenes(Integer.parseInt(br.readLine()));
		br.close();
	}
}