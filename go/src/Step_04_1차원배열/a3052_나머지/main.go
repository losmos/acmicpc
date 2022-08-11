/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3052
	문제번호 : 3052
	알고리즘 : 수학, 사칙연산
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	var distinctMap map[int]int = make(map[int]int)

	scanner.Split(bufio.ScanLines)

	for i := 0; i < 10; i++ {
		scanner.Scan()
		value, _ := strconv.Atoi(scanner.Text())
		distinctMap[value%42] = i
	}

	writer.WriteString(strconv.Itoa(len(distinctMap)))
	writer.WriteByte('\n')
	writer.Flush()
}
