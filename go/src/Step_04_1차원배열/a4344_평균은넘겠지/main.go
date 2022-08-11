/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4344
	문제번호 : 4344
	알고리즘 : 수학, 사칙연산
*/
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	C, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < C; i++ {
		scanner.Scan()
		line := scanner.Text()

		var sum int
		var avg float64
		scoreInfo := strings.Split(line, " ")

		for _, v := range scoreInfo {
			score, _ := strconv.Atoi(v)
			sum += score
		}
		size := func() int {
			size, _ := strconv.Atoi(scoreInfo[0])
			return size
		}()

		avg = float64(sum) / float64(size)

		var overAvgCount int
		for i, v := range scoreInfo {

			if i == 0 {
				continue
			}

			score, _ := strconv.ParseFloat(v, 64)
			if score > avg {
				overAvgCount++
			}
		}

		result := float64(overAvgCount) / float64(size) * 100

		fmt.Printf("%.2f", result)
	}
}
