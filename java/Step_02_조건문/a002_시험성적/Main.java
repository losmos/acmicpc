/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/9498
 	������ȣ : 9498
 	�˰��� : ����
*/
package Step_02_���ǹ�.a002_���輺��;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int score = scan.nextInt();
		scan.close();
		
		switch(score/10) {
		case 10: 
			System.out.println("A");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default : 
			System.out.println("F");
			
		}
		
	}
}
