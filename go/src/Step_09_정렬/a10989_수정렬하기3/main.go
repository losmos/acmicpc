/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/10989
문제번호 : 10989
알고리즘 : 정렬
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/**
 * @param _inputNumbers	: 정렬해야될 input 배열
 * @param _max			: input값중 max값. countingArr 초기화할때 쓰임.
 * @return
 */
func countingSort(_inputNumbers []int, _max int) []int {
	countingArr := make([]int, _max+1)           //값과 주소값을 1:1매핑할거기때문에. +1해줘야됨
	resultArr := make([]int, len(_inputNumbers)) // 최종적으로 sorting된 결과를 담을 배열

	// Step03에해당 하는 로직 수행
	for i := 0; i < len(_inputNumbers); i++ {
		countingArr[_inputNumbers[i]]++
	}

	// Step04에 해당하는 로직 수행
	for i := 0; i < len(countingArr)-1; i++ {
		countingArr[i+1] = countingArr[i] + countingArr[i+1]
	}

	// Step05에해당 하는 로직 수행
	for i := 0; i < len(_inputNumbers); i++ {
		resultArr[countingArr[_inputNumbers[i]]-1] = _inputNumbers[i]
		countingArr[_inputNumbers[i]]--
	}

	return resultArr
}

/*
 * 카운팅정렬 컨셉
 * Step01. 입력된 배열값(value)을 주소 번지로하는 배열을 하나더 만든다. 새로운배열 이름을 편의상 카운팅배열이라 칭하겠음.
 * Step02. 예를들어 1,2,2,100000 이 입력됐다면. 4개의값을 비교하기위해 max값인 100000 길이를갖는 카운팅배열을 만들어야함.
 * Step03. 입력된 배열을 순회하며 카운팅배열의 값을 +1 해줌. 완성이됐다면 입력배열 값(value)의 개수가 몇개인지 카운팅배열에 들어가있을것임.
 * Step04. 카운팅배열을 순회하며 카운팅 누적값으로 바꿔줌. 예를들어 배열에 [0,1,2,.....,1] 이 들어가있다면 [0,1,3,.....,4] 로 누적값을 넣어줌
 * Step05. 완성된 카운팅배열이 의미하는것은, 배열주소값은 최초 정렬하고자했던 숫자이고, 그 값(value)은 시작 번지수(-1을 해주면됨)를 가리킴.
 * 시간복잡도 : O(n)
 *
 * 정렬하고자하는 수자체의 값이 클 경우 공간복잡도가 비효율적으로 커질 수 있음을 감안하는 정렬방법. but, 수의 범위가 적다면 매우 빠르게 정렬 가능
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())
	inputNumbers := make([]int, N)

	var max int = 0 // 정렬하고자하는 값중 제일 큰값

	// slice에 input값 차례대로 할당
	for i := 0; i < N; i++ {
		scanner.Scan()
		v, _ := strconv.Atoi(scanner.Text())
		inputNumbers[i] = v

		if v > max { // input 받는김에 for문돌면서 max값도 미리 구해둠
			max = v
		}
	}

	resultArr := countingSort(inputNumbers, max)

	for _, v := range resultArr {
		writer.WriteString(strconv.Itoa(v))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
