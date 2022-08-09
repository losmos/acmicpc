/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10871
	문제번호 : 10871
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
	var strArr = strings.Split(line, " ")

	// N, _ := strconv.Atoi(strArr[0])
	X, _ := strconv.Atoi(strArr[1])

	line, _ = reader.ReadString('\n')
	line = strings.TrimSuffix(line, "\n")
	line = strings.TrimSuffix(line, "\r")

	var A = strings.Split(line, " ")

	for _, v := range A {
		value, _ := strconv.Atoi(v)
		if value < X {
			writer.WriteString(strconv.Itoa(value) + " ")
		}
	}
	writer.WriteByte('\n')
	writer.Flush()
}
