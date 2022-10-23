/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1181
 	문제번호 : 1181
 	알고리즘 : 문자열, 정렬
*/
package Step_09_정렬.a1181_단어정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {

	public char[][] devide(char[][] _inputArr, char[][] _tempArr, int _start, int _end) {
		if(_start < _end) {
			
			int mid = (_start + _end) / 2;	// 배열의 중간지점
			devide(_inputArr, _tempArr, _start, mid);
			devide(_inputArr, _tempArr, mid+1, _end);
	
			_inputArr = merge(_inputArr, _tempArr, _start, _end);
		}

		return _inputArr;
	}


	public char[][] merge(char[][] _inputArr, char[][] _tempArr, int _start, int _end) {

		int mid = (_start + _end) / 2;	// 배열의 중간지점
		int leftPoint = _start;
		int rightPoint = mid + 1;
		int tempArrIndex = _start;

		// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
		while(leftPoint <= mid && rightPoint <= _end) {		// 왼쪽요소가 먼저 정렬이 끝나거나, 오른쪽요소가 정렬이 먼저 끝났을경우 종료하고

			for(int i = 0; i < _inputArr[leftPoint].length; i++) {
				int leftLength = _inputArr[leftPoint].length;
				int rightLength = _inputArr[rightPoint].length;

				if(leftLength < rightLength) {
					_tempArr[tempArrIndex++] = _inputArr[leftPoint++];
					break;
				} else if(leftLength > rightLength) { 
					_tempArr[tempArrIndex++] = _inputArr[rightPoint++];
					break;
				} else {	// 두 단어의 길이가 같을 때
					if(_inputArr[leftPoint][i] < _inputArr[rightPoint][i]) {
						_tempArr[tempArrIndex++] = _inputArr[leftPoint++];
						break;
					} else if(_inputArr[leftPoint][i] > _inputArr[rightPoint][i]) { 
						_tempArr[tempArrIndex++] = _inputArr[rightPoint++];
						break;
					}
				}

				if( i == _inputArr[leftPoint].length - 1) {	// 두 단어가 같은 단어 일 때
					_tempArr[tempArrIndex++] = _inputArr[leftPoint++];
					break;
				}
			}
		}

		if(leftPoint > mid) {	// 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
			for(int i = rightPoint; i <= _end; i ++) {
				_tempArr[tempArrIndex++] = _inputArr[i];
			}
		} else if (rightPoint > _end) {	// 이하동문
			for(int i = leftPoint; i <= mid; i ++) {
				_tempArr[tempArrIndex++] = _inputArr[i];
			}
		}

		// 임시 배열에 정렬해놓은 값을 _inputNumbers 배열에 다시 할당
		for(int i = _start; i <= _end; i++) {
			_inputArr[i] = _tempArr[i];
		}

		return _inputArr;	// 정렬된 배열 return
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		char[][] inputArr = new char[N][50];
		char[][] tempArr = new char[N][50];

		for(int i = 0; i < N; i ++) {
			inputArr[i] = br.readLine().toCharArray();
		}

		inputArr = main.devide(inputArr, tempArr, 0, N-1);

		String prevStr = "";
		for(int i = 0; i < inputArr.length; i++) {
			for(int j = 0; j < inputArr[i].length; j++) {
				sb.append(inputArr[i][j]);
			}

			if(prevStr.equals(sb.toString())) {
				sb.delete(0, sb.length());
				continue;
			}
			prevStr = sb.toString();
			bw.write(sb.toString() + "\n");
			sb.delete(0, sb.length());
		}

		br.close();
		bw.flush();
		bw.close();
	}
}