/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10870
	문제번호 : 10870
	알고리즘 : 수학, 구현
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/* 시간복잡도 계산(틀릴수도 있음) : O(2^n)
** N번째 피보나치의 수를 구하는 함수
 */
func runFibonacci(N int) int {
	if N <= 1 {
		return N
	}

	return runFibonacci(N-2) + runFibonacci(N-1)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	writer.WriteString(strconv.Itoa(runFibonacci(N)))
	writer.Flush()
}
