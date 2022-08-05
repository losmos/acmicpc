/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/4673
 	������ȣ : 4673
 	�˰��� : ����, ����, ���Ʈ���� �˰���
*/
package step_05_�Լ�.a002_�����ѹ�;

class Main {
	public int dN(int _param)
	{
		int remain = 0;
		int sum = _param;
		
		while(true)
		{
			remain = _param % 10;	// 1���ڸ���
			_param = _param / 10;
			sum = sum + remain;
			
			if(_param == 0)
			{
				break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		boolean[] result = new boolean[10000];

		int i=0;
		while(true)
		{
			i++;
			int checked = main.dN(i) -1;	// main.dN(i)�� d(n)�� ������ ���ϰ���. -1 ���ִ������� �迭�� 0�������� �����ϱ� ����
			

			// ó������ ������ ��������� 10000 ���ϱ��� �˻����پ˾Ƽ�  checked <= 10000 �϶� break �־�����. ���� ������?
			if(i > 10000)	
			{
				break; 	
			}
			
			if(checked < 10000)
			{
				result[checked] = true;	//checked�� �ش�Ǵ� ���ڴ� �����ѹ��� �ƴ�
			}
		}
		
		for(int j=0; j<result.length; j++)
		{
			if(result[j] == true)
			{
				continue;
			}
			
			System.out.println(j+1);
		}
		
	
	}
}
