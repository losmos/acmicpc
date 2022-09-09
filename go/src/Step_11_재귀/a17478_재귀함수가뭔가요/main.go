/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/17478
	문제번호 : 17478
	알고리즘 : 구현, 재귀
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

/* 시간복잡도 계산(틀릴수도 있음) : O(2^n)
** N번째 피보나치의 수를 구하는 함수
 */
func whatIsRecursive(N int) func(N int) {
	var test func
	index := 0
	return func test(N int) {
		var sb strings.Builder
		var sbSuffix strings.Builder
		writer := bufio.NewWriter(os.Stdout)

		if N == 0 {
			return
		}

		for i := 0; i < index; i++ {
			sbSuffix.WriteString("____")
		}

		sb.WriteString(sbSuffix.String() + "\"재귀함수가 뭔가요?\"" + "\n")
		sb.WriteString(sbSuffix.String() + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어." + "\n")
		sb.WriteString(sbSuffix.String() + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." + "\n")
		sb.WriteString(sbSuffix.String() + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" + "\n")
		sb.WriteString(sbSuffix.String() + "\"재귀함수는 자기 자신을 호출하는 함수라네\"" + "\n")
		sb.WriteString(sbSuffix.String() + "라고 답변하였지." + "\n")

		writer.WriteString(sb.String())
		writer.Flush()

		test(N - 1)
	}

}

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())
	whatIsRecursive(N)
}
