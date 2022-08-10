/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3003
	문제번호 : 3003
	알고리즘 : 수학, 구현, 사칙연산
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

	var kqbnp []int = []int{1, 1, 2, 2, 2, 8}
	var str []string = strings.Split(line, " ")

	for i, v := range str {
		item, _ := strconv.Atoi(v)
		writer.WriteString(strconv.Itoa(kqbnp[i]-item) + " ")
	}

	writer.WriteByte('\n')
	writer.Flush()
}
