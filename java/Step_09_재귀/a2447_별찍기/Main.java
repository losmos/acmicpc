/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2447
 	문제번호 : 2447
 	알고리즘 : 분할정복, 재귀
*/
package Step_09_재귀.a2447_별찍기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별모양 담을 class
class StarSquare {
	public String[][] starSquare;
	public int size;	// 행,렬이 될 size

	public StarSquare(String[][] starSquare, int size) {
		this.starSquare = starSquare;
		this.size = size;
	}
}
public class Main {

	// 최초 3*3 짜리 별모양 배열 만들어서 return
	public StarSquare getStarSquare() {
		String[][] starSquare = new String[3][3];

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				if( i==1 && j== 1) {
					starSquare[i][j] = " ";
				} else {
					starSquare[i][j] = "*";
				}
			}
		}
		return new StarSquare(starSquare, 3);
	}


	// 재귀함수
	public String[][] makeStarSquare(StarSquare _starSquare, int _N) {
		if(_N / 3 <= 1 ) {	// 재귀함수 return 조건. 3의거듭제곱인 _N을 계속 나누기3해주기때문에 결국은 1에 도달하고 이때 return 해주면 됨
			return _starSquare.starSquare;
		}

		int size = _starSquare.size*3;	// 배열의크기는 최초3으로시작해서 call 될때마다 *3 해주면서 늘어남
		String[][] newStarSquare = new String[size][size];	// 몸집이 불어난 별Square를 담을 배열 새롭게 초기화

		// 중첩for문으로 newStarSquare 배열값 할당
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if((i == size/3 && j == size/3) || (i%3 == 1 && j%3 == 1)) {
					newStarSquare[i][j] = " ";
				} else {
					newStarSquare[i][j] = _starSquare.starSquare[i/3][j/3];
				}
			}
		}
		return makeStarSquare(new StarSquare(newStarSquare, size), _N/3);	// call 재귀
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());	//N은 3의 거듭제곱

		Main main = new Main();
		StarSquare starSquare = main.getStarSquare();	// 최초 별모양 get
		String[][] result = main.makeStarSquare(starSquare, N);	// call 재귀

		// 결과 출력
		for(String[] item1 : result) {
			for(String item2 : item1) {
				bw.write(item2);
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}