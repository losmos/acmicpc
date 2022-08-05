/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/9498
 	문제번호 : 9498
 	알고리즘 : 구현
*/
package Step_02_조건문.a002_시험성적;

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
