/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25305
 	문제번호 : 25305
 	알고리즘 : 구현, 정렬
*/
package Step_09_정렬.a25305_커트라인;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

	/**
	 * @param _inputNumbers	: 정렬해야될 input 배열
	 * @param _max			: input값중 max값. countingArr 초기화할때 쓰임.
	 * @return
	 */
	public int[] countingSort(int[] _inputNumbers, int _max) {
		int[] countingArr = new int[_max + 1];	//값과 주소값을 1:1매핑할거기때문에. +1해줘야됨
		int[] resultArr = new int[_inputNumbers.length];	// 최종적으로 sorting된 결과를 담을 배열

		// Step03에해당 하는 로직 수행
		for(int i = 0; i < _inputNumbers.length; i++)  {
			countingArr[_inputNumbers[i]]++;
		}

		// Step04에 해당하는 로직 수행
		for(int i = 0; i < countingArr.length - 1; i++) {
			countingArr[i+1] = countingArr[i] + countingArr[i+1];
		}

		// Step05에해당 하는 로직 수행
		for(int i = 0; i < _inputNumbers.length; i++)  {
			resultArr[countingArr[_inputNumbers[i]]-1] = _inputNumbers[i];
			countingArr[_inputNumbers[i]]--;
		}

		return resultArr;
	}

	/*
	 * 입력값의 범위가 점수로써 매우 좁으므로(1~100) 카운팅정렬 사용하는게 적합할것같음.
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());	// 응시자수
		int k = Integer.parseInt(st.nextToken());	// 상을 받는 사람의 수

		int[] inputNumbers = new int[N];

		int max = 0;	// 정렬하고자하는 값중 제일 큰값
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i ++) {
			inputNumbers[i] = Integer.parseInt(st.nextToken());
			if (inputNumbers[i] > max) {	// input 받는김에 for문돌면서 max값도 미리 구해둠
				max = inputNumbers[i];
			}
		}

		int[] resultArr = main.countingSort(inputNumbers, max);

		
		// 출력
		bw.write(String.valueOf(resultArr[N-k]) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}
}