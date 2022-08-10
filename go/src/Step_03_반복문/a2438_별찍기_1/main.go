/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2438
	문제번호 : 2438
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

	T, _ := strconv.Atoi(line)

	for i := 0; i < T; i++ {
		for j := 0; j <= i; j++ {
			writer.WriteString("*")
		}
		writer.WriteByte('\n')
	}
	writer.Flush()
}
