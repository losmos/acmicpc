/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/25305
문제번호 : 25305
알고리즘 : 구현, 정렬
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
 * 입력값의 범위가 점수로써 매우 좁으므로(1~100) 카운팅정렬 사용하는게 적합할것같음.
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanWords)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text()) // 응시자수
	scanner.Scan()
	k, _ := strconv.Atoi(scanner.Text()) // 상을 받는 사람의 수

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

	writer.WriteString(strconv.Itoa(resultArr[N-k]))
	writer.WriteByte('\n')

	writer.Flush()
}
