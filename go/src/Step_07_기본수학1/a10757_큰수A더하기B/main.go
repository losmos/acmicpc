/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10757
	문제번호 : 10757
	알고리즘 : 수학, 구현, 사칙연산, 임의 정밀도 / 큰 수 연산
*/
package main

import (
	"bufio"
	"bytes"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	line := bytes.Fields(scanner.Bytes())

	var lengthGap int = 0 // 첫번째수, 두번째수의 길이 차이

	if len(line[0]) != len(line[1]) { // 첫번째 숫자의 길이와 두번째숫자의 길이가 같지 않을 때
		if len(line[0]) > len(line[1]) { // 첫번째 숫자의 길이가 더 길다면
			lengthGap = len(line[0]) - len(line[1]) // 두 숫자의 차이나는 길이만큼

			for i := 0; i < lengthGap; i++ { // 두번째숫자 앞을 0으로 채워줌 (slice 크기 늘려줌)
				line[1] = append(line[1][:1], line[1][0:]...)
				line[1][0] = 0
			}
		} else { //두번째 숫자의 길이가 더 길다면.. 이하동문
			lengthGap = len(line[1]) - len(line[0])
			for i := 0; i < lengthGap; i++ {
				line[0] = append(line[0][:1], line[0][0:]...)
				line[0][0] = 0
			}
		}
	}

	/* for문돌면서 두개 슬라이스의 맨 오른쪽 끝 숫자값, 즉 1의자리수부터 더해갈거임 */
	var result []int          // 결과담을 result slice
	var carrying, tempSum int // carrying : 올림수 저장할 변수, tempSum : a + b 저장할 임시변수
	for i := len(line[0]) - 1; i >= 0; i-- {
		a, _ := strconv.Atoi(string(line[0][i])) // 아스키값을 int형으로 변환
		b, _ := strconv.Atoi(string(line[1][i]))

		if carrying > 0 {
			tempSum = (a + b + carrying) % 10 // a + b 가 올림수가 발생할경우가 있을 수 있기 때문에 나머지연산으로 1의자리수 구해줌
		} else {
			tempSum = (a + b) % 10 // 이하동문
		}

		if len(result) == 0 { // result slice 가 처음엔 nil 이기때문에 nil을 copy 하면 에러남. 바로 append 해줌
			result = append(result, tempSum)
		} else {
			result = append(result[:1], result[0:]...)
			result[0] = tempSum
		}

		if a+b+carrying >= 10 { // 올림수가 발생할 경우
			carrying = 1
		} else {
			carrying = 0
		}

	}

	if carrying > 0 { // 두 수를 다 더하고나서도 올림수가 남아있다면 마지막으로 한번더 맨 앞에다 append 해줌
		result = append(result[:1], result[0:]...)
		result[0] = carrying
	}

	for _, v := range result {
		writer.WriteString(strconv.Itoa(v))
	}
	writer.WriteByte('\n')
	writer.Flush()
}
