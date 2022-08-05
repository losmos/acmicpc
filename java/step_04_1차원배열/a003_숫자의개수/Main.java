/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2577
 	문제번호 : 2577
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_04_1차원배열.a003_숫자의개수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nArray = new int[10];
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		scan.close();
		int multipleVal = a*b*c;
		
		while(true)
		{
			nArray[multipleVal % 10] = nArray[multipleVal % 10] + 1;
			
			multipleVal = multipleVal / 10;
			
			if(multipleVal <= 0)
			{
				break;
			}
		}
		
		for(int i=0; i<10; i++)
		{
			System.out.println(nArray[i]);
		}
	}
}