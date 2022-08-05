/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2577
 	������ȣ : 2577
 	�˰��� : ����, ����, ��Ģ����
*/
package step_04_1�����迭.a003_�����ǰ���;

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