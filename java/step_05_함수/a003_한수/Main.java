/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1065
 	문제번호 : 1065
 	알고리즘 : 브루트포스 알고리즘
*/
package step_05_함수.a003_한수;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		scan.close();
		
		int remain = 0;
		int shiftNum = 0;
		int sum = 0;
		
		StringBuilder sb = null;
		
		int resultCount = 0;
		
		for(int i=1; i<=N; i++)
		{
			sb = new StringBuilder();
			boolean result = false;
			
			shiftNum = i;
			while(true)
			{
				if(i <= 99)	// 수가 세자리수 미만일경우 무조건 등차수열조건에 부합.
				{
					result = true;
					break;
				}
				
				remain = shiftNum % 10;
				shiftNum = shiftNum / 10;
				sum = remain - (shiftNum % 10);
				
				sb.append(String.valueOf(sum));
				
				if(shiftNum < 10)
				{
					String checked = sb.toString().replaceAll(String.valueOf(sum), "");
					if(checked.length() == 0)
					{
						result = true;
					}
					
					break;
				}
				
			}
			
			if(result)
			{
				resultCount++;
			}
		}
		
		System.out.println(resultCount);
			
	}
}