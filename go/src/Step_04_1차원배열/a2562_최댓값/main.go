/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2562
	문제번호 : 2562
	알고리즘 : 구현
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

	var max, maxIndex int
	for i := 0; i < 9; i++ {
		scanner.Scan()
		input, _ := strconv.Atoi(scanner.Text())
		if input > max {
			max = input
			maxIndex = i + 1
		}
	}

	writer.WriteString(strconv.Itoa(max))
	writer.WriteByte('\n')
	writer.WriteString(strconv.Itoa(maxIndex))
	writer.WriteByte('\n')
	writer.Flush()
}
