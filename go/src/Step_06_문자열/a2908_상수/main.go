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
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()

	inputArr := bytes.Fields(scanner.Bytes())

	var a, b string
	for _, v := range inputArr {
		for i := len(v) - 1; i >= 0; i-- {
			writer.WriteByte(v[i])
			writer.WriteByte('\n')
		}
	}

	/*
		for i := 0; i < len(inputArr); i++ {
			writer.Write(inputArr[i])
			writer.WriteByte('\n')
		}
	*/

	writer.Flush()
}
