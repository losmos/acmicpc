/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/15596
 	������ȣ : 15596
 	�˰��� : ����, ����, ��Ģ����
*/
package step_05_�Լ�.a001_����N������;

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
