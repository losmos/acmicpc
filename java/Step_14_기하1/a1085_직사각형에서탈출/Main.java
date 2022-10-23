/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1085
 	문제번호 : 1085
 	알고리즘 : 수학, 기하학
*/
package Step_14_기하1.a1085_직사각형에서탈출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * x,y 좌표에서 경계선까지 얼마나 가는지를 구하면 되는데
 * w, h 오른쪽위 꼭지점값을 입력받고나면, 직사각형을 이루는 네개의 꼭지점 값이 있다는것을 인지해야함.
 * 꼭지점 (x,y) = (0,0), (0,h), (w,h), (w,0) 네개가 있고
 * 처음에 입력받은 x, y값으로부터 각 네개의 꼭지점까지의 거리중에 제일 작은값을 출력한다.
 * 
 * (추가+) 문제조건에서 x위치는 w보다 작거나같고, y값은 h보다 작거나같기때문에 x,y값은 항상 직사각형 안쪽에있음, 따라서 절대값 Math.abs 안써도됨. 문제잘읽자.
 */
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int min = 1000;
		if(x - 0 < min ) {	// 현재위치에서 x좌표 0 까지의 거리
			min = x;
		}
		if(w - x < min) {	// 현재위치에서 직사각형의 x좌표 w 까지의 거리
			min = w - x;
		}
		if(y - 0 < min ) {	// 현재위치에서 y좌표 0 까지의 거리
			min = y;
		}
		if(h - y < min) {	// 현재위치에서 직사각형의 y좌표 h 까지의 거리
			min = h - y;
		}
		
		bw.write(String.valueOf(min));
		br.close();
		bw.flush();
		bw.close();
	}
}