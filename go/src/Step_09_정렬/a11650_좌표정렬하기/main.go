/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/11650
문제번호 : 11650
알고리즘 : 정렬
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/**
 * @param _inputNumbers	: 정렬해야될 input값 배열(함수가 호출될수록 점차적으로 정렬됨)
 * @param _start		: 정렬해야할 배열의 시작 주소값
 * @param _end			: 정렬해야할 배열의 마지막 주소값
 * @return				: _inputNumbers
 */
func devide(_inputNumbers [][2]int, _tempArr [][2]int, _start int, _end int) [][2]int {
	if _start < _end {
		var mid int = (_start + _end) / 2

		devide(_inputNumbers, _tempArr, _start, mid)
		devide(_inputNumbers, _tempArr, mid+1, _end)

		_inputNumbers = merge(_inputNumbers, _tempArr, _start, _end)
	}

	return _inputNumbers
}

func merge(_inputNumbers [][2]int, _tempArr [][2]int, _start int, _end int) [][2]int {
	var mid int = (_start + _end) / 2 // 배열의 중간지점
	var leftPoint int = _start
	var rightPoint int = mid + 1
	var tempArrIndex = _start

	// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
	for leftPoint <= mid && rightPoint <= _end {
		if _inputNumbers[leftPoint][0] < _inputNumbers[rightPoint][0] {
			_tempArr[tempArrIndex][0] = _inputNumbers[leftPoint][0]
			_tempArr[tempArrIndex][1] = _inputNumbers[leftPoint][1]
			tempArrIndex++
			leftPoint++
		} else if _inputNumbers[leftPoint][0] > _inputNumbers[rightPoint][0] {
			_tempArr[tempArrIndex][0] = _inputNumbers[rightPoint][0]
			_tempArr[tempArrIndex][1] = _inputNumbers[rightPoint][1]
			tempArrIndex++
			rightPoint++
		} else { // 두 수가 같을경우
			if _inputNumbers[leftPoint][1] < _inputNumbers[rightPoint][1] {
				_tempArr[tempArrIndex][0] = _inputNumbers[leftPoint][0]
				_tempArr[tempArrIndex][1] = _inputNumbers[leftPoint][1]
				tempArrIndex++
				leftPoint++
			} else if _inputNumbers[leftPoint][1] > _inputNumbers[rightPoint][1] {
				_tempArr[tempArrIndex][0] = _inputNumbers[rightPoint][0]
				_tempArr[tempArrIndex][1] = _inputNumbers[rightPoint][1]
				tempArrIndex++
				rightPoint++
			}
		}
	}

	if leftPoint > mid { // 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
		for i := rightPoint; i <= _end; i++ {
			_tempArr[tempArrIndex][0] = _inputNumbers[i][0]
			_tempArr[tempArrIndex][1] = _inputNumbers[i][1]
			tempArrIndex++
		}
	} else { // 오른쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 왼쪽 배열을 갖다붙임
		for i := leftPoint; i <= mid; i++ {
			_tempArr[tempArrIndex][0] = _inputNumbers[i][0]
			_tempArr[tempArrIndex][1] = _inputNumbers[i][1]
			tempArrIndex++
		}
	}

	// 임시 배열에 정렬해놓은 값을 _inputNumbers 배열에 다시 할당
	for i := _start; i <= _end; i++ {
		_inputNumbers[i][0] = _tempArr[i][0]
		_inputNumbers[i][1] = _tempArr[i][1]
	}

	return _inputNumbers // 정렬된 배열 return
}

/*
 * 병합정렬 쓸거임
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanWords)
	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())
	inputNumbers := make([][2]int, T)
	tempArr := make([][2]int, T) // 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음.

	// slice에 input값 차례대로 할당
	for i := 0; i < T; i++ {
		scanner.Scan()
		v1, _ := strconv.Atoi(scanner.Text())
		scanner.Scan()
		v2, _ := strconv.Atoi(scanner.Text())
		inputNumbers[i][0] = v1
		inputNumbers[i][1] = v2
	}

	inputNumbers = devide(inputNumbers, tempArr, 0, T-1) // 병합정렬 call

	for i := 0; i < len(inputNumbers); i++ {
		writer.WriteString(strconv.Itoa(inputNumbers[i][0]) + " ")
		writer.WriteString(strconv.Itoa(inputNumbers[i][1]) + "\n")
	}

	writer.Flush()
}
