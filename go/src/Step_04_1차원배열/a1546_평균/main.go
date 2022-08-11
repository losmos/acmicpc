/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1546
	문제번호 : 1546
	알고리즘 : 수학, 사칙연산
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	scanner.Text() // 테스트케이스 의미하는 input값이지만, 사용하지않기때문에 변수에 할당하지 않고 넘어감

	scanner.Scan()
	score := strings.Split(scanner.Text(), " ") // score 공백으로 구분해서 score 배열에 넣음

	var scoreSum, max int // scoreSum : score의 총합, max : score중 가장 큰 값
	for _, v := range score {
		score, _ := strconv.Atoi(v)
		scoreSum += score

		if score > max {
			max = score
		}
	}

	// 보통 시험점수는 100점만점중 몇점을 받게되는데.
	// 문제요건대로 100점만점이아니라 max를 만점으로 기준으로두고 계산해야한다.
	// 따라서 score 총합을. 과목수대로 나누되 max를 만점으로하는 기준으로 나눠주면 된다.
	// 예를들어 50,60,70 점을맞았다면 평균은 (50/70 * 100) + (60/70 * 100) + (70/70 * 100)이 된다.
	var avg float64 = float64(scoreSum) / float64((max * len(score))) * 100

	var result string = strconv.FormatFloat(avg, 'f', -1, 64) // float을 string으로 변환
	writer.WriteString(result)                                // 출력
	writer.WriteByte('\n')
	writer.Flush()
}
