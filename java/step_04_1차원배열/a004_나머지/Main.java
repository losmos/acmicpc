/*
s 	������ó : BACKJOON, https://www.acmicpc.net/problem/3052
 	������ȣ : 3052
 	�˰��� : ����, ��Ģ����
*/
package step_04_1�����迭.a004_������;

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