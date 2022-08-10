/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/25304
	문제번호 : 25304
	알고리즘 : 수학, 구현, 사칙연산
*/
package main

import (
	"bufio"
	"bytes"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	total, _ := strconv.Atoi(scanner.Text())
	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())

	var sum int = 0
	for i := 0; i < T; i++ {
		scanner.Scan()
		line := bytes.Fields(scanner.Bytes())
		price, _ := strconv.Atoi(string(line[0]))
		count, _ := strconv.Atoi(string(line[1]))

		sum = sum + (price * count)
	}

	if total == sum {
		writer.WriteString("Yes")
	} else {
		writer.WriteString("No")
	}

	writer.Flush()
}
