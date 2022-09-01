/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1978
	문제번호 : 1978
	알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

/** 넘어온 _param이 소수인지 판별하는 함수. 소수일경우 true 리턴, 소수가 아닐경우 false 리턴함*/
func findPrimeNumber(_param int) bool {
	if _param < 2 { // 2보다 작으면 소수가 아님
		return false
	}

	if _param == 2 { // 2면 소수
		return true
	}

	for i := 2; i < _param; i++ { // 그외 숫자 소수인지 판별
		if _param%i == 0 {
			return false
		}
	}
	return true
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	// N, _ := strconv.Atoi(scanner.Text())		// N 사용안함
	scanner.Text()

	scanner.Scan()
	line := scanner.Text()
	numerArr := strings.Split(line, " ") // 입력받은 수 공백구분으로 잘라서 배열에 넣음

	var result int // 최종 결과인, 소수의 총 개수를 담을 변수
	for _, v := range numerArr {
		param, _ := strconv.Atoi(v)
		if findPrimeNumber(param) { // 소수라면
			result++ // 카운팅 + 1
		}
	}

	writer.WriteString(strconv.Itoa(result))
	writer.WriteByte('\n')
	writer.Flush()
}
