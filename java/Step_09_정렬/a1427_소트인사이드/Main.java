/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1427
 	문제번호 : 1427
 	알고리즘 : 문자열, 정렬
*/
package Step_11_정렬.a1427_소트인사이드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {

	public String countingSort(String _line) {
		StringBuilder sb = new StringBuilder();
		String[] strArray = _line.split("");	// 입력된 문자열을 한글자씩 잘라서 String 배열에 넣음
		int[] countingArr = new int[10];

		// 카운팅정렬 하듯이 strArray값 하나하나 검사하며 counting 해줌
		for(int i = 0; i < strArray.length; i++) {
			countingArr[Integer.parseInt(strArray[i])]++;
		}


		// 어차피 입력값의 범위는 0~9 이고, 내림차순 정렬이 문제이므로 뒤에서부터 counting 수만큼 sb.append 해줌
		for(int i = 9; i >= 0; i--)  {
			for(int j = 0; j < countingArr[i]; j++) {
				sb.append(String.valueOf(i));
			}
		}

		return sb.toString();
	}

	/*
	 * 입력숫자범위가 0~9라서 카운팅정렬 응용해서 쓰기 적합할듯
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();

		bw.write(main.countingSort(line));

		br.close();
		bw.flush();
		bw.close();
	}
}