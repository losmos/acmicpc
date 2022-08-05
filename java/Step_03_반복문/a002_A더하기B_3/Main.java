/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10950
 	문제번호 : 10950
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_03_반복문.a002_A더하기B_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] nArray = new int[N];
		int a=0, b=0;
		
		for(int i=0; i<N; i++)
		{
			a = scan.nextInt();
			b = scan.nextInt();
			nArray[i] = a+b;
		}
		scan.close();
		
		for(int i=0; i<N; i++)
		{
			System.out.println(nArray[i]);
		}
	}
}
