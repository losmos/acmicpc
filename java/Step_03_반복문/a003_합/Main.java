/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/8393
 	������ȣ : 8393
 	�˰��� : ����, ����
*/
package Step_03_�ݺ���.a003_��;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int result = 0;
		for(int i=1; i<=N; i++)
		{
			result += i;
		}
		scan.close();
		
		System.out.println(result);
	}
}
