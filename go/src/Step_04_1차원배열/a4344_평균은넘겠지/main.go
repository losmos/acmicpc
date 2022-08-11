/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4344
	문제번호 : 4344
	알고리즘 : 수학, 사칙연산
*/
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	C, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < C; i++ { // 테스트케이스 C 만큼 loop
		scanner.Scan()
		line := scanner.Text() // 한줄 읽어들여서

		var sum int                           // 모든점수 sum한 값 저장할 변수
		var avg float64                       // 평균 값 저장할 변수
		scoreInfo := strings.Split(line, " ") // 읽어들인 정보 " "공백구분으로 split

		for i, v := range scoreInfo { // sum 구함
			if i == 0 {
				continue
			}
			score, _ := strconv.Atoi(v)
			sum += score
		}
		size := func() int { // size 구하는 익명함수 ( var size int = stroconv.Atoi(scoreInfo[0]) 이렇게못씀. return이 두개라서 익명함수써봄)
			size, _ := strconv.Atoi(scoreInfo[0])
			return size
		}()

		avg = float64(sum) / float64(size) // 평균값

		var overAvgCount int // 평균을 넘는 사람 수 저장할 변수
		for i, v := range scoreInfo {

			if i == 0 {
				continue
			}

			score, _ := strconv.ParseFloat(v, 64) // string to float (타입 변환)
			if score > avg {
				overAvgCount++
			}
		}

		result := float64(overAvgCount) / float64(size) * 100

		fmt.Printf("%.3f%%\n", result)
	}
}
