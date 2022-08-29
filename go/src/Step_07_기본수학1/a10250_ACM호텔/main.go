/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10250
	문제번호 : 10250
	알고리즘 : 수학, 구현, 사칙연산
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
	T, _ := strconv.Atoi(scanner.Text()) // 테스트케이스 T

	for i := 0; i < T; i++ {
		scanner.Scan()
		line := scanner.Text()
		inputArr := strings.Split(line, " ")
		H, _ := strconv.Atoi(inputArr[0]) // 호텔 높이
		// W, _ := strconv.Atoi(inputArr[1]) // 호텔 너비
		N, _ := strconv.Atoi(inputArr[2]) // 호텔에 입장하는 N번째손님

		column := N / H // 열(방번호), 시작인덱스가 0열 부터시작

		if N%H == 0 {
			column = column - 1 // N / H 값이 딱 떨어지면 해당 열까지 사람이 꽉차있다고 판단하게되는데, 사실은 그 전 컬럼(열) 까지만 꽉차있기때문에 if처리
		}

		if N <= H { // N번째손님이 H 한층을 다 못채우는 숫자라면
			column = 0
		}

		var row int = 0  // 행(호텔층)
		if column == 0 { // 한 column도 꽉차있지않기때문에. (column) * H) 계산으로 이미 들어차있는 손님수를 계산하지 않음.
			row = N
		} else {
			row = (N - ((column) * H)) // 손님은 column * H 수만큼 방에 들어가있음
		}

		fmt.Printf(strconv.Itoa(row)+""+"%02d\n", column+1)
	}
}
