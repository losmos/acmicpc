/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5622
	문제번호 : 5622
	알고리즘 : 구현
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

	scanner.Split(bufio.ScanLines)
	scanner.Scan()

	inputArr := scanner.Bytes() // 입력받은 문자열을 byte[]형태로 초기화

	var time int = 0
	for _, v := range inputArr { //byte[]의 각 요소값을 아스키형태로 비교
		switch {
		case v <= 'C':
			time += 3
		case v <= 'F':
			time += 4
		case v <= 'I':
			time += 5
		case v <= 'L':
			time += 6
		case v <= 'O':
			time += 7
		case v <= 'S':
			time += 8
		case v <= 'V':
			time += 9
		case v <= 'Z':
			time += 10
		}
	}

	writer.WriteString(strconv.Itoa(time))
	writer.WriteByte('\n')
	writer.Flush()
}
