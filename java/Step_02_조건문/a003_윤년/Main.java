/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2753
 	������ȣ : 2753
 	�˰��� : ����, ����, ��Ģ����
*/
package Step_02_���ǹ�.a003_����;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		scan.close();

		if(year%400 == 0)
		{
			System.out.println("1");
			
		}
		else if(year%4 == 0)
		{
			if (year%100 == 0)
			{
				System.out.println("0");
			}
			else
			{
				System.out.println("1");
			}
			
		}
		else
		{
			System.out.println("0");
		}
		
	}
}
