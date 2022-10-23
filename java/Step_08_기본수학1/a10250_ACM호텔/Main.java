/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10250
 	문제번호 : 10250
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_07_기본수학1.a10250_ACM호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 T
		
		for(int i=0; i<T; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());	// 호텔 높이
			int W = Integer.parseInt(st.nextToken());	// 호텔 너비
			int N = Integer.parseInt(st.nextToken());	// 호텔에 입장하는 N번째손님
			
			int column = (int)(N / H);		// 열(방번호), 시작인덱스가 0열 부터시작
			
			if( N % H == 0)
			{
				column = column -1;			// N / H 값이 딱 떨어지면 해당 열까지 사람이 꽉차있다고 판단하게되는데, 사실은 그 전 컬럼(열) 까지만 꽉차있기때문에 if처리
			}
			
			if(N <= H)	// N번째손님이 H 한층을 다 못채우는 숫자라면
			{
				column = 0;
			}
			
			int row = 0;					// 행(호텔층)
			if(column == 0)	// 한 column도 꽉차있지않기때문에. (column) * H) 계산으로 이미 들어차있는 손님수를 계산하지 않음.
			{
				row = N;
			}
			else
			{
				row = (N - ((column) * H));	// 손님은 column * H 수만큼 방에 들어가있음
			}
			
			System.out.printf(row +""+ "%02d\n", column+1);
		}
		
	}
}