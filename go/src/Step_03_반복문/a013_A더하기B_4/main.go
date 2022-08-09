/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10951
	문제번호 : 10951
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

	var A, B int

	defer func() {
		if c := recover(); c != nil {
			writer.Flush()
		}
	}()

	for {
		line, _ := reader.ReadString('\n')
		line = strings.TrimSuffix(line, "\n")
		line = strings.TrimSuffix(line, "\r")
		var strArr = strings.Split(line, " ")

		A, _ = strconv.Atoi(strArr[0])
		B, _ = strconv.Atoi(strArr[1])

		writer.WriteString(strconv.Itoa(A + B))
		writer.WriteByte('\n')
	}
}
