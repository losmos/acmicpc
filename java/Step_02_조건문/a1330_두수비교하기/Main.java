/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1330
 	문제번호 : 1330
 	알고리즘 : 구현
*/
package Step_02_조건문.a1330_두수비교하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		if(a>b)
		{
			System.out.println(">");
		}
		else if(a<b)
		{
			System.out.println("<");
		}
		else
		{
			System.out.println("==");
		}
	}
}
