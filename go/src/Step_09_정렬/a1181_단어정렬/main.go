/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/1181
문제번호 : 1181
알고리즘 : 문자열, 정렬
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

/**
 * @param _inputArr	: 정렬해야될 input값 배열(함수가 호출될수록 점차적으로 정렬됨)
 * @param _start		: 정렬해야할 배열의 시작 주소값
 * @param _end			: 정렬해야할 배열의 마지막 주소값
 * @return				: _inputArr
 */
func devide(_inputArr [][]int, _tempArr [][]int, _start int, _end int) [][]int {
	if _start < _end {
		var mid int = (_start + _end) / 2

		devide(_inputArr, _tempArr, _start, mid)
		devide(_inputArr, _tempArr, mid+1, _end)

		_inputArr = merge(_inputArr, _tempArr, _start, _end)
	}

	return _inputArr
}

func merge(_inputArr [][]int, _tempArr [][]int, _start int, _end int) [][]int {
	var mid int = (_start + _end) / 2 // 배열의 중간지점
	var leftPoint int = _start
	var rightPoint int = mid + 1
	var tempArrIndex = _start

	// 크기비교후 더 작은값을 tempArr에 차곡차곡 넣음
	for leftPoint <= mid && rightPoint <= _end {

		for i := 0; i < len(_inputArr[leftPoint]); i++ {
			leftLength := len(_inputArr[leftPoint])
			rightLength := len(_inputArr[rightPoint])

			if leftLength < rightLength {
				_tempArr[tempArrIndex] = _inputArr[leftPoint]
				tempArrIndex++
				leftPoint++
				break
			} else if leftLength > rightLength {
				_tempArr[tempArrIndex] = _inputArr[rightPoint]
				tempArrIndex++
				rightPoint++
				break
			} else { // 두 단어의 길이가 같을 때
				if _inputArr[leftPoint][i] < _inputArr[rightPoint][i] {
					_tempArr[tempArrIndex] = _inputArr[leftPoint]
					tempArrIndex++
					leftPoint++
					break
				} else if _inputArr[leftPoint][i] > _inputArr[rightPoint][i] {
					_tempArr[tempArrIndex] = _inputArr[rightPoint]
					tempArrIndex++
					rightPoint++
					break
				}
			}

			if i == len(_inputArr[leftPoint])-1 {
				_tempArr[tempArrIndex] = _inputArr[leftPoint]
				tempArrIndex++
				leftPoint++
				break
			}
		}
	}

	if leftPoint > mid { // 왼쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 오른쪽 배열을 갖다붙임
		for i := rightPoint; i <= _end; i++ {
			_tempArr[tempArrIndex] = _inputArr[i]
			tempArrIndex++
		}
	} else { // 오른쪽 배열 정렬이 전부 끝났다면, 이미 정렬되어있는 나머지 왼쪽 배열을 갖다붙임
		for i := leftPoint; i <= mid; i++ {
			_tempArr[tempArrIndex] = _inputArr[i]
			tempArrIndex++
		}
	}

	// 임시 배열에 정렬해놓은 값을 _inputArr 배열에 다시 할당
	for i := _start; i <= _end; i++ {
		_inputArr[i] = _tempArr[i]
	}
	return _inputArr // 정렬된 배열 return
}

/*
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	var sb strings.Builder
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	inputArr := make([][]int, N)
	tempArr := make([][]int, N)

	// slice에 input값 차례대로 할당
	for i := 0; i < N; i++ {
		inputArr[i] = make([]int, 50) // 2차원 슬라이스 초기화

		scanner.Scan()
		line := scanner.Text()
		for idx, v := range line { // line을 character형으로 하나하나씩 자른 v
			inputArr[i][idx] = int(v)
		}
	}

	inputArr = devide(inputArr, tempArr, 0, N-1) // 병합정렬 call

	prevStr := ""
	for i := 0; i < len(inputArr); i++ {
		for j := 0; j < len(inputArr[i]); j++ {
			if inputArr[i][j] == 0 {
				break
			}
			sb.WriteString(string(inputArr[i][j]))
		}

		if prevStr == sb.String() {
			sb.Reset()
			continue
		}

		prevStr = sb.String()
		writer.WriteString(sb.String() + "\n")
		sb.Reset()
	}

	writer.Flush()
}
