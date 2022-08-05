/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2739
 	문제번호 : 2739
 	알고리즘 : 수학, 구현
*/
package Step_03_반복문.a001_구구단;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i=1; i<10; i++)
		{
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}
}
