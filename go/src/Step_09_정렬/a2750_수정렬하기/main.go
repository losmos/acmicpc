/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/2750
문제번호 : 2750
알고리즘 : 구현, 정렬
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
	inputArr := make([]int, N)

	for i := 0; i < N; i++ {
		scanner.Scan()
		v, _ := strconv.Atoi(scanner.Text())
		inputArr[i] = v
	}

	// 버블정렬
	for i := 0; i < N-1; i++ {
		for j := i + 1; j < N; j++ {
			if inputArr[i] > inputArr[j] {
				// writer.WriteString("====checkpoint")
				inputArr[j], inputArr[i] = inputArr[i], inputArr[j] // temp 변수없이도 swap이 된다.
				// writer.WriteString("====checkpoint")

				/*
					어떤식으로 swap이 되는지 assembly코드 보고싶다면,
					위에 checkpoint 주석 풀고 아래 컴파일 명령어 수행한 다음에,
					컴파일된 어셈블리코드에서 checkpoint 구간 찾아서 볼것.

					어셈블리코드 컴파일 : go tool compile -S main.go > main.s
				*/
			}
		}
		writer.WriteString(strconv.Itoa(inputArr[i]))
		writer.WriteByte('\n')
	}
	writer.WriteString(strconv.Itoa(inputArr[N-1]))
	writer.Flush()
}
