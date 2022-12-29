/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1931
 	문제번호 : 1931
 	알고리즘 : 그리디 알고리즘, 정렬
*/
package Step_19_그리디알고리즘.a1931_회의실배정;


import java.util.Arrays;
import java.util.Scanner;


class IO {
	Scanner scan = new Scanner(System.in);
	
	//input Method
	public int[][] input()
	{
		int meetingNum = 0;
		int reservedMeeting [][] = null;
		
		meetingNum = scan.nextInt();
		if(meetingNum < 1 || meetingNum > 100000)
		{
			System.exit(1);
		}
		
		reservedMeeting = new int[meetingNum][2];
		
		for(int i=0; i<meetingNum; i++)
		{
			reservedMeeting[i][0] = scan.nextInt();
			reservedMeeting[i][1] = scan.nextInt();
		}
		
		return reservedMeeting;
	}
	
	//output Method
	public void output(int _result)
	{
		System.out.println(_result);
	}
}

class Calc {
	public int run(int[][] _reservedM)
	{
		//배열 sort
		Arrays.sort(_reservedM, (o1, o2) -> {
			if (o1[1] == o2[1]) 
			{
				return Integer.compare(o1[0], o2[0]);
			}
			else
			{
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		/* sorting 결과 출력
		for(int i=0; i<_reservedM.length; i++)
		{
			System.out.println("[" + _reservedM[i][0] + ", " + _reservedM[i][1] + "]");
		}
		System.out.println("SORT END");
		*/
		
		
		/* 정답제출했으나 이중for문으로 시간초과 
		int result = 0;
		for(int x=0; x<_reservedM.length; x++)
		{
			int count = 0, endTime =-1;
			for(int i=x; i<_reservedM.length; i++)
			{
				if(_reservedM[i][0] >= endTime)
				{
					endTime = _reservedM[i][1];
//					System.out.println("[" + _reservedM[i][0] + ", " + _reservedM[i][1] + "]");
					count ++;
				}
				
				if( i == _reservedM.length -1)
				{
					if(count > result)
						result = count;
				}
			}
		}
		*/
		
		//문제의 해답을 구하는 로직
		int count = 0, endTime =-1;
		for(int i=0; i<_reservedM.length; i++)
		{
			if(_reservedM[i][0] >= endTime)
			{
				endTime = _reservedM[i][1];
//				System.out.println("[" + _reservedM[i][0] + ", " + _reservedM[i][1] + "]");
				count ++;
			}
			
		}
//		return result;
		return count;
	}
	
}


public class Main {
	
	public static void main(String args[])
	{
		IO io = new IO();
		Calc calc = new Calc();
		
		int reservedM[][] = io.input();
		int result = calc.run(reservedM);
		io.output(result);
	}
}