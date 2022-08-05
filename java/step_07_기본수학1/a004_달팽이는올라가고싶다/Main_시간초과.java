/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2869
 	������ȣ : 2869
 	�˰��� : ����
*/
package step_07_�⺻����1.a004_�����̴¿ö󰡰�ʹ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_�ð��ʰ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());	// ���� �ö󰥼��ִ� �Ÿ� A
		int B = Integer.parseInt(st.nextToken());	// ��Ǹ� �̲������� �Ÿ� B
		int V = Integer.parseInt(st.nextToken());	// �ö󰡰����ϴ� ��ǥ ����Ÿ� C
		
		int distance = 0;
		int day = 0;
		while(true)
		{
			day ++;				// �Ϸ簡 ����
			distance += A;		// �ö�
			
			if(distance >= V)	// ���� �����ߴٸ� break
			{
				break;
			}
			
			distance -= B;		// �̲�����
		}
		
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();
	}
}
