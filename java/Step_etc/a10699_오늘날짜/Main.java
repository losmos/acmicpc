/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10699
 	문제번호 : 10699
 	알고리즘 : 구현
*/
package Step_etc.a10699_오늘날짜;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = new Date(System.currentTimeMillis());
		System.out.println(sdf.format(date));
	}
}