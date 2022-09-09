/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/18870
 	문제번호 : 18870
 	알고리즘 : 정렬, 값 / 좌표 압축
*/
package Step_11_정렬.a18870_좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

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


	/* 이것도 input값과 입력된순서를 기억하고있다가, 출력을 입력순서대로 하면됨
	 * 단, 정렬된값을 그대로출력하지않고 숫자 0부터 오름차순으로 변환해줌.
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] inputArr = new int[N][2];
		int[][] tempArr = new int[N][2];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i ++) {
			inputArr[i][0] = Integer.parseInt(st.nextToken());
			inputArr[i][1] = i;
		}

		inputArr = main.devide(inputArr, tempArr, 0, N-1);	// 정렬 완료된 input값들

		int indexVal = 0;
		int prevVal = inputArr[0][0];
		inputArr[0][0] = 0;
		int[] resultArr = new int[N];

		for(int i = 1; i < inputArr.length; i++) {	// 숫자를 압축해줌
			if(prevVal == inputArr[i][0]) {
				prevVal = inputArr[i][0];
				inputArr[i][0] = indexVal;
			} else {
				prevVal = inputArr[i][0];
				inputArr[i][0] = ++indexVal;
			}
			resultArr[inputArr[i][1]] = inputArr[i][0];	// 입력순서대로 출력하기위해 입력순서번지수에 압축한숫자 할당
		}

		// 출력
		for(int item : resultArr) {
			bw.write(String.valueOf(item) + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}