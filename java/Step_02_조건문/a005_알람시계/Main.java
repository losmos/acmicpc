/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2884
 	문제번호 : 2884
 	알고리즘 : 수학, 사칙연산
*/
package Step_02_조건문.a005_알람시계;

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