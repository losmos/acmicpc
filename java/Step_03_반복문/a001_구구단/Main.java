/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2739
 	������ȣ : 2739
 	�˰��� : ����, ����
*/
package Step_03_�ݺ���.a001_������;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i=1; i<10; i++)
		{
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}
}
