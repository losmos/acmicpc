/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2439
	문제번호 : 2439
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
		for j := 0; j < T; j++ {
			if j >= T-i-1 {
				writer.WriteString("*")
			} else {
				writer.WriteString((" "))
			}
		}
		writer.WriteByte('\n')
	}
	writer.Flush()
}
