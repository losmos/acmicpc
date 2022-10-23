/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11478
 	문제번호 : 11478
 	알고리즘 : 자료구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
*/
package Step_12_집합과맵.a11478_서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Main {

	/**
	 * 문자열 입력받고. 모든 부분집합(부분문자열)을 구하면서 map에 put해줌. 그럼 자동으로 중복제거됨
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Boolean> map = new HashMap<>();

		sb.append(br.readLine());

		// input의 모든 부분문자열을 출출해서 map에 put해줌
		/*
		StringBuilder getStr = new StringBuilder();
		for(int i = 0; i < sb.length()-1; i++) {
			for(int j = 0; j < sb.length() - i; j++) {
				for(int k = j; k <= i+j; k++) {
					getStr.append(Character.toString(sb.charAt(k)));
				}
				map.put(getStr.toString(), true);
				getStr.delete(0, getStr.length());
			}
		}
		*/

		// 위에 주석한 for문인, charAt으로 뽑고 String으로 변환하는게 속도가 많이 느린듯.
		// substring쓰는걸로 바꿔봄
		for(int i = 0; i < sb.length()-1; i++) {
			for(int j = 0; j < sb.length() - i; j++) {
				map.put(sb.substring(j, i+j+1), true);
			}
		}

		// 출력
		bw.write(String.valueOf(map.size() + 1));	// 부분문자열은 입력했던 전체문자열도 포함인데, 위에 for문은 전체문자열을 제외한 부분문자열만 검사하였으므로 최종적으로 +1 해줌

		br.close();
		bw.flush();
		bw.close();
	}
}