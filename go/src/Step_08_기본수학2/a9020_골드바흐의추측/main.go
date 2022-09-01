/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9020
	문제번호 : 9020
	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/* 시간복잡도 계산(틀릴수도 있음) : n + n^(1/2) = n + n^(1/2) = O(n)
** 에라토스테네스의 체 활용하여 _M이상 _N이하의 범위에안에 있는 소수 구하는 함수
 */
func conjectureGoldBach(rangeStart int, rangeEnd int) []bool {

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

	return primeNumInfo
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())
	primeNumInfo := conjectureGoldBach(2, 10000) // 먼저 2보다크고 10000이하의 범위의 모든 숫자를 소수인지판별해 놓은 슬라이스를 만듦

	for i := 0; i < T; i++ {
		scanner.Scan()
		N, _ := strconv.Atoi(scanner.Text())

		var a = N / 2 // 입력값을 2로 나눈값
		var b = N - a // 입력값을 2로 나눈값 인데 나누기보다 - 연산이 좀더 빨라서 빼기로 구해줌

		for a >= 0 {
			if primeNumInfo[a] && primeNumInfo[b] { // a + b = N을만족하는 a,b가 있다면
				writer.WriteString(strconv.Itoa(a) + " ")
				writer.WriteString(strconv.Itoa(b))
				writer.WriteByte('\n')
				break
			}

			a--
			b++
		}
	}
	writer.Flush()
}
