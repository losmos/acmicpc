/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14681
 	문제번호 : 14681
 	알고리즘 : 구현, 기하학
*/
package Step_02_조건문.a004_사분면고르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();

		if(x*y>0)
		{
			if(x>0)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("3");
			}
		}
		else
		{
			if(x>0)
			{
				System.out.println("4");
			}
			else
			{
				System.out.println("2");
			}
		}
		
	}
}