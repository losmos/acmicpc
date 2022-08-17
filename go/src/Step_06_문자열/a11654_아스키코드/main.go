/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11654
	문제번호 : 11654
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

	scanner.Split(bufio.ScanBytes) // byte 단위로 split
	scanner.Scan()                 // scan

	writer.WriteString(strconv.Itoa(int(scanner.Bytes()[0]))) // split된 byte를 scanner.Bytes()로 읽어들임.(return type이 byte[]지만 크기는1이라 byte[0]밖에 없음)
	writer.Flush()
}
