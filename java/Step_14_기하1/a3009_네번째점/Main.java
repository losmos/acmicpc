/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3009
 	문제번호 : 3009
 	알고리즘 : 구현, 기하학
*/
package Step_13_기하1.a3009_네번째점;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 좌표가 3번입력되는데 예를들어
 * 5 5
 * 5 7
 * 7 5
 * 위와같이 입력된다. 앞쪽숫자는 x좌표, 뒤에오는 숫자는 y축숫자로
 * x축좌표와 y축좌표는 같은숫자가 2번씩 와야함.
 * 누락된 좌표값을 찾아서 출력하면됨.
 * 
 * 컨셉 : 총 3번입력받는데, x좌표값을 예를들었을 때, if x값이 연속해서 같은숫자가온다면 세번째오는숫자가 네번째에도 와야하므로 세번째오는 숫자 출력.
 * else if x값이 연속해서 오지 않았다면. 두값을 더해주고. 세번째들어오는값을 빼주면. 도출해야할 x좌표값이됨(ex 30,10,10 순서대로 입력됐다면 30+10 해주고. 세번째오는숫자(10)를 빼주면 됨)
 */
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		int x = 0, y = 0;
		int tempX = 0, tempY = 0;

		// 첫번째 좌표 값 입력
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		// 두번째 좌표 값 입력
		st = new StringTokenizer(br.readLine(), " ");
		tempX = Integer.parseInt(st.nextToken());
		tempY = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		if(x == tempX) {	// x좌표가 연속으로 입력됐다면
			bw.write(st.nextToken() + " ");	// 세번째 오는숫자 그대로 출력
		} else {			// x좌표가 서로다른숫자가 입력됐다면
			bw.write((x + tempX - Integer.parseInt(st.nextToken())) + " ");	// x + tempX 해주고 세번째오는 x값 빼주면 얻어야될 x좌표값 알 수 있음
		}

		// 이하동문
		if(y == tempY) {			
			bw.write(st.nextToken() + " ");
		} else {
			bw.write((y + tempY - Integer.parseInt(st.nextToken())) + " ");	// x + tempX 해주고 세번째오는 x값 빼주면 얻어야될 x좌표값 알 수 있음
		}

		br.close();
		bw.flush();
		bw.close();
	}
}