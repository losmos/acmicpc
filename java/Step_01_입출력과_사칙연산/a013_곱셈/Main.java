/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2588
 	������ȣ : 2588
 	�˰��� : ����, ��Ģ����
*/
package Step_01_����°�_��Ģ����.a013_����;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input1 = scan.nextInt();
		int input2 = scan.nextInt();
		
		int[] input1Arr = new int[3];
		int[] input2Arr = new int[3];
		int[][] resultArr = new int[3][4];
		
		for(int i=2; i>=0; i--)	//int[3] �迭 ������ �� index�� ���ڸ����� �ϳ��� ������ ����
		{
			input1Arr[i] = input1 % 10;
			input1 = input1 / 10;
			
			input2Arr[i] = input2 % 10;
			input2 = input2 / 10;
		}
		
		int tempVal = 0;
		int index = 2;
		
		for(int i=0; i<3; i++)	// loop ���鼭 �ø��ڸ����� tempVal�� �����ϰ� �������°� �迭�� �� �־���
		{
			for(int j=2; j>=0; j--)
			{
				int multipleVal = input1Arr[j] * input2Arr[index];
				if(tempVal != 0)
				{
					multipleVal += tempVal;
				}
				tempVal = 0;
				resultArr[i][j+1] = multipleVal % 10;
				if(multipleVal >= 10)
				{
					tempVal = multipleVal / 10;
					tempVal = tempVal % 10;
				}
			}
			index--;
			resultArr[i][0] = tempVal;
			tempVal = 0;
		}

		// ��� ���
		int result = 0;
		int lastResult = 0;
		int shift = 1;
		for(int i=0; i<resultArr.length; i++)
		{
			result = resultArr[i][0]*1000 + resultArr[i][1]*100 + resultArr[i][2]*10 + resultArr[i][3];
			System.out.println(result);
			result = result * shift;
			lastResult += result;
			shift = shift * 10;
		}
		
		System.out.println(lastResult);
		
	}
}
