/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2869
 	문제번호 : 2869
 	알고리즘 : 수학
*/
package Step_07_기본수학1.a2869_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_시간초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());	// 낮에 올라갈수있는 거리 A
		int B = Integer.parseInt(st.nextToken());	// 밤되면 미끄러지는 거리 B
		int V = Integer.parseInt(st.nextToken());	// 올라가고자하는 목표 정상거리 C
		
		int distance = 0;
		int day = 0;
		while(true)
		{
			day ++;				// 하루가 지남
			distance += A;		// 올라감
			
			if(distance >= V)	// 정상에 도달했다면 break
			{
				break;
			}
			
			distance -= B;		// 미끄러짐
		}
		
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();
	}
}
