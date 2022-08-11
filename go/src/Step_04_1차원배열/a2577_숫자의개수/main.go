/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2577
	문제번호 : 2577
	알고리즘 : 수학, 구현, 사칙연산
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

	countArr := make([]int, 10)
	scanner.Split(bufio.ScanLines)

	var a, b, c int
	scanner.Scan()
	a, _ = strconv.Atoi(scanner.Text())
	scanner.Scan()
	b, _ = strconv.Atoi(scanner.Text())
	scanner.Scan()
	c, _ = strconv.Atoi(scanner.Text())

	result := a * b * c

	for {
		if result == 0 {
			break
		}
		countArr[result%10]++
		result /= 10
	}

	for _, v := range countArr {
		writer.WriteString(strconv.Itoa(v))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
