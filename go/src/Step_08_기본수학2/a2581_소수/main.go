/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2581
	문제번호 : 2581
	알고리즘 : 수학, 정수론, 소수 판정
*/
package main

import (
	"bufio"
	"math"
	"os"
	"strconv"
)

/** M이상 N이하 범위의 숫자를 검사하여 소수를 모두 더한값과, 그 소수 중 가장 작은 값을 return하는 함수*/
func getPrimeNumInfo(rangeStart int, rangeEnd int) (int, int) {

	var minPrimeNumber, sumPrimeNums int = 0, 0
outer:
	for i := rangeStart; i <= rangeEnd; i++ {
		if i < 2 { // 숫자 1은 소수가 아님
			continue
		}

		numSqrt := math.Sqrt(float64(i))
		for j := 2; j <= int(numSqrt); j++ { // 소수인지 검사
			if i%j == 0 { // 소수가 아니라면
				continue outer // outer로 continue
			}
		}

		if minPrimeNumber == 0 { // 여기까지 왔다면 바로 중첩for검사에서 살아남았다는 의미고, 소수라는 뜻
			minPrimeNumber = i // 소수 최소값 할당
		}

		sumPrimeNums += i // 소수 sum
	}

	return sumPrimeNums, minPrimeNumber
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	M, _ := strconv.Atoi(scanner.Text())
	scanner.Scan()
	N, _ := strconv.Atoi(scanner.Text())

	sum, minPrimeNum := getPrimeNumInfo(M, N)

	if sum == 0 && minPrimeNum == 0 { // M ~ N 숫자범위에 소수가 하나도없다면
		writer.WriteString("-1") // return -1
	} else {
		writer.WriteString(strconv.Itoa(sum))
		writer.WriteByte('\n')
		writer.WriteString(strconv.Itoa(minPrimeNum))
		writer.WriteByte('\n')
	}
	writer.Flush()
}
