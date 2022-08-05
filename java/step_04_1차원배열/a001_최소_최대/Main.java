/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/10818
 	������ȣ : 10818
 	�˰��� : ����, ����
*/
package step_04_1�����迭.a001_�ּ�_�ִ�;

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