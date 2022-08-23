/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2908
	문제번호 : 2908
	알고리즘 : 수학, 구현
*/
package main

import (
	"bufio"
	"bytes"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines) // 한 라인을 읽어들여서
	scanner.Scan()

	inputArr := bytes.Fields(scanner.Bytes()) // whitespace를 구분자로하여 byte[][] return

	var a, b string
	for index, v := range inputArr {
		for i := len(v) - 1; i >= 0; i-- {
			if index == 0 {
				a = a + string(v[i]) // a 값 reverse
			} else {
				b = b + string(v[i]) // b 값 reverse
			}
			// writer.WriteByte(v[i])
			// writer.WriteByte('\n')
		}
	}

	numberA, _ := strconv.Atoi(a) // string -> int
	numberB, _ := strconv.Atoi(b) // string -> int
	if numberA > numberB {
		writer.WriteString(a)
	} else {
		writer.WriteString(b)
	}

	writer.WriteByte('\n')
	writer.Flush()
}
