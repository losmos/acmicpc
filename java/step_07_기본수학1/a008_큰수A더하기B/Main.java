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


public class Main {
	
	public int[] convertArr(String _paramStr)
	{
		char[] charArray = _paramStr.toCharArray();
		
		int[] intArray = new int[charArray.length];
	
		for(int i=0; i<charArray.length; i++)
		{
			intArray[i] = Character.getNumericValue(charArray[i]);
		}
		
		return intArray;
	}
	
	public String calc(int[] _aArr, int[] _bArr)
	{
		int length = _aArr.length >= _bArr.length ? _aArr.length : _bArr.length;
		String result = "";
		int carry = 0;

		boolean _aArrOvered = true;	// true : loop�����߿� _aArr�� length�� �����ʾ���. false : �Ѿ���
		boolean _bArrOvered = true; // true : loop�����߿� _bArr�� length�� �����ʾ���. false : �Ѿ���
		
		int overedIndexA = 0;
		int overedIndexB = 0;
		
		for(int i=0; i<length+1; i++)
		{
			int a = 0;		// A���ڿ��� �� �� 1�ڸ� ����
			int b = 0;		// B���ڿ��� �� �� 1�ڸ� ����
			
			
			if(_aArrOvered)				// ���� length �ȳѾ��ٸ�
			{
				a = _aArr[_aArr.length-1-i];
			}
			else						// �Ѿ����� 0
			{
				a = 0;
			}
			
			if(_bArrOvered)				// ���� length �ȳѾ��ٸ�
			{
				b = _bArr[_bArr.length-1-i];
			}
			else
			{
				b = 0;					// �Ѿ����� 0
			}
			
			
			if(carry == 0 && (!_aArrOvered || !_bArrOvered))	// carry�� �߻������ʾҰ�, A�� B�� ���ڿ��� ª�������� ���ڱ��� ��δ� ���������.
			{
				if(!_aArrOvered)		// ª���� A��� B�� ������ ���ڿ��� result �տ��ٰ� ����
				{
					int remainLength = _bArr.length - overedIndexA - (i - overedIndexA);
					for(int j=0; j<remainLength; j++)
					{
						result = _bArr[remainLength-1-j] + result;
					}
				}
				else if(!_bArrOvered)	// ª���� B��� A�� ������ ���ڿ��� result �տ��ٰ� ����
				{
					int remainLength = _aArr.length - overedIndexB - (i - overedIndexB);
					for(int j=0; j<remainLength; j++)
					{
						result = _aArr[remainLength-1-j] + result;
					}
				}
				
				break;
			}
			
			int plus = a + b + carry;
			result = plus%10 + result;	// result ���ڿ� �����
			
			if(plus >= 10 && (_aArrOvered || _bArrOvered))	// carry�� �߻��ߴٸ�
			{
				carry = plus / 10;
			}
			else
			{
				carry = 0;
			}
			
			
			if(i == _aArr.length-1)
			{
				_aArrOvered = false;	// length �Ѿ���
				overedIndexA = i+1;		// over�� ������ index i�� ����
			}
			if(i == _bArr.length-1)
			{
				_bArrOvered = false;	// length �Ѿ���
				overedIndexB = i+1;		// over�� ������ index i�� ����
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int[] aIntArray = main.convertArr(A);
		int[] bIntArray = main.convertArr(B);
		
		String result = main.calc(aIntArray, bIntArray);
		
		bw.write(result);
		bw.flush();
		bw.close();
	}
}