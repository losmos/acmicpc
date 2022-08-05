/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2292
 	문제번호 : 2292
 	알고리즘 : 수학
*/
package Step_07_기본수학1.a002_벌집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 ~   1		// 거리:1
		 2   7		// 거리:2		
		 8   19		// 거리:3
		 20   37	// 거리:4
		 38   61	// 거리:5
		 62   ...	// ...
		 */
		
		// 중심을 둘러싸는 육각형벌집 한꺼풀 한꺼풀 이루고있는 이 개수는 6의 배수인 등비수열을 이룬다.
		// 마치 2진수를 계산할때 2^0, 2^1, 2^2... 2^n 제곱을하며 10진수로 변환하듯이
		// 한꺼풀에 들어갈수있는 양. 즉 벌집의 거리도 6진수단위로 볼 수 있다.
		// 즉 첫번째 꺼풀에는 6^0만큼, 두번째는 6^1만큼, 세번째는 6^2... n번째는 6^n 만큼의 숫자가 포함된다.
		// 만약에 61이라는 수가 입력됐다면 61-1 (-1해주는 이유는 시작 index가 1이므로 )인 60에서 6으로나눈값이 10이라는 숫자를 얻을 수 있고
		// 6^10 이 위치한 비트가 몇번째비트인지를 계산하면 벌집의 거리를 계산 할 수 있다.
		// 첫번째비트는 1, 두번째비트는 2, 세번째비트는 3, 네번째비트는 4만큼 들어가므로 10이라는 숫자는 4번비트에 속함을 알 수 있다(1+2+3+4 = 10)
		
		double N = Long.parseLong(br.readLine());
		long coordinate = (long)Math.ceil((N-1)/6);
		
		long index = 0;
		while(true)
		{
			coordinate = coordinate - index;
			
			if(coordinate <= 0)
			{
				break;
			}
			
			index++;
		}
		
		bw.write(String.valueOf(index+1));
		bw.flush();
		bw.close();
		
	}
}
