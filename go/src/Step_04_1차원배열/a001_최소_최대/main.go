/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10818
	문제번호 : 10818
	알고리즘 : 수학, 구현
*/

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	var reader = bufio.NewReader(os.Stdin)
	var writer = bufio.NewWriter(os.Stdout)

	var N int
	fmt.Scanln(&N)

	line, _ := reader.ReadString('\n')
	line = strings.TrimSuffix(line, "\r\n")
	strArr := strings.Split(line, " ")

	var min int = 1000000
	var max int = -1000000

	for i := 0; i < N; i++ {
		value, _ := strconv.Atoi(strArr[i])

		if min > value {
			min = value
		}
		if max < value {
			max = value
		}
	}

	writer.WriteString(strconv.Itoa(min) + " " + strconv.Itoa(max))
	writer.WriteByte('\n')
	writer.Flush()
}
