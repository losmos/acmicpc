/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10872
	문제번호 : 10872
	알고리즘 : 수학, 구현, 조합론
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/* 시간복잡도 계산(틀릴수도 있음) : O(n)
** _N 팩토리얼 값 구하는 함수
 */
func runFactorial(N int) int {
	if N == 1 || N == 0 { // _N - 1하면서 재귀호출하다가 _N 이 1이되면 return 1, 0 입력일경우 0! 도 = 1
		return 1
	}

	return N * runFactorial(N-1)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	writer.WriteString(strconv.Itoa(runFactorial(N)))
	writer.Flush()
}
