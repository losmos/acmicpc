/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10869
 	문제번호 : 10869
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_01_입출력과_사칙연산.a10869_사칙연산;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int val1 = scan.nextInt();
		int val2 = scan.nextInt();
		
		System.out.println(val1 + val2);
		System.out.println(val1 - val2);
		System.out.println(val1 * val2);
		System.out.println(val1 / val2);
		System.out.println(val1 % val2);
	}
}
