/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1330
 	������ȣ : 1330
 	�˰��� : ����
*/
package Step_02_���ǹ�.a001_�μ����ϱ�;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		if(a>b)
		{
			System.out.println(">");
		}
		else if(a<b)
		{
			System.out.println("<");
		}
		else
		{
			System.out.println("==");
		}
	}
}
