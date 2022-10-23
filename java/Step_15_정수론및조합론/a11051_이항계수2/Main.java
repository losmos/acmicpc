/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11051
 	문제번호 : 11051
 	알고리즘 : 수학, 다이나믹 프로그래밍, 조합론
*/
package Step_15_정수론및조합론.a11051_이항계수2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	/**
	 * 파스칼의 삼각형 성질을 활용하는데, 파스칼의 삼각형을 잘보면
	 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j]의 성질을 갖는다. (파스칼의 삼각형 그림 보면 바로 이해될것임)
	 * 
	 * 
	 * 참고사이트 : https://m.blog.naver.com/at3650/220041816572 (경우의 수(5) - 순열.조합 기호에 관련한 성질 소개)
	 * 참고사이트 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=freewheel3&logNo=220763729760 (경우의 수(6) - 여러가지 상황 고려하여 문제 해결하기)
	 * 참고사이트 : https://m.blog.naver.com/freewheel3/220766202964
	 * 참고사이트(파스칼의 삼각형 이해하기 딱좋음) : https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-11051%EB%B2%88-%EC%9D%B4%ED%95%AD-%EA%B3%84%EC%88%98-2-Java-Python
	 * 참고사이트 : https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-11051%EB%B2%88-%EC%9D%B4%ED%95%AD-%EA%B3%84%EC%88%98-2-Java-Python
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][N+1];	// 동적계획법 사용할 배열. 파스칼의 삼각형 규칙을 활용해서 값을 할당할거임
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0) {	// 조합 nCn = 1 이고, nC0 또한 1이므로, 해당 케이스는 값을 1을 할당해준다.
					dp[i][j] = 1;
				} else {	// 그 외 는 파스칼의 삼각형 규칙에 따라서 아래와같은 공식 적용.
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;	//여기서 10007 mod연산 안해주고. 일단 값을 다 넣은다음에 출력할때 mod 10007해주려하면 이미 값을 담을때부터 int형이 담을수있는 숫자의 범위를 벗어나는 케이스가 생김(ex : 1000 409 입력하면 오버플로우되서 -값됨.)
				}
			}
		}

		bw.write(String.valueOf(dp[N][K]));
		br.close();
		bw.flush();
		bw.close();
	}
}