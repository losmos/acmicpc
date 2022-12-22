/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/16139
 	문제번호 : 16139
 	알고리즘 : 누적 합
*/
package Step_18_누적합.a16139_인간_컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 문자열 yishinho 입력되면
 * 아래와같은 구조로 누적합정보를 저장하고 있을거임.
 * 세로(i)는 a~z 알파벳 문자열이고
 * 가로(j)는 누적합
 * (참고로 아래 2차원배열 그린거에서 공백은 다 0값임. 일일이 다 치기 귀찮)
 * 
 *   0 y i s h i n h o
 * a
 * b
 * c
 * d
 * e
 * f
 * g
 * h 0 0 0 0 1 1 1 2 2
 * i 0 0 1 1 1 2 2 2 2
 * j
 * k
 * l
 * m
 * n 0 0 0 0 0 0 1 1 1
 * o 0 0 0 0 0 0 0 0 1
 * p
 * q
 * r
 * s 0 0 0 1 1 1 1 1 1
 * t
 * u
 * v
 * w
 * x
 * y 0 1 1 1 1 1 1 1 1
 * z
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		char[] str = br.readLine().toCharArray();
		int alphabetLength = ('z' - 'a') + 1;
		int strLength = str.length;
		int offset = 'a';

		int[][] arr = new int[alphabetLength][strLength + 1];	// 2차원배열 초기화할때 열size strLength에 +1 해주는 이유는, 아래 [주석01] 코멘트 달아둔 내용을 참조

		for(int i = 0, range1 = strLength; i < range1; i++) {
			for(int j = 0, range2 = alphabetLength; j < range2; j++) {
                if(j == str[i] - offset) {
                    arr[j][i+1] = arr[j][i] + 1;
                } else {
                    arr[j][i+1] = arr[j][i];
                }
            }
		}

		/*
		// 누적합 배열 출력용
        System.out.println();
		for(int i = 0; i < alphabetLength; i++) {
			for(int j = 0; j <= strLength; j++) {
				System.out.println(arr[i][j] + " ");
			}
			System.out.println();
		}
		*/

		int q = Integer.parseInt(br.readLine());	// 질문 수(테스트케이스 수)
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char alphabet = st.nextToken().charAt(0);
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());

			int iIndex = alphabet - offset;

			/**
			 * [주석01] 코멘트
			 * 
			 * 저 위에 int[][] arr = new int[alphabetLength][strLength + 1];로 선언을 해둔부분에서 +1하고있는 이유의 예시를 아래에서 설명한다.
			 * arr[iIndex][0] 은 무조건 0이다. arr[iIndex][1] 부터 input 문자열(str) 누적합 값이 할당되어 있음
			 * arr[iIndex][0]을 무조건 0으로 둔 이유는
			 * 예를들어 알파벳 a가 출현한 정보를 가지고 있는 누적합 1차원배열 testArr값이 있다고 하고, 이 배열값이 {1, 1, 1, 1, 2, 2}일 경우에
			 * testArr[0] = 1
			 * testArr[1] = 1
			 * testArr[2] = 1 이다.
			 * 그런데 testArr[1] 부터 testArr[3]까지 a가 출현한 횟수를 구하려면
			 * testArr[3] - testArr[1 - 1] (== testArr[0])을 구해주어야 하는데 이게만약에
			 * testArr[0] 부터 testArr[3]까지 a가 출현한 횟수를 구하라고 하면
			 * testArr[3] - testArr[0 - 1] (== testArr[-1])을하면서 인덱스를 벗어나게된다.
			 * 따라서 계산을 용이하게 하기위해서 testArr 배열 맨 앞에 버퍼를 두기위해 0으로 채워둔것임.
			 */
			sb.append(arr[iIndex][endIdx+1] - arr[iIndex][startIdx]).append("\n");
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}