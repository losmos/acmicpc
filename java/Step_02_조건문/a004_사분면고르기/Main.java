/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/14681
 	������ȣ : 14681
 	�˰��� : ����, ������
*/
package Step_02_���ǹ�.a004_��и����;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();

		if(x*y>0)
		{
			if(x>0)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("3");
			}
		}
		else
		{
			if(x>0)
			{
				System.out.println("4");
			}
			else
			{
				System.out.println("2");
			}
		}
		
	}
}