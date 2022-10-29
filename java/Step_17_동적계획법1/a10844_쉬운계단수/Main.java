/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10844
 	문제번호 : 10844
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a10844_쉬운계단수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 문제 한 10번읽었는데 이해가안되서 문제를 이해하기위한 검색은 또 처음해봄.
 * N = 1 일때 1이나 2같은 한자리수도 계단수로 취급한다고한다.
 * 이유는
 * 인접한 자리가 없으면 문제의 조건을 충족시킬 수 없다고 생각하기 쉬운데, 이 경우는 조건을 위배시킬 수 없다고 보는 게 맞다고함.
 * 다시말해 조건을 바꿔 말하면 "어떤 두 자리가 인접하다면, 1의 차이가 난다"인데, 가정이 거짓인 명제는 참이라고한다.
 * 한 자리수는 어떤 두 자리가 인접할 수 없으므로 가정이 무조건 거짓이고, 따라서 조건을 만족함.
 * 
 * N = 2일때의 계단수는 아래와같다.
 * 12 23 34 45 56 67 78 89 98 87 76 65 54 43 32 21 10
 * 인접한 수 간의 차이가 1로 이루어진숫자를 계단수라고 한다.
 * 
 * 보면 10의자리수가 주어졌을때 1의자리수는 10의자리수 숫자보다 +1 이거나 -1이올수있는데, 뒤에오는 1의자리숫자가 가질수있는 계단수를 누적해서 더해줄수있다. 무슨말이냐면
 * 2x 라고했을때 2뒤에는 21, 23이올수있고. 뒤에오는 1,3 의 계단수는 각각 1가지이기때문에 총 두가지경우의수라고 할수있다.
 * 
 * N = 4 일때를보면
 * 2xxx뒤에는 21xx과 23xx이올수있고, 23xx 뒤에는 231x와 234x 가올수있다. 
 * 즉 n=4일때 2xxx는 n=3일때의 21xx 경우의수 + n=3일때 23xx 경우의수와같다.
 * 
 * 모듈러 분배법칙 유의할것.
 */
public class Main {
	
	public static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] canTakeNumber = new int[N+1][10];	// 숫자n이가질수 있는 경우의 계단수를 저장한다.
		for(int i = 1; i < 10; i++) {
			canTakeNumber[1][i] = 1;	// n = 1일때는 각 i숫자일때의 가질수있는 계단 경우의수가 한가지다. (계단수는 0으로시작할수없으므로 0일때의 계단수는 0이다)
		}

		for(int i = 2; i <= N; i++) {	// 숫자 i가 가질수있는 계단수의 경우의수
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					canTakeNumber[i][j] = canTakeNumber[i-1][1] % MOD;	// j가 0일때 뒤에올수있는수는 1밖에없다. (빼기 해주면 음수가됨)
				} else if(j == 9) {
					canTakeNumber[i][j] = canTakeNumber[i-1][8] % MOD;	// j가 9일때 뒤에올수있는수는 8밖에없다. (더하기 해주면 두자리수가 됨)
				} else {
					canTakeNumber[i][j] = ((canTakeNumber[i-1][j-1] % MOD) + (canTakeNumber[i-1][j+1] % MOD)) % MOD;
				}
			}
		}

		int stairCnt = 0;
		for(int i = 0; i < 10; i++) {
			stairCnt = (stairCnt % MOD) + (canTakeNumber[N][i] % MOD);	// N일때 가질수있는 전체 계단수를 구한다.
		}

		br.close();
		bw.write(String.valueOf(stairCnt % MOD));
		bw.flush();
		bw.close();
	}
}