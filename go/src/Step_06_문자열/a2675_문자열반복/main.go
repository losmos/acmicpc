/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2675
	문제번호 : 2675
	알고리즘 : 구현, 문자열
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

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < T; i++ {
		scanner.Scan()
		line := bytes.Fields(scanner.Bytes()) // byte[][]로 받음

		R, _ := strconv.Atoi(string(line[0])) // line[0]은 문자가 반복될 횟수

		for _, v := range line[1] { // line[1][]은 반복할 문자자열의 각 byte값
			for j := 0; j < R; j++ {
				// writer.WriteString(string(v)) // byte -> string 변환 출력
				writer.WriteByte(v)
			}
		}
		writer.WriteByte('\n')
	}
	writer.Flush()
}
