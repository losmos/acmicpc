/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1193
	문제번호 : 1193
	알고리즘 : 수학, 구현
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	X, _ := strconv.Atoi(scanner.Text())

	var coordinate, index int = 0, 0

	for {
		coordinate += index
		if coordinate >= X {
			break
		}

		index++
	}

	var numerator int = coordinate - X + 1         // 분모값
	var denominator int = X - (coordinate - index) // 분자값

	if index%2 == 1 {
		writer.WriteString(strconv.Itoa(numerator) + "/" + strconv.Itoa(denominator))
	} else {
		writer.WriteString(strconv.Itoa(denominator) + "/" + strconv.Itoa(numerator))
	}

	writer.Flush()
}
