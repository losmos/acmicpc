/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11651
 	문제번호 : 11651
 	알고리즘 : 정렬
*/
package Step_11_정렬.a11651_좌표정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

	/**
	 * @param _inputNumbers	: 정렬해야될 input값 배열(함수가 호출될수록 점차적으로 정렬됨)
	 * @param _start		: 정렬해야할 배열의 시작 주소값
	 * @param _end			: 정렬해야할 배열의 마지막 주소값
	 * @return				: _inputNumbers
	 */
	public int[][] devide(int[][] _inputNumbers, int[][] _tempArr, int _start, int _end) {
		if(_start < _end) {
			int mid = (_start + _end) / 2;	// 배열의 중간지점
	
			devide(_inputNumbers, _tempArr, _start, mid);
			devide(_inputNumbers, _tempArr, mid+1, _end);
	
			_inputNumbers = merge(_inputNumbers, _tempArr, _start, _end);
		}

		return _inputNumbers;
	}


	public int[][] merge(int[][] _inputNumbers, int[][] _tempArr, int _start, int _end) {
		int mid = (_start + _end) / 2;	// 배열의 중간지점
		int leftPoint = _start;
		int rightPoint = mid + 1;
		int tempArrIndex = _start;

		// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
		while(leftPoint <= mid && rightPoint <= _end) {		// 왼쪽요소가 먼저 정렬이 끝나거나, 오른쪽요소가 정렬이 먼저 끝났을경우 종료하고
			if(_inputNumbers[leftPoint][1] < _inputNumbers[rightPoint][1]) {
				_tempArr[tempArrIndex][0] = _inputNumbers[leftPoint][0];
				_tempArr[tempArrIndex][1] = _inputNumbers[leftPoint][1];
				leftPoint++;
				tempArrIndex++;
			} else if(_inputNumbers[leftPoint][1] > _inputNumbers[rightPoint][1]) { 
				_tempArr[tempArrIndex][0] = _inputNumbers[rightPoint][0];
				_tempArr[tempArrIndex][1] = _inputNumbers[rightPoint][1];
				rightPoint++;
				tempArrIndex++;
			} else {	// 두 수가 같을경우
				if(_inputNumbers[leftPoint][0] <= _inputNumbers[rightPoint][0]) {
					_tempArr[tempArrIndex][0] = _inputNumbers[leftPoint][0];
					_tempArr[tempArrIndex][1] = _inputNumbers[leftPoint][1];
					leftPoint++;
					tempArrIndex++;
				} else if(_inputNumbers[leftPoint][0] > _inputNumbers[rightPoint][0]) { 
					_tempArr[tempArrIndex][0] = _inputNumbers[rightPoint][0];
					_tempArr[tempArrIndex][1] = _inputNumbers[rightPoint][1];
					rightPoint++;
					tempArrIndex++;
				}
			}
		}

		if(leftPoint > mid) {	// 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
			for(int i = rightPoint; i <= _end; i ++) {
				_tempArr[tempArrIndex][0] = _inputNumbers[i][0];
				_tempArr[tempArrIndex][1] = _inputNumbers[i][1];

				tempArrIndex++;
			}
		} else if (rightPoint > _end) {	// 이하동문
			for(int i = leftPoint; i <= mid; i ++) {
				_tempArr[tempArrIndex][0] = _inputNumbers[i][0];
				_tempArr[tempArrIndex][1] = _inputNumbers[i][1];

				tempArrIndex++;
			}
		}

		// 임시 배열에 정렬해놓은 값을 _inputNumbers 배열에 다시 할당
		for(int i = _start; i <= _end; i++) {
			_inputNumbers[i][0] = _tempArr[i][0];
			_inputNumbers[i][1] = _tempArr[i][1];
		}

		return _inputNumbers;	// 정렬된 배열 return
	}

	/*
	 * 좌표 정렬하기2문제는 좌표정렬하기문제랑 거의 똑같고, y축을 우선으로 정렬하도록 바꿔주기만 하면 됨
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] inputNumbers = new int[N][2];
		int[][] tempArr = new int[N][2];	// 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음

		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			inputNumbers[i][0] = Integer.parseInt(st.nextToken());
			inputNumbers[i][1] = Integer.parseInt(st.nextToken());
		}

		inputNumbers = main.devide(inputNumbers, tempArr, 0, N-1);

		for(int i = 0; i < inputNumbers.length; i++) {
			bw.write(String.valueOf(inputNumbers[i][0]) + " ");
			bw.write(String.valueOf(inputNumbers[i][1]) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}