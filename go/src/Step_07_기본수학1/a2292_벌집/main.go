/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2292
	문제번호 : 2292
	알고리즘 : 수학
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
	N, _ := strconv.Atoi(scanner.Text())

	var result, cnt int = 1, 1

	for result < N {
		result += cnt * 6
		cnt++
	}

	writer.WriteString(strconv.Itoa(cnt))
	writer.WriteByte('\n')
	writer.Flush()
}
