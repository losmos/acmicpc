/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2741
	문제번호 : 2741
	알고리즘 : 구현
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	var reader = bufio.NewReader(os.Stdin)
	var writer = bufio.NewWriter(os.Stdout)

	line, _ := reader.ReadString('\n')
	line = strings.TrimSuffix(line, "\n")
	line = strings.TrimSuffix(line, "\r")

	n, _ := strconv.Atoi(line)

	for i := 1; i <= n; i++ {
		writer.WriteString(strconv.Itoa(i))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
