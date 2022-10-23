/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1769
 	문제번호 : 1769
 	알고리즘 : 구현, 문자열, 재귀
*/
package Step_11_재귀.a1769_3의배수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * [문제풀이 컨셉]
 * 재귀로 풀거임.(dfs 쓸필요없음)
 * 01. 숫자가 입력되면 각자리수를 1의자리수로 취급하여 다 더해준다.
 * 더한값이 10 보다 크다면 01번 항목을 반복한다. (반복횟수 저장함)
 * 
 * 10보다 작아질경우, 01.번 항목을 몇번반복했는지랑(Y로의 변환횟수), 3의배수인지 여부를 출력한다.
 */
class XInfo {
	String X;
	int cnt = 0;	// Y 변환횟수
	int Y = 0;

	XInfo(String X) {
		this.X = X;
	}
}

public class Main {
		public XInfo recursive(XInfo xInfo) {
			char[] xArr = xInfo.X.toCharArray();	// char[] 배열로 변환하여 값 하나씩 넣어줌
			
			if(xInfo.cnt == 0 && xArr.length == 1) {	// 최초입력이 1자리수면 바로 return 해줌
				xInfo.Y = Integer.parseInt(xInfo.X);
				return xInfo;
			}

			xInfo.cnt++;	// 변환 횟수 +1
			for(int i = 0, length = xArr.length; i < length; i++) {
				xInfo.Y += xArr[i] - '0';	// Y에다가 ascii -> int형으로 변환한 숫자를 더해준다.
			}

			if(xInfo.Y >= 10) {	// Y가 10보다 클경우 다시 재귀 call
				xInfo.X = String.valueOf(xInfo.Y);
				xInfo.Y = 0;
				recursive(xInfo);
			}

			return xInfo;
		}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		XInfo xInfo = new XInfo(br.readLine());
		main.recursive(xInfo);

		bw.write(xInfo.cnt + "\n");
		if(xInfo.Y % 3 == 0) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}