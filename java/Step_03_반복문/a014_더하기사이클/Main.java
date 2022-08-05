/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1110
 	문제번호 : 1110
 	알고리즘 : 수학, 구현
*/
package Step_03_반복문.a014_더하기사이클;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
			
		st = new StringTokenizer(br.readLine(), "");
		
		String tempStr = st.nextToken();
		if(tempStr.length() < 2)
		{
			tempStr += "0";
		}
		
		sb.append(tempStr);
		int count = 0;
		int a = 0;
		int b = 0;
		String result = sb.toString();
		while(true)
		{
			
			a = Integer.parseInt(result.substring(0, 1));
			b = Integer.parseInt(result.substring(1, 2));
			
			if(sb.toString().equals(result) && count != 0)
			{
				break;
			}
			count ++;
			result = String.valueOf(a+b);
			
			
			a = b;
			if(result.length() >= 2)
			{
				b = Integer.parseInt(result.substring(1, 2));
			}
			else
			{
				b = Integer.parseInt(result);
			}
			result = String.valueOf(a) + String.valueOf(b);;
			
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
