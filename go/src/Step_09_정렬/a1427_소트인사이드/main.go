/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/1427
문제번호 : 1427
알고리즘 : 문자열, 정렬
*/
package main

import (
	"bufio"
	"os"
	"strconv"
)

/*
 * 입력숫자범위가 0~9라서 카운팅정렬 응용해서 쓰기 적합할듯
 */
func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	countingArr := make([]int, 10)

	for {
		byteValue, err := reader.ReadByte() // 바이트 단위로 읽음
		if byteValue < '0' || byteValue > '9' || err != nil {
			break
		}

		index, _ := strconv.Atoi(string(byteValue))
		countingArr[index]++ // 입력값(1글자)을 주소값으로 갖는 countingArr의 value를 +1 해줌
	}

	// 출력
	for i := 9; i >= 0; i-- {
		for j := 0; j < countingArr[i]; j++ {
			writer.WriteString(strconv.Itoa(i))
		}
	}
	writer.Flush()
}
