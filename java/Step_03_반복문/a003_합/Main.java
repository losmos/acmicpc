/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/8393
 	문제번호 : 8393
 	알고리즘 : 수학, 구현
*/
package Step_03_반복문.a003_합;

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
