/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/1065
 	������ȣ : 1065
 	�˰��� : ���Ʈ���� �˰���
*/
package step_05_�Լ�.a003_�Ѽ�;

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
				if(i <= 99)	// ���� ���ڸ��� �̸��ϰ�� ������ �����������ǿ� ����.
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