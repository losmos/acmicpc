/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10809
	문제번호 : 10809
	알고리즘 : 구현, 문자열
*/
package main

import (
	"bufio"
	"bytes"
	"os"
	"strconv"
)

/**
* @param _inputStr	: 검사할 입력 문자열
* @param _targetStr	: 찾고자하는 문자의 아스키값
 */
func findIdx(_inputStr bytes.Buffer, _targetStr byte) int {

	// _inputStr를 bytes.Buffer -> []byte 형으로 변환. 문자열의 각1개문자씩 검사하며 loop
	for i, v := range _inputStr.Bytes() {
		if v == _targetStr { // byte값으로 비교
			return i // _inputStr에서 _targetStr이 발견된 위치 return
		}
	}

	return -1 // 발견이 안되면 -1 return
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()

	var startChar byte = 'a' // 검사 시작문자 a의 아스키값을저장할 변수
	var endChar byte = 'z'   // 검사 마지막문자 z의 아스키값을저장할 변수

	var bb bytes.Buffer
	bb.WriteString(scanner.Text()) // 검사할 input 문자열

	for i := startChar; i <= endChar; i++ { // i는 a의 아스키값 97부터 z 아스키값까지 loop
		var strIdx int = findIdx(bb, i)          // _inputStr에서 _targetStr이 발견된 위치 저장
		writer.WriteString(strconv.Itoa(strIdx)) // 출력
		writer.WriteByte(' ')
	}

	writer.Flush()
}
