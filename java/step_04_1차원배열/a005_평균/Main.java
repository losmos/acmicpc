/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1546
 	문제번호 : 1546
 	알고리즘 : 수학, 사칙연산
*/
package step_04_1차원배열.a005_평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] nArray = new int[N];
		double max = 0;
		for(int i=0; i<N; i++)
		{
			nArray[i] = scan.nextInt();
			if(nArray[i] > max)
			{
				max = nArray[i];
			}
			
		}
		scan.close();
		
		double result = 0;
		for(int i=0; i<N; i++)
		{
			result = result + (nArray[i] / max) * 100;
		}
		
		System.out.println(result / N);
	}
}