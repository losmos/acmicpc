/*
	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15596
	문제번호 : 15596
	알고리즘 : 수학, 구현, 사칙연산
*/
package main

func sum(a []int) int {
	var result int
	for _, v := range a {
		result += v
	}

	return result
}
