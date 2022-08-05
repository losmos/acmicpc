/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11654
 	문제번호 : 11654
 	알고리즘 : 구현
*/

package Step_06_문자열.a001_아스키코드;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char input = scan.next().charAt(0);	// Scanner로 입력받은 String 문자열중 0번째 인덱스를 꺼내서 character 형으로 받음
		scan.close();
		
		System.out.println((int)input);
	}
}
