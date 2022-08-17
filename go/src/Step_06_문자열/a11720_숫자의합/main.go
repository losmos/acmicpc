/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11720
	문제번호 : 11720
	알고리즘 : 수학, 구현, 문자열
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

	// 첫번쨰 입력값 N은 사용안함.
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	scanner.Text()

	// 두번째줄 입력값부터 사용
	// scanner.Split(bufio.ScanBytes)
	scanner.Scan()
	n := scanner.Bytes() // 입력값 byte[]로 받아서

	sum := func() int {
		var splitedNumber int
		for _, v := range n { // 각 byte값을 string으로 변환한뒤 다시 int형으로 변환 후 더해줌
			converted, _ := strconv.Atoi(string(v))
			splitedNumber += converted
		}
		return splitedNumber
	}()

	writer.WriteString(strconv.Itoa(sum))
	writer.Flush()
}
