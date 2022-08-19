/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1152
	문제번호 : 1152
	알고리즘 : 구현, 문자열
*/
package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	/*
		이건 왜 자꾸 오답나오는거지??????

		scanner := bufio.NewScanner(os.Stdin)
		scanner.Split(bufio.ScanLines)
		scanner.Scan()
		words := bytes.Fields(scanner.Bytes())
	*/

	line, _ := reader.ReadString('\n')
	words := strings.Fields(line)
	writer.WriteString(strconv.Itoa(len(words)))
	writer.Flush()

	/*
		주석풀고 수행하면 잘됨. 단지 느릴뿐.

		reg := regexp.MustCompile(`[^\s]+`)
		line, _ := reader.ReadString('\n')
		words := reg.FindAllString(line, -1)

		if line == "" {
			writer.WriteString("0") // 문자개수 0
		} else {
			writer.WriteString(strconv.Itoa(len(words))) // words 배열 length 출력
		}
		writer.Flush()
	*/
}
