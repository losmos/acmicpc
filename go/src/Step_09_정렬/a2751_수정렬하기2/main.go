/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/2751
문제번호 : 2751
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
func devide(_inputNumbers []int, _tempArr []int, _start int, _end int) []int {
	if _start < _end {
		var mid int = (_start + _end) / 2

		devide(_inputNumbers, _tempArr, _start, mid)
		devide(_inputNumbers, _tempArr, mid+1, _end)

		_inputNumbers = merge(_inputNumbers, _tempArr, _start, _end)
	}

	return _inputNumbers
}

func merge(_inputNumbers []int, _tempArr []int, _start int, _end int) []int {
	var mid int = (_start + _end) / 2 // 배열의 중간지점
	var leftPoint int = _start
	var rightPoint int = mid + 1
	var tempArrIndex = _start

	// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
	for leftPoint <= mid && rightPoint <= _end {
		if _inputNumbers[leftPoint] <= _inputNumbers[rightPoint] {
			_tempArr[tempArrIndex] = _inputNumbers[leftPoint]
			tempArrIndex++
			leftPoint++
		} else if _inputNumbers[leftPoint] > _inputNumbers[rightPoint] {
			_tempArr[tempArrIndex] = _inputNumbers[rightPoint]
			tempArrIndex++
			rightPoint++
		}
	}

	if leftPoint > mid { // 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
		for i := rightPoint; i <= _end; i++ {
			_tempArr[tempArrIndex] = _inputNumbers[i]
			tempArrIndex++
		}
	} else { // 오른쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 왼쪽 배열을 갖다붙임
		for i := leftPoint; i <= mid; i++ {
			_tempArr[tempArrIndex] = _inputNumbers[i]
			tempArrIndex++
		}
	}

	// 임시 배열에 정렬해놓은 값을 _inputNumbers 배열에 다시 할당
	for i := _start; i <= _end; i++ {
		_inputNumbers[i] = _tempArr[i]
	}

	return _inputNumbers // 정렬된 배열 return
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
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())
	inputNumbers := make([]int, N)
	tempArr := make([]int, N) // 임시배열. _start 부터 _end 범위까지의 배열요소를 정리하여 가지고 있음.

	// slice에 input값 차례대로 할당
	for i := 0; i < N; i++ {
		scanner.Scan()
		v, _ := strconv.Atoi(scanner.Text())
		inputNumbers[i] = v
	}

	inputNumbers = devide(inputNumbers, tempArr, 0, N-1) // 병합정렬 call

	for _, v := range inputNumbers {
		writer.WriteString(strconv.Itoa(v) + "\n")
	}

	writer.Flush()
}
