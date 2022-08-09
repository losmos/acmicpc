/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1110
	문제번호 : 1110
	알고리즘 : 수학, 구현
*/

package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	var reader = bufio.NewReader(os.Stdin)  // InputStream
	var writer = bufio.NewWriter(os.Stdout) // OutputStream

	line, _ := reader.ReadString('\n') // 개행이올때까지의 InputStream을 읽어서 line변수에 저장

	// \r\n 문자 제거 : 커서를 맨 앞으로 보내고 개행한다는 의미의 문자
	line = strings.TrimSuffix(line, "\n")
	line = strings.TrimSuffix(line, "\r")

	var targetStr string // 처음 입력된 input 값(돌고돌아 다시 되돌아와야될 값)

	if len(line) < 2 { // input이 1자리라면 뒤에 0을 붙임
		line = line + "0"
	}

	targetStr = line
	lineArr := strings.Split(line, "") // string Type의 line변수를 배열 lineArr로 변환함

	var i int = 0 // index
	for {
		i++

		var result int // a + b를 더한값을 담기위한 변수

		a, _ := strconv.Atoi(lineArr[0])
		b, _ := strconv.Atoi(lineArr[1])

		result = (a + b) % 10

		lineArr[0] = lineArr[1]           // 문제의 조건
		lineArr[1] = strconv.Itoa(result) // 문제의 조건

		var joinedStr = strings.Join(lineArr, "") // 아래 if문으로 같은지 비교하기위해서 먼저 변환(string[] -> string)
		if targetStr == joinedStr {               // 원래대로 돌아왔다면 break
			break
		}
	}

	// 출력
	writer.WriteString(strconv.Itoa(i))
	writer.WriteByte('\n')
	writer.Flush()
}
