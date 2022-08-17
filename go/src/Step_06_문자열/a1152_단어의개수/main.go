/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1152
	문제번호 : 1152
	알고리즘 : 구현, 문자열
*/
package main

import (
	"bufio"
	"os"
	"regexp"
	"strconv"
	"strings"
)

func main() {
	// scanner := bufio.NewScanner(os.Stdin)
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	/*
		scanner.Split(bufio.ScanLines)
		scanner.Scan()
		line := scanner.Text()         // 문자열
		line = strings.Trim(line, " ") // 앞,뒤 공백 제거
		line = strings.TrimSuffix(line, "\n")
		line = strings.TrimSuffix(line, "\r")
	*/

	/* task : 띄어쓰기는 되는ㄷㅔ. Tab 공백은 인식못해서. 다른방식으로 해야됨.
	byte.fields 형식으로 받아서 처리하는것도 괜찮을듯*/
	reg := regexp.MustCompile("[^\\s]+")
	line, _ := reader.ReadString('\n')
	reg.FindAllString(line, -1)

	if line == "" {
		writer.WriteString("0") // 문자개수 0
	} else {
		words := strings.Split(line, " ")            // 공백을 구분으로 split
		writer.WriteString(strconv.Itoa(len(words))) // words 배열 length 출력
	}
	writer.Flush()
}
