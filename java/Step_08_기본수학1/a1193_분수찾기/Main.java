/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1193
 	문제번호 : 1193
 	알고리즘 : 수학, 구현
*/
package Step_08_기본수학1.a1193_분수찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 ~   1		// 거리:1
		 2   3		// 거리:2		
		 4   6		// 거리:3
		 7   10		// 거리:4
		 11  15		// 거리:5
		 16  21		// ...
		 */
		
		// 전문제인 벌집문제 참고. 같은개념문제임.
		// 비트(거리)간의 거리는 1씩 증가하는 계차수열
		// 어떤수 N 이 입력됐을때 loop 돌면서 변수 coordinate에 계차수열만큼의 값을 계속 누적해서 더해주다가  이 coordinate값이 N값에 도달하는 index값을 구하면 거리값을 알 수있음.
		// 거리값을 구했다면 해당거리에서 
		
		int N = Integer.parseInt(br.readLine());
		
		int coordinate = 0;
		int index = 0;
		while(true)
		{
			
			coordinate += index;		// 계차수열
			if(coordinate >= N)
			{
				break;
			}
			index++;
			
		}
		int numerator = coordinate - N + 1;			// 분모값
		int denominator = N - (coordinate-index);	// 분자값, 계차수열을 초과할때 break되므로 입력값N에서, 초과하는 그 전 계차수열값을 빼야 해당 distance에서 나머지를 구할수있고
													// 이 나머지값을 index번째 계차에서 몇칸더 나아갔는지를 계산해 낼 수 있다.
		
		// 숫자가 지그재그로 진행했네...
		if(index % 2 == 1)
		{
			bw.write(String.valueOf(numerator)+"/"+String.valueOf(denominator));
		}
		else
		{
			bw.write(String.valueOf(denominator)+"/"+String.valueOf(numerator));
		}
		bw.flush();
		bw.close();
		
	}
}
