/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/10757
 	������ȣ : 10757
 	�˰��� : ����, ����, ��Ģ����, ���� ���е�/ū �� ����
*/
package step_07_�⺻����1.a008_ū��A���ϱ�B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_83���ο��������ٲٰ�����ʹٽ��� {
	
	public int calc(StringBuilder _A, StringBuilder _B, int _carry)
	{
		int a = Character.getNumericValue(_A.charAt(_A.length()-1));	// A ���ڿ� �� ���ڸ��� ����
		int b = Character.getNumericValue(_B.charAt(_B.length()-1));	// B ���ڿ� �� ���ڸ��� ����
		int plus = a + b + _carry; 
		
		return plus;
	}
	
	public static void main(String[] args) throws IOException {
		Main_83���ο��������ٲٰ�����ʹٽ��� main = new Main_83���ο��������ٲٰ�����ʹٽ���();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder A = new StringBuilder();	// �Է°� A
		StringBuilder B = new StringBuilder();	// �Է°� B
		String result = "";						// ���������
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		A.append(st.nextToken());
		B.append(st.nextToken());

		
		int ALength = A.length();	// A���ڿ� ����
		int BLength = B.length();	// B���ڿ� ����
		int carry = 0;				// �ø��ڸ���
		
		for(int i=0; i<(ALength>=BLength?BLength:ALength); i++)	// A�� B�߿��� �� ª�� ���ڿ� length��ŭ loop ��
		{
			int plus = main.calc(A, B, carry);
			
			if(plus >= 10)	// �ڸ� �ø����� �߻�������� �ø��� ����
			{
				carry = plus / 10;
			}
			else
			{
				carry = 0;
			}
			
			A.delete(A.length()-1, A.length());	// A�� �� ���� ����
			B.delete(B.length()-1, B.length());	// B�� �� ���� ����
			
			result = plus%10 + result;			// A+B���� ���� �ϳ��ϳ��� �������� result�� ����
		}
		
		
		if(ALength == BLength)					// A�� B�Ǳ��̰� ���ٸ�
		{
			if(carry > 0)
			{
				bw.write(carry + result);		// carry�� �߻�������� �Ǿտ��� �ٿ���
			}
			else
			{
				bw.write(result);				// carry ������ �׳� ���
			}
			
		}
		else if(ALength > BLength)
		{
			if(carry > 0)	// carry�� �߻��������, �ǳ��ڸ� ���ڿ� carry�� ������
			{
				int secondPlus = Character.getNumericValue(A.charAt(A.length()-1)) + carry;
				int secondCarry = 0;
				if(secondPlus > 10)		// �� ĳ���� �߻��Ұ�� �μ��� �� �����ִ�..... �� �̰� �ƴϴٽʹ�.
				{
					for(int i=0; i<1; i++)
					{
						
					}
				}
				else
				{
					A.replace(A.length()-2, A.length()-1, String.valueOf(secondPlus));
				}
				
			}
			else
			{
				bw.write(A + result);
			}
			
		}
		else if(ALength < BLength)
		{
			if(carry > 0)
			{
				B.replace(B.length()-2, B.length()-1, String.valueOf(Character.getNumericValue(B.charAt(B.length()-1)) + carry));
			}
			
			bw.write(B.toString() + result);
		}
		
		bw.flush();
		bw.close();
		
	}
}