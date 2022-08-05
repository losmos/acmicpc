/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2562
 	문제번호 : 2562
 	알고리즘 : 구현
*/
package Step_04_1차원배열.a002_최댓값;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		int inputVal = 0;
		int maxIndex = 0;
		for(int i=0; i<9; i++)
		{
			inputVal = scan.nextInt();
			if(inputVal > max)
			{
				max = inputVal;
				maxIndex = i+1;
				
			}
		}
		scan.close();
		System.out.println(max);
		System.out.println(maxIndex);
	}
}
