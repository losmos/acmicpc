/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/11653
문제번호 : 11653
알고리즘 : 수학, 정수론, 소수 판정
*/
package main

import (
	"bufio"
	"math"
	"os"
	"strconv"
	"strings"
)

/** 소인수분해 함수 */
func getFactorizationInfo(_N int) string {
	var sb strings.Builder

	numSqrt := math.Sqrt(float64(_N))
	for i := 2; i <= int(numSqrt); /*i++*/ {
		if _N%i == 0 { // 나누어 떨어진다면
			_N = _N / i                     // _N을 i로 나누고
			sb.WriteString(strconv.Itoa(i)) // i를 stringBuilder에 append 해주고
			sb.WriteByte('\n')

			if _N == 1 { // 끝까지 다 나누었다면 더이상 loop를 돌지 않고 바로 return
				return sb.String()
			}
		} else { // 나누어 떨어지지 않을때만 i를 ++ 해준다.
			i++ // 이미 지나간 i값으로는 어차피 나누어 떨어지지 않는 특성을 이용해 for문을 처음부터 다시 돌릴 필요가 없음을 활용
		}
	}

	if _N != 1 {
		sb.WriteString(strconv.Itoa(_N))
		sb.WriteByte('\n')
	}
	return sb.String()
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	writer.WriteString(getFactorizationInfo(N))
	writer.Flush()
}
