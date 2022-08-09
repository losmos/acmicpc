/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2742
	문제번호 : 2742
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

	for i := n; i > 0; i-- {
		writer.WriteString(strconv.Itoa(i))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
