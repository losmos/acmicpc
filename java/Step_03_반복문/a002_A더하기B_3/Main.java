/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/10950
 	������ȣ : 10950
 	�˰��� : ����, ����, ��Ģ����
*/
package Step_03_�ݺ���.a002_A���ϱ�B_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] nArray = new int[N];
		int a=0, b=0;
		
		for(int i=0; i<N; i++)
		{
			a = scan.nextInt();
			b = scan.nextInt();
			nArray[i] = a+b;
		}
		scan.close();
		
		for(int i=0; i<N; i++)
		{
			System.out.println(nArray[i]);
		}
	}
}
