/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2775
 	문제번호 : 2775
 	알고리즘 : 수학, 구현
*/
package Step_07_기본수학1.a2775_부녀회장이될테야;

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
		
		int k = 0;	// 층
		int n = 0;	// 호
		for(int x=0; x<T; x++)
		{
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			int[][] knArray = new int[k+1][n];		//문제의 k층은 0층부터시작하므로. 배열 row 개수는 +1 해줘야함
			
			for(int i=0; i<knArray.length; i++)
			{
				int upFloorCalc = 0;
				
				for(int j=0; j<n; j++)
				{
					if(i==0)	// 맨 바닥층이라면 값 초기화해줌
					{
						knArray[i][j] = j+1;	// 바닥층 초기화
						upFloorCalc += j+1;		// 윗층 계산해서 넣어줌
						
						if(k > 0 )	// 위에 층이 존재한다면
						{
							knArray[i+1][j] = upFloorCalc;	// 윗층 계산해서 넣어줌 
						}
					}
					else		// 바닥층이 아니라면
					{
						if(i != knArray.length-1)	// 위에 층이 존재한다면
						{
							upFloorCalc += knArray[i][j];	// 윗층계산
							knArray[i+1][j] = upFloorCalc; 	// 윗층에 값 넣어줌
						}
					}
					
				}
				
			}
			
			/*
			 * 배열 전체 출력
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