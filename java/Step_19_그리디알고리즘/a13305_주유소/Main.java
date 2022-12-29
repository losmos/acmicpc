/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/13305
문제번호 : 13305
알고리즘 : 그리디 알고리즘
*/

package Step_19_그리디알고리즘.a13305_주유소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 현재 주유소의 가격이 다음주유소의 가격보다 낮다면, 현재 주유소가격으로 계속 간다.
 * (현재 주유소에서 N번째 주유까지 얼마만큼 더 갈지 미리계산하고, 그 거리에맞게 주유를 미리 할필요없이, 주유소에 도착할때마다 현재의 nowPrice가격을 조건에따라 바꿔주며 계산해주면 된다.)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N-1];
		long[] price = new long[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {	// 거리정보 입력
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		long bestPrice = 1000000000;	// 가장 값싼 주유소의 1L당 가격
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {	// 주유소 리터당 가격정보 입력, N-1까지만 루프돌리는건 맨마지막가격이 bestPrice여도 종착지라서 의미가없기때문
			price[i] = Long.parseLong(st.nextToken());
			if(price[i] < bestPrice) {
				bestPrice = price[i];
			}
		}
		price[N-1] = 1000000000;	// 종착지 주유소 가격은 제일 비싼걸 취급한다. (아래 로직탈때 현재주유소가격과 다음주유소가격을 비교하는 부분이있는데 거기서 혼선을 주지않기위해)

		long nowPrice = price[0];
		long totalPrice = 0;
		boolean isBestPrice = false;

		for(int i = 0; i < N-1; i++) {
			if(!isBestPrice && price[i] == bestPrice) {	// 현재 주유소의 가격이 베스트 가격이라면
				isBestPrice = true;
			}

			if(isBestPrice) {	// 베스트 가격으로 끝까지 간다.
				totalPrice += bestPrice * distance[i];
			} else {
				if(price[i] < nowPrice) {	// 현재 주유소가격이 전 주유소가격보다 더 낮다면
					nowPrice = price[i];	// nowPrice 갱신
				}

				if(price[i] < price[i+1] && price[i] <= nowPrice) {	// 현재 주유소의 가격이 다음주유소보다 싸고, 여지껏 거친주유소의 가격중에서 제일 값싼가격이라면 
					nowPrice = price[i];	// 현재 1L당 가격정보 갱신
					totalPrice += nowPrice * distance[i];	// 딱 다음주유소까지 갈만큼만 주유한다.
				} else {	// 현재 주유소 가격이 다음주유소보다 싸다면
					totalPrice += nowPrice * distance[i];
				}
			}
		}

		br.close();
		bw.write(totalPrice + "");
		bw.flush();
		bw.close();
	}
}