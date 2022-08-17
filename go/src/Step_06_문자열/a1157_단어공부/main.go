/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1157
	문제번호 : 1157
	알고리즘 : 구현, 문자열
*/
package main

import (
	"bufio"
	"bytes"
	"os"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanBytes)

	var strCntArr [byte('Z') - byte('A') + 1]int // 'A'는 0번지 ... 'Z'는 26번지에 매핑

	for scanner.Scan() {
		oneStr := strings.ToUpper(scanner.Text()) // 문자를읽어서 ToUpper
		if oneStr == "\r" || oneStr == "\n" {
			break
		}

		strByteArr := []byte(oneStr)      // 변환 : string -> []byte
		nb := bytes.NewBuffer(strByteArr) // 변환 : []byte -> *bytes.Buffer
		idx, _ := nb.ReadByte()           // 변환 : *bytes.Buffer -> byte
		idx = idx - 'A'                   // A문자와 매핑되는 strCntArr index가 0이므로
		strCntArr[idx]++                  // 해당문자 출현cnt ++
	}

	var maxCntIdx, maxCntWord int // 가장많이 출현한 문자의 인덱스, 가장 출현한 문자
	var maxdupl bool = false      // 가장 많은 문자가 2개 이상일경우 true
	for index, v := range strCntArr {
		if v > maxCntWord { // 문자 출현횟수가 가장 많다면
			maxCntWord = v    // 해당 문자의 출현횟수 저장
			maxCntIdx = index // 해당 문자와 매핑되는 strCntArr의 인덱스값
			maxdupl = false
			continue
		}

		if v == maxCntWord {
			maxdupl = true
		}
	}

	if maxdupl {
		writer.WriteString("?")
	} else {
		writer.WriteByte(byte(maxCntIdx) + 'A')
	}
	writer.Flush()
}
