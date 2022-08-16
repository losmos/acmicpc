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

func getHansuCnt(_N int) int {
	if _N < 100 {
		return _N
	} else {
		var hansuCnt int
		for i := 100; i <= _N; i++ {
			var remain, shiftNum, gap int // 나머지, input숫자를 >> 쉬프트한 수, 자리수의 차이
			shiftNum = i

			for j := 0; ; j++ { // 숫자의 각 자리수를 모두 검사할때까지 무한루프
				remain = shiftNum % 10                     // 1의자리 수 추출
				shiftNum = shiftNum / 10                   // > 쉬프트
				if j != 0 && remain-(shiftNum%10) != gap { // 각자리수 차이가 같지 않다면 한수가 아니므로 break. 다음수 진행
					break
				}
				gap = remain - (shiftNum % 10) // gap =  각자리수 차이

				if shiftNum <= 9 { // 종료조건 : 자리수 끝까지 왔다면 더이상 쉬프트할 수 없음. hansuCnt ++
					hansuCnt++
					break
				}
			}
		}

		return 99 + hansuCnt
	}
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()

	N, _ := strconv.Atoi(scanner.Text())
	writer.WriteString(strconv.Itoa(getHansuCnt(N)))
	writer.Flush()
}
