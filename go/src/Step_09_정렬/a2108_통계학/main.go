/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/2108
문제번호 : 2108
알고리즘 : 수학, 구현, 정렬
*/
package main

import (
	"bufio"
	"math"
	"os"
	"strconv"
)

/**
 * @param _inputNumbers	: 정렬해야될 input 배열
 * @param _max			: input값중 max값. countingArr 초기화할때 쓰임.
 * @return				: 정렬된배열, 최빈값
 */
func countingSort(_inputNumbers []int, _max int) ([]int, int) {
	countingArr := make([]int, _max+1)           //값과 주소값을 1:1매핑할거기때문에. +1해줘야됨
	resultArr := make([]int, len(_inputNumbers)) // 최종적으로 sorting된 결과를 담을 배열

	// Step03에해당 하는 로직 수행
	for i := 0; i < len(_inputNumbers); i++ {
		countingArr[_inputNumbers[i]]++
	}

	mode, secondMode := 8001, 8001 // 최빈값, second 최빈값
	modeCnt, secondModeCnt := 0, 0 // 최빈값 출현횟수, second 최빈값 출현횟수
	// 최빈값 구하는 loop
	for i := 0; i < len(countingArr); i++ {
		if countingArr[i] != 0 && countingArr[i] >= modeCnt { // i의 counting값이 최빈값보다 많거나 같을 때
			if countingArr[i] == modeCnt { // 최빈값과 출현횟수가 같을때
				if countingArr[i] > secondModeCnt || i < secondMode { // 두번째최빈값보다 출현횟수가 더 많거나 || 기존 second최빈값보다는 값이 작은경우
					secondMode = i
					secondModeCnt = countingArr[i]
				}
			} else if countingArr[i] > modeCnt { // 최빈값 갱신조건
				mode = i                 // 최빈값 갱신
				modeCnt = countingArr[i] // 최빈값의 출현횟수 갱신
			}
		}
	}

	if modeCnt <= secondModeCnt {
		mode = secondMode
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

	return resultArr, mode
}

/*
 * 카운팅 정렬로 풀건데, 입력값중에 음수값이있으므로. 카운팅배열 선언할때 가장최소 음수값만큼 + 해줘서 index값을 보정해줄것임.
 * 예를들면 입력값중에 max가 1000일경우 카운팅정렬 length도 1000짜리를 만들어주지만, 음수값이 -100이 있을경우, +100만큼 보정해서 -100과 매핑되는 주소값이 0이될수 있도록 해줌
 * 그외는 특이사항 없음. 출력할 때 보정값 감안해서 원래대로 출력 해주면 됨.
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	inputNumbers := make([]int, N)

	var sum float64
	var max int             // 정렬하고자하는 값중 제일 큰값
	var min int             // 정렬하고자 하는 값중 제일 작은 값(음수값 넣을거임)
	var correctionValue int // 보정값
	var inputRange int

	// slice에 input값 차례대로 할당
	for i := 0; i < N; i++ {
		scanner.Scan()
		v, _ := strconv.Atoi(scanner.Text())
		inputNumbers[i] = v

		if v > max { // input 받는김에 for문돌면서 max값도 미리 구해둠
			max = v
		}

		if inputNumbers[i] < 0 && inputNumbers[i] < min { // input값이 음수이면서 제일 작은수라면
			min = inputNumbers[i]
		}

		sum += float64(inputNumbers[i])
	}

	if min < 0 { // 음수값이 있다면
		correctionValue = int(math.Abs(float64(min)))
		max = max + correctionValue
		for i := 0; i < len(inputNumbers); i++ { // 음수만큼 더하기해서 보정함. max값을 늘려줌.
			inputNumbers[i] += correctionValue // 모든 input값에 보정값을 더해줌
		}
	}

	resultArr, mode := countingSort(inputNumbers, max)

	if len(inputNumbers) == 1 {
		inputRange = 0
	} else {
		inputRange = resultArr[N-1] - resultArr[0]
	}

	writer.WriteString(strconv.Itoa(int(math.Round(sum / float64(N))))) // 산술평균 (반올림, round)
	writer.WriteByte('\n')
	writer.WriteString(strconv.Itoa(resultArr[N/2] - correctionValue)) // 중앙값
	writer.WriteByte('\n')
	writer.WriteString(strconv.Itoa(mode - correctionValue)) // 최빈값
	writer.WriteByte('\n')
	writer.WriteString(strconv.Itoa(inputRange)) // 범위
	writer.WriteByte('\n')

	writer.Flush()
}
