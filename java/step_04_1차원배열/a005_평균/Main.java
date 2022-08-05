/*
s 	������ó : BACKJOON, https://www.acmicpc.net/problem/1546
 	������ȣ : 1546
 	�˰��� : ����, ��Ģ����
*/
package step_04_1�����迭.a005_���;

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