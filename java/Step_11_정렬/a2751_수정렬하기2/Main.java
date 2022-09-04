/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2751
 	문제번호 : 2751
 	알고리즘 : 정렬
*/
package Step_11_정렬.a2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {

	/**
	 * 
	 * @param _inputNumbers	: 정렬해야될 input값 배열(함수가 호출될수록 점차적으로 정렬됨)
	 * @param _start		: 정렬해야할 배열의 시작 주소값
	 * @param _end			: 정렬해야할 배열의 마지막 주소값
	 * @return				: _inputNumbers
	 */
	public int[] devide(int[] _inputNumbers, int[] _tempArr, int _start, int _end) {
		if(_start < _end) {
			int mid = (_start + _end) / 2;	// 배열의 중간지점
	
			devide(_inputNumbers, _tempArr, _start, mid);
			devide(_inputNumbers, _tempArr, mid+1, _end);
	
			_inputNumbers = merge(_inputNumbers, _tempArr, _start, _end);
		}

		return _inputNumbers;
	}


	public int[] merge(int[] _inputNumbers, int[] _tempArr, int _start, int _end) {
		// int[] tempArr = new int[_inputNumbers.length];	// 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음. 이놈때문에 시간초과뜨나? Main클래스에서 만들고 파라미터로 던지게 바꿔봄
		int mid = (_start + _end) / 2;	// 배열의 중간지점
		int leftPoint = _start;
		int rightPoint = mid + 1;
		int tempArrIndex = _start;

		// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
		while(leftPoint <= mid && rightPoint <= _end) {		// 왼쪽요소가 먼저 정렬이 끝나거나, 오른쪽요소가 정렬이 먼저 끝났을경우 종료하고
			if(_inputNumbers[leftPoint] <= _inputNumbers[rightPoint]) {
				_tempArr[tempArrIndex++] = _inputNumbers[leftPoint++];
			} else if(_inputNumbers[leftPoint] > _inputNumbers[rightPoint]) { 
				_tempArr[tempArrIndex++] = _inputNumbers[rightPoint++];
			}
		}

		if(leftPoint > mid) {	// 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
			for(int i = rightPoint; i <= _end; i ++) {
				_tempArr[tempArrIndex++] = _inputNumbers[i];
			}
		} else if (rightPoint > _end) {	// 이하동문
			for(int i = leftPoint; i <= mid; i ++) {
				_tempArr[tempArrIndex++] = _inputNumbers[i];
			}
		}

		// 임시 배열에 정렬해놓은 값을 _inputNumbers 배열에 다시 할당
		for(int i = _start; i <= _end; i++) {
			_inputNumbers[i] = _tempArr[i];
		}

		return _inputNumbers;	// 정렬된 배열 return
	}

	/*
	 * 병합정렬 컨셉
	 * Step01. 입력값이 들어있는 배열을 계속 절반씩 정렬없이 쪼갠다.(재귀 call)
	 * Step02. 더이상 쪼갤 수 없을때까지 최종단까지 쪼갠다음부터는. 합치는데 (merge)
	 * Step03. 파라미터로 넘어온 두개의 배열(배열1과 배열2)의 각각 0번지부터 비교하여 더 작은값을 new 배열에 할당하고.
	 * 		   값이 있던 원래배열은 index++하여 다음주소값 요소를 검사할 준비한다.
	 * 		   이런식으로 배열1과 배열2의 모든요소값을 전체탐색하면서 완성한 new배열을 return
	 * Step04. Step03반복.
	 * 시간복잡도 : O(nlogn)
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] inputNumbers = new int[N];
		int[] tempArr = new int[inputNumbers.length];	// 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음

		for(int i = 0; i < N; i ++) {
			inputNumbers[i] = Integer.parseInt(br.readLine());
		}

		inputNumbers = main.devide(inputNumbers, tempArr, 0, N-1);

		for(int item : inputNumbers) {
			bw.write(String.valueOf(item) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}