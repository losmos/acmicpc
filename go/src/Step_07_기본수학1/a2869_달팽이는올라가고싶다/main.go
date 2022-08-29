/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2869
	문제번호 : 2869
	알고리즘 : 수학
*/
package main

import (
	"bufio"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	scanner.Split(bufio.ScanLines)
	scanner.Scan()
	line := scanner.Text()

	inputArr := strings.Split(line, " ")
	A, _ := strconv.Atoi(inputArr[0]) // 낮에 올라갈수있는 거리 A
	B, _ := strconv.Atoi(inputArr[1]) // 밤되면 미끄러지는 거리 B
	V, _ := strconv.Atoi(inputArr[2]) // 올라가고자하는 목표 정상거리 C

	var targetV float64 = float64(V - A) //낮 A만큼을 뺀 거리. 즉 targetV만큼 도달한다음에. 다음날 낮에 A만큼 한번만 올라가면 정상에 도달함

	day := math.Ceil(targetV/float64(A-B)) + 1

	writer.WriteString(strconv.FormatFloat(day, 'f', -1, 64))
	writer.WriteByte('\n')
	writer.Flush()
}
