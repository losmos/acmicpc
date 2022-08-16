/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2941
	문제번호 : 2941
	알고리즘 : 구현, 문자열
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()

	var croatia = [...]string{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="} // 크로아티아 알파벳
	input := scanner.Text()                                                    // input

	for _, v := range croatia {
		input = strings.ReplaceAll(input, v, "0") // input에서 크로아티아 문자를 찾아서 "0" 으로 replace 해줌
	}
	writer.WriteString(strconv.Itoa(len(input))) // length 출력
	writer.Flush()
}
