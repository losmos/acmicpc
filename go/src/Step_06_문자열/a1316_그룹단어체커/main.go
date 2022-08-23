/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1316
	문제번호 : 1316
	알고리즘 : 구현, 문자열
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
	var result int // 최종 출력할 그룹단어 개수

	for i := 0; i < N; i++ { // 테스트케이스 N 만큼 반복
		var alphabetBool ['z' - 'a' + 1]bool // 문자열 각 알파벳값이 한번이라도 출연했다면 배열에 매핑되는 해당값을 false에서 true로 바꿈
		var prev byte                        // 직전에 나왔던 알파벳
		scanner.Scan()
		line := scanner.Bytes()

		isGroupWord := func() bool { // 그룹단어인지 판별하는 익명함수
			for _, v := range line { // 입력문자열 length만큼 반복

				if !alphabetBool[v-'a'] { // 문자 기존에 출현한 적없음. 첫 출현
					alphabetBool[v-'a'] = true
					prev = v
				} else if alphabetBool[v-'a'] && prev == v { // 기존에 출현한 적 있고 && 직전 알파벳이 현재 알파벳이랑 같을경우
					continue
				} else { // alphabetBool[v-'a'] == true && prev != v 조건으로. 그룹단어가 아닌조건에 만족되는 경우
					return false
				}
			}
			return true // for문을 무사히 끝냈다면 이 함수는 그룹단어임
		}()

		if isGroupWord { // 그룹단어임
			result++
		}

	}
	writer.WriteString(strconv.Itoa(result))
	writer.WriteByte('\n')
	writer.Flush()
}
