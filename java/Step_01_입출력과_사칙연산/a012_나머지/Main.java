/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10430
 	문제번호 : 10430
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_01_입출력과_사칙연산.a012_나머지;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);
	}
}
