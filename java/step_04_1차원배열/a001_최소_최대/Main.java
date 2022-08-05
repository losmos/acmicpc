/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10818
 	문제번호 : 10818
 	알고리즘 : 수학, 구현
*/
package step_04_1차원배열.a001_최소_최대;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] nArray = new int[N];
		
		for(int i=0; i<N; i++)
		{
			nArray[i] = scan.nextInt();
		}
		scan.close();
		
		int min = 0;
		int max = 0;

		min=nArray[0];
		max=nArray[0];
		
		for(int i=0; i<N; i++)
		{
			if(nArray[i] < min)
			{
				min = nArray[i];
			}
			else if(nArray[i] > max)
			{
				max = nArray[i];
			}
		}
		
		System.out.println(min + " " + max);
	}
}