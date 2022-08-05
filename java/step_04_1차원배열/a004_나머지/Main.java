/*
s 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/3052
 	문제번호 : 3052
 	알고리즘 : 수학, 사칙연산
*/
package step_04_1차원배열.a004_나머지;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map map = new HashMap<Integer, String>();

		for(int i=0; i<10; i++)
		{
			int result = scan.nextInt() % 42;
			map.put(result, "");
		}
		scan.close();
		
		System.out.println(map.size());
		
	}
}