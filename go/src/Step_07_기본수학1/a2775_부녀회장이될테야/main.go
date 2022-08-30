/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2775
	문제번호 : 2775
	알고리즘 : 수학, 구현
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
	scanner.Text()
	T, _ := strconv.Atoi(scanner.Text()) // 테스트케이스 T

	for k := 0; k < T; k++ {
		scanner.Scan()
		k, _ := strconv.Atoi(scanner.Text()) // 층
		scanner.Scan()
		n, _ := strconv.Atoi(scanner.Text()) // 호

		knArray := make([][]int, k+1) // 2차원 슬라이스, 층수만큼의 행이 필요하고 문제의 k층은 0층부터시작하므로. 배열 row 개수는 +1 해줘야함

		// 2차원 슬라이스 초기화
		for index, _ := range knArray { //
			knArray[index] = make([]int, n)
		}

		for i := 0; i < len(knArray); i++ {
			var upFloorCalc int = 0

			for j := 0; j < n; j++ {
				if i == 0 {
					knArray[i][j] = j + 1 // 바닥층 초기화
					upFloorCalc += j + 1  // 윗층 계산해서 넣어줌

					if k > 0 {
						knArray[i+1][j] = upFloorCalc // 윗층 계산해서 넣어줌
					}
				} else { // 바닥층이 아니라면
					if i != len(knArray)-1 { // 위에 층이 존재한다면
						upFloorCalc += knArray[i][j]  // 윗층계산
						knArray[i+1][j] = upFloorCalc // 윗층에 값 넣어줌
					}
				}

			}
		}

		writer.WriteString(strconv.Itoa(knArray[k][n-1]))
		writer.WriteByte('\n')
	}

	writer.Flush()
}
