/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2775
 	������ȣ : 2775
 	�˰��� : ����, ����
*/
package step_07_�⺻����1.a006_�γ�ȸ���̵��׾�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int k = 0;	// ��
		int n = 0;	// ȣ
		for(int x=0; x<T; x++)
		{
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			int[][] knArray = new int[k+1][n];		//������ k���� 0�����ͽ����ϹǷ�. �迭 row ������ +1 �������
			
			for(int i=0; i<knArray.length; i++)
			{
				int upFloorCalc = 0;
				
				for(int j=0; j<n; j++)
				{
					if(i==0)	// �� �ٴ����̶�� �� �ʱ�ȭ����
					{
						knArray[i][j] = j+1;	// �ٴ��� �ʱ�ȭ
						upFloorCalc += j+1;		// ���� ����ؼ� �־���
						
						if(k > 0 )	// ���� ���� �����Ѵٸ�
						{
							knArray[i+1][j] = upFloorCalc;	// ���� ����ؼ� �־��� 
						}
					}
					else		// �ٴ����� �ƴ϶��
					{
						if(i != knArray.length-1)	// ���� ���� �����Ѵٸ�
						{
							upFloorCalc += knArray[i][j];	// �������
							knArray[i+1][j] = upFloorCalc; 	// ������ �� �־���
						}
					}
					
				}
				
			}
			
			/*
			 * �迭 ��ü ���
			for(int[] item : knArray)
			{
				for(int innerItem : item)
				{
					System.out.print(innerItem + " ");
				}
				System.out.println("");
			}
			*/
			
			bw.write(String.valueOf(knArray[k][n-1])+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}