/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/14584
 	문제번호 : 14584
 	알고리즘 : 문자열, 브루트포스 알고리즘
*/
package Step_etc.a14584_암호해독;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * [문제풀이 컨셉]
 * 입력된 암호화 문자열에서 주어진 단어의 offset 패턴이 일치하는 구간을 찾는다.
 * 01. 일치하는 패턴이 한군데라면 다음단어를 찾지 않고 바로 복호화를 시도한다. (offset 패턴이 일치하는 구간이 유니크하게 1곳이면, 그 offset 차이를 계산해서 복호화 해주면 된다.)
 * 02. 일치하는 패턴이 두군데 이상이지만, 일치하는 패턴 문자가 두군데 모두 같다면 복호화를 시도한다.
 * 일치하는 패턴이 두군데 이상이고, 일치하는 패턴문자가 서로 다 다를경우에는 다음단어를 검색한다.
 */
public class Main {

	public int matchWord(char[] input, char[] word, int[] inputOffset, int[] wordOffset) {
		StringBuilder prevMatchedWord = null;
		StringBuilder nowMatchedWord = null;
		int matchingCnt = 0;	// 암호화문자열에서 문자의 offset 매칭이 일치한 횟수
		int offset = -1;

		outer: for(int i = 0, range1 = inputOffset.length - wordOffset.length; i <= range1; i++) {
			for(int j = 1, range2 = wordOffset.length; j < range2; j++) {
				if(inputOffset[i+j] == wordOffset[j]) {
					if(j == range2 - 1) {	// 단어의 모든 offset과 일치할 경우
						offset = (word[j] - input[i+j] + 26) % 26;	// 알파벳 개수 26개이므로
						nowMatchedWord = new StringBuilder();
						for(int k = 0; k < range2; k++) {
							nowMatchedWord.append(input[i+k]);
						}

						if(matchingCnt > 0) {	// 암호화 문자열에서 문자의 offset 매칭이 일치하는 구간이 2군데 이상이면서
							if(!prevMatchedWord.toString().equals(nowMatchedWord.toString())) {	// 그 두 구간의 문자가 똑같지 않을 경우
								return -1;	// 다음 문자를 검색하기위해 return 해준다.
							}
						}

						prevMatchedWord = new StringBuilder(nowMatchedWord);
						matchingCnt++;
					}
				} else {
					continue outer;
				}
			}
		}

		return offset;
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();
		int[] inputOffset = new int[input.length];

		for(int i = 1, range = input.length; i < range; i++) {
			inputOffset[i] = ((input[i] - input[i-1] + 26) % 26);
		}

		int N = Integer.parseInt(br.readLine());
		int offset = 0;
		for(int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			int[] wordOffset = new int[word.length];

			for(int j = 1, range = word.length; j < range; j++) {
				wordOffset[j] = ((word[j] - word[j-1]) + 26) % 26;
			}

			offset = main.matchWord(input, word, inputOffset, wordOffset);
			if(offset != -1) {
				break;	// return code가 -1이 아니라면. 복호화를 성공한것이므로 break로 빠져나간다.
			}
		}

		br.close();
		for(int i = 0, range = input.length; i < range; i++) {
			if(input[i] + offset > 'z') {
				bw.write(((input[i] + offset) % 'z' - 1) + 'a');
			} else {
				bw.write(input[i] + offset);
			}
		}
		bw.flush();
		bw.close();
	}
}