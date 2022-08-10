/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15596
 	문제번호 : 15596
 	알고리즘 : 수학, 구현, 사칙연산
*/
package Step_05_함수.a15596_정수N개의합;

class Test {
	public long sum(int[] a)
	{
		long result = 0;
		
		for(int i=0; i<a.length; i++)
		{
			result+=(long)a[i];
		}
		
		return result;
	}
}
