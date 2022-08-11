/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/8958
	문제번호 : 8958
	알고리즘 : 구현, 문자열
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

	T, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < T; i++ { // TestCase만큼 loop
		scanner.Scan()
		line := scanner.Text()
		oxArr := strings.Split(line, "") // split한값 배열로 초기화

		var sum int          // 최중 출력할 sum값
		var nowScore int = 1 // 더해줄 점수
		for _, v := range oxArr {
			if v == "O" {
				sum += nowScore
				nowScore++
			}

			if v == "X" {
				nowScore = 1 // "O" 콤보 끊김. 점수 1로 초기화
			}
		}

		writer.WriteString(strconv.Itoa(sum))
		writer.WriteByte('\n')
	}
	writer.Flush()
}
