/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2562
 	������ȣ : 2562
 	�˰��� : ����
*/
package step_04_1�����迭.a002_�ִ�;

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
