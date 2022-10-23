/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1620
 	문제번호 : 1620
 	알고리즘 : 자료구조, 해시를 사용한 집합과 맵
*/
package Step_13_집합과맵.a1620_나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

	// String 파라미터가 숫자로 변환가능하면 return true, 숫자로 변환 불가능하면 return false
	public boolean isNumber(String _str) {
		char zero = '0';
		char nine = '9';

		for(char c : _str.toCharArray()) {
			if(c >= zero && c <= nine) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 포켓몬 이름 - 도감번호(입력순서 번호임) map을 쓸건데
	 * 도감번호로 포켓몬이름을 찾아야하는 상황도 있으므로
	 * 애초에 map을 두개만들어 쓰자. (key:포켓몬, value:도감번호 / key:도감번호, value:포켓몬)
	 */
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashMap<String, Integer> map1 = new HashMap<>();	// key : 포켓몬이름, value : 도감번호
		HashMap<Integer, String> map2 = new HashMap<>();	// key : 도감번호, value : 포켓몬이름

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String line = "";
		for(int i = 1; i <= N; i++) {
			line = br.readLine();
			map1.put(line, i);
			map2.put(i, line);
		}

		for(int i = 0; i < M; i++) {
			line = br.readLine();
			if(main.isNumber(line)) {	// input값이 숫자의 형태면
				bw.write(map2.get(Integer.parseInt(line)) + "\n");	// map2에서 꺼냄
			} else {					// input값이 문자의 형태면
				bw.write(map1.get(line) + "\n");	//map1에서 꺼냄
			}
		}

		br.close();
		bw.flush();
		bw.close();

	}
}