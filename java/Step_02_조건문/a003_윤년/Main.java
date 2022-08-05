/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2753
 	문제번호 : 2753
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_02_조건문.a003_윤년;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		scan.close();

		if(year%400 == 0)
		{
			System.out.println("1");
			
		}
		else if(year%4 == 0)
		{
			if (year%100 == 0)
			{
				System.out.println("0");
			}
			else
			{
				System.out.println("1");
			}
			
		}
		else
		{
			System.out.println("0");
		}
		
	}
}
