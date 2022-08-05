/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2525
 	문제번호 : 2525
 	알고리즘 : 수학, 사칙연산
*/
package Step_02_조건문.a006_오븐시계;

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
		String cookingTime = scan.next();
		scan.close();
		
		SimpleDateFormat sdf = new SimpleDateFormat("H m");
		
		Date date = sdf.parse(hour + " " + minute);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, +Integer.parseInt(cookingTime));
		
		String today = sdf.format(cal.getTime());
		System.out.println(today);
	}
}