/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1929
	문제번호 : 1929
	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

/* 시간복잡도 계산(틀릴수도 있음) : n + n^(1/2) + n = 2n + n^(1/2) = O(n)
** 에라토스테네스의 체 활용하여 _M이상 _N이하의 범위에안에 있는 소수 구하는 함수
 */
func useEratosthenes(rangeStart int, rangeEnd int) string {
	var sb strings.Builder

	// primeNumInfo의 값이 true면 소수, false면 소수가 아님을 의미
	primeNumInfo := make([]bool, rangeEnd+1)

	// 최초 전부 true로 초기화
	for i := 2; i < rangeEnd+1; i++ {
		primeNumInfo[i] = true
	}

	// i*i < rangeEnd + 1
	// i < math.Sqrt(rangeEnd+1)"
	// 위의 두개는 의미가 같음. 굳이 math함수 쓰지않으려고 첫번째 i*i < rangeEnd + 1 차용함
	for i := 2; i*i < rangeEnd+1; i++ {

		if !primeNumInfo[i] { // 이미 에라토스테네스의 체에 걸러졌으면 continue
			continue
		}

		// j := i * 2 가 아니라 i * 2 인 이유를 살펴보면
		// 만일 i값이 현재 9라고 가정했을 때
		// j := i * 2로 하고 loop를 돌아도 답을 구하는데 문제는 없지만, 이미 i:=2일때 2의 배수로 (에라토스테네스의)체에 걸러졌으므로 중복 검사임
		// 마찬가지로 i*3, i*4(이것도 2의배수로 이미 걸러짐), i*5, i*6(이것도 이미 2의배수로 걸러짐), i*7.. 또한 이미 체에 이미 걸러졌으므로
		// 한번도 걸러지지 않은 j := 9 * 9 를 의미하는 i * i 부터 시작하는게 효율적임
		for j := i * i; j < rangeEnd+1; j += i { // j += i 는 j*2, j*3, j*4, j*5... 의 의미와 같음. j의배수를 검사하겠단 의미
			primeNumInfo[j] = false // j는 i로 나누어지기때문에 소수가 아니므로, 소수가 아님을 의미하는 false값 할당
		}
	}

	// 출력
	for i := rangeStart; i < rangeEnd+1; i++ {
		if primeNumInfo[i] {
			sb.WriteString(strconv.Itoa(i))
			sb.WriteByte('\n')
		}
	}

	return sb.String()
}

/* 시간복잡도 계산(틀릴수도 있음) : n * n^(1/2) = n^(3/2) = n^(1.5) = O(n^(1.5))
** 제곱근을 활용하여 _M이상 _N이하의 범위에안에 있는 소수 구하는 함수
 */
func useSquareRoot(rangeStart int, rangeEnd int) string {
	var sb strings.Builder

	if rangeStart == 1 { // 숫자 1은 소수가 아님 for문 돌때 i=2부터 시작
		rangeStart = 2
	}
outer:
	for i := rangeStart; i <= rangeEnd; i++ {

		// 소수인지 검사
		for j := 2; j*j <= i; j++ {
			if i%j == 0 { // 소수가 아니라면
				continue outer // outer로 continue
			}
		}

		// 여기까지 왔다면 바로 중첩for검사에서 살아남았다는 의미고, 소수라는 뜻
		sb.WriteString(strconv.Itoa(i))
		sb.WriteByte('\n')
	}

	return sb.String()
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	line := scanner.Text()

	inputArr := strings.Split(line, " ")
	M, _ := strconv.Atoi(inputArr[0])
	N, _ := strconv.Atoi(inputArr[1])

	// writer.WriteString(useSquareRoot(M, N))
	writer.WriteString(useEratosthenes(M, N))
	writer.Flush()
}
