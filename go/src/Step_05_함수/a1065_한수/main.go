/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1065
	문제번호 : 1065
	알고리즘 : 브루트포스 알고리즘
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
	N, _ := strconv.Atoi(scanner.Text())

	for i := 1; i < N; i++ {

		var result bool

		if i <= 99 { // 수가 세자리 수 미만일 경우 무조건 등차수열 조건에 부합
			result = true
			break
		}
	}
}
