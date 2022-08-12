/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4673
	문제번호 : 4673
	알고리즘 : 수학, 구현, 브루트포스 알고리즘
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	writer := bufio.NewWriter(os.Stdout)

	var selfNum [10000]bool // false 면 selfnum, true면 selfnum 아님

	for i := 1; i < 10000; i++ {

		notSelfNum := func(param int) int {
			var sum int = param
			for {
				var remain int = param % 10 // 1의자리수
				param = param / 10          // 숫자 > 방향으로 시프트
				sum = sum + remain

				if param == 0 { // 더이상 시프트 할게 없으면 break
					break
				}
			}
			return sum
		}(i)

		if notSelfNum <= 10000 {
			selfNum[notSelfNum-1] = true // 셀프넘버가 아닌 숫자에 true
		}
	}

	for i, v := range selfNum {
		if !v {
			writer.WriteString(strconv.Itoa(i + 1)) // index는 0부터시작하고 selfnum 검사는 1부터 시작해서 +1해줘야됨
			writer.WriteByte('\n')
		}
	}

	writer.Flush()
}
