/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15552
	문제번호 : 15552
	알고리즘 : 수학, 구현, 사칙연산
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

	line, _ := reader.ReadString('\n')    // 구분자인 개행('\n') 까지 잘라서 읽어와 string타입으로 return함
	line = strings.TrimSuffix(line, "\n") // 맨뒤 \n 잘라서 없앰
	line = strings.TrimSuffix(line, "\r") // 맨뒤 \r 잘라서 없앰
	T, _ := strconv.Atoi(line)            // 읽어온 입력값을 string -> int로 변환

	for i := 1; i <= T; i++ {
		line, _, _ := reader.ReadLine() // InputStream으로 들어오는 값을 읽어서 single line(byte[]형)으로 return함. return하는 과정에서 string을 byte로 변환했기 때문에 문자열이 숫자의 형태더라도 숫자를 character로 인식한 byte값을 return하게 됨

		var number int
		var word string
		var result int
		for _, v := range line { // line을 character형으로 하나하나씩 자른 v
			if v == ' ' { // v가 공백이라면(ex: 12 34 입력할경우 중간 공백 인식)
				number, _ = strconv.Atoi(word) // 숫자로 변환해서 number변수에 담음
				result += number
				word = "" // word 변수 초기화(다음 loop에서도 사용해야하므로)

				continue
			} else {
				word = word + string(v) //character 타입의 숫자를 string으로 변환해서 word에 담음
			}
		}

		number, _ = strconv.Atoi(word) // 공백 뒤에 입력된 숫자도 number에 담음
		result += number

		writer.WriteString(strconv.Itoa(result)) // string -> int 변환
		writer.WriteByte('\n')                   // 맨끝문자 'n' 넣어줌
	}

	writer.Flush() // 출력
}
