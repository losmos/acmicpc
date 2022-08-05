/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2480
 	������ȣ : 2480
 	�˰��� : ����, ��Ģ����
*/
package Step_02_���ǹ�.a007_�ֻ�������;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> diceList = new ArrayList<Integer>();
		diceList.add(scan.nextInt());
		diceList.add(scan.nextInt());
		diceList.add(scan.nextInt());
		scan.close();
		int result = 0;
		
		if(diceList.get(0) == diceList.get(1) && diceList.get(1) == diceList.get(2))
		{
			result = 10000 + (diceList.get(0) * 1000);
		}
		else if((diceList.get(0) == diceList.get(1) && diceList.get(1) != diceList.get(2)))
		{
			result = 1000 + (diceList.get(0) * 100);
		}
		else if((diceList.get(0) == diceList.get(2) && diceList.get(2) != diceList.get(1)))
		{
			result = 1000 + (diceList.get(2) * 100);
		}
		else if((diceList.get(1) == diceList.get(2) && diceList.get(1) != diceList.get(0)))
		{
			result = 1000 + (diceList.get(1) * 100);
		}
		else
		{
			Collections.sort(diceList);
			result = diceList.get(2) * 100;
		}
		
		System.out.println(result);
		
	}
}