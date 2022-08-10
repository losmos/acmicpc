/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11022
	문제번호 : 11022
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
	T, _ := strconv.Atoi(line)

	var a, b int
	for i := 1; i <= T; i++ {
		strLine, _, _ := reader.ReadLine()

		strArr := strings.Split(string(strLine), " ")
		a, _ = strconv.Atoi(strArr[0])
		b, _ = strconv.Atoi(strArr[1])

		writer.WriteString("Case #" + strconv.Itoa(i) + ": " + strconv.Itoa(a) + " + " + strconv.Itoa(b) + " = " + strconv.Itoa(a+b))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
