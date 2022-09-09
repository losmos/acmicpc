/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25501
 	문제번호 : 25501
 	알고리즘 : 구현, 문자열, 재귀
*/
package Step_09_재귀.a24060_알고리즘수업_병합정렬1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class ResultInfo {
	int[] inputNumbers = null;
	int[] tempArr = null;
	int K;	// merge 함수가 몇번째로 정렬을 수행하지 저장할 변수
	int resultNumber = 0;	// merge 함수가 K번째로 정렬을 수행하는 값을 저장
}
	

public class Main{

	 /**
	  * @param _ri		: 머지정렬에 필요한 변수, 최종 출력할 변수 등의 정보들을 가지고있는 Class
	  * @param _start	: 정렬해야할 배열의 시작 주소값
	  * @param _end		: 정렬해야할 배열의 마지막 주소값
	  * @return			: _ri
	  */
	public ResultInfo devide(ResultInfo _ri, int _start, int _end) {
		if(_start < _end) {
			int mid = (_start + _end) / 2;	// 배열의 중간지점
	
			devide(_ri, _start, mid);
			devide(_ri, mid+1, _end);
	
			if(_ri.K == 0) {	// K횟수만큼 정렬수행했다면 바로 return
				return _ri;
			} else {
				_ri = merge(_ri, _start, _end);
			}
		}

		return _ri;
	}

	public ResultInfo merge(ResultInfo _ri, int _start, int _end) {
		
		int mid = (_start + _end) / 2;	// 배열의 중간지점
		int leftPoint = _start;
		int rightPoint = mid + 1;
		int tempArrIndex = _start;

		// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
		while(leftPoint <= mid && rightPoint <= _end) {		// 왼쪽요소가 먼저 정렬이 끝나거나, 오른쪽요소가 정렬이 먼저 끝났을경우 종료하고
			if(_ri.inputNumbers[leftPoint] <= _ri.inputNumbers[rightPoint]) {
				_ri.tempArr[tempArrIndex] = _ri.inputNumbers[leftPoint++];
				if(isReturn(--_ri.K)) {	// return 조건
					_ri.resultNumber = _ri.tempArr[tempArrIndex];
					return _ri;
				}
				tempArrIndex++;
			} else if(_ri.inputNumbers[leftPoint] > _ri.inputNumbers[rightPoint]) { 
				_ri.tempArr[tempArrIndex] = _ri.inputNumbers[rightPoint++];
				if(isReturn(--_ri.K)) {	// return 조건
					_ri.resultNumber = _ri.tempArr[tempArrIndex];
					return _ri;
				}
				tempArrIndex++;
			}
		}

		if(leftPoint > mid) {	// 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
			for(int i = rightPoint; i <= _end; i ++) {
				_ri.tempArr[tempArrIndex] = _ri.inputNumbers[i];
				if(isReturn(--_ri.K)) {	// return 조건
					_ri.resultNumber = _ri.tempArr[tempArrIndex];
					return _ri;
				}
				tempArrIndex++;
			}
		} else if (rightPoint > _end) {	// 이하동문
			for(int i = leftPoint; i <= mid; i ++) {
				_ri.tempArr[tempArrIndex] = _ri.inputNumbers[i];
				if(isReturn(--_ri.K)) {	// return 조건
					_ri.resultNumber = _ri.tempArr[tempArrIndex];
					return _ri;
				}
				tempArrIndex++;
			}
		}

		// 임시 배열에 정렬해놓은 값을 inputNumbers 배열에 다시 할당
		for(int i = _start; i <= _end; i++) {
			_ri.inputNumbers[i] = _ri.tempArr[i];
		}

		return _ri;	// 정렬된 배열 return
	}

	public boolean isReturn(int _K) {
		if(_K == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		ResultInfo ri = new ResultInfo();
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		ri.K = Integer.parseInt(st.nextToken());

		ri.inputNumbers = new int[N];
		ri.tempArr = new int[ri.inputNumbers.length];	// 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i ++) {
			ri.inputNumbers[i] = Integer.parseInt(st.nextToken());
		}

		ri = main.devide(ri, 0, N-1);

		if(ri.K == 0) {	// 머지정렬이 K 횟수만큼 정령를 수행했다면 K번째 정렬 number를 출력
			bw.write(String.valueOf(ri.resultNumber));
		} else {	// K 횟수 다 채우기도전에 머지정렬이 끝났다면 "-1" 출력
			bw.write("-1");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}