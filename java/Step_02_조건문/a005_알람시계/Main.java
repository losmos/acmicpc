/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2884
 	������ȣ : 2884
 	�˰��� : ����, ��Ģ����
*/
package Step_02_���ǹ�.a005_�˶��ð�;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);

		String hour = scan.next();
		String minute = scan.next();
		scan.close();
		
		SimpleDateFormat sdf = new SimpleDateFormat("H m");
		
		Date date = sdf.parse(hour + " " + minute);
//		System.out.println(date);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, -45);
		
		String today = sdf.format(cal.getTime());
		System.out.println(today);
	}
}