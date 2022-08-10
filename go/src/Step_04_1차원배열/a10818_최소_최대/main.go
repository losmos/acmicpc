/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10818
	문제번호 : 10818
	알고리즘 : 수학, 구현
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

	line, _ := reader.ReadString('\n') // 첫번째 line 받긴하지만 안쓸거기 때문에
	line, _ = reader.ReadString('\n')  // 두번째 line 받아서 바로 덮어씀
	line = strings.TrimSuffix(line, "\n")
	line = strings.TrimSuffix(line, "\r")

	strArr := strings.Split(line, " ")

	min, _ := strconv.Atoi(strArr[0])
	max, _ := strconv.Atoi(strArr[0])

	for i := 1; i < len(strArr); i++ {
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
