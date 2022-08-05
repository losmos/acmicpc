/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/4673
 	문제번호 : 4673
 	알고리즘 : 수학, 구현, 브루트포스 알고리즘
*/
package Step_05_함수.a002_셀프넘버;

class Main {
	public int dN(int _param)
	{
		int remain = 0;
		int sum = _param;
		
		while(true)
		{
			remain = _param % 10;	// 1의자리수
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
			int checked = main.dN(i) -1;	// main.dN(i)는 d(n)을 연산한 리턴값임. -1 해주는이유는 배열은 0번지부터 시작하기 때문
			

			// 처음에는 문제의 출력조건이 10000 이하까지 검사인줄알아서  checked <= 10000 일때 break 넣었었음. 문제 잘읽자?
			if(i > 10000)	
			{
				break; 	
			}
			
			if(checked < 10000)
			{
				result[checked] = true;	//checked에 해당되는 숫자는 셀프넘버가 아님
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
