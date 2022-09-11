/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/2108
문제번호 : 2108
알고리즘 : 수학, 구현, 정렬
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
 * 카운팅 정렬로 풀건데, 입력값중에 음수값이있으므로. 카운팅배열 선언할때 가장최소 음수값만큼 + 해줘서 index값을 보정해줄것임.
 * 예를들면 입력값중에 max가 1000일경우 카운팅정렬 length도 1000짜리를 만들어주지만, 음수값이 -100이 있을경우, +100만큼 보정해서 -100과 매핑되는 주소값이 0이될수 있도록 해줌
 * 그외는 특이사항 없음. 출력할 때 보정값 감안해서 원래대로 출력 해주면 됨.
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
