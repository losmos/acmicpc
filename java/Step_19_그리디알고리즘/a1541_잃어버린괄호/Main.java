/*
문제출처 : BACKJOON, https://www.acmicpc.net/problem/1541
문제번호 : 1541
알고리즘 : 수학, 문자열, 그리디 알고리즘, 파싱
*/

package Step_19_그리디알고리즘.a1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 55-50+40 의 최소값은
 * 55-(50+40)으로 만들 수 있다.
 * 따라서 최초로오는 '-' 부호뒤에오는 모든 숫자를 더해주고 음수값으로 취급해주면된다.
 * 
 * 예를들어서 55-50+40-40+40-30+15-20 와 같은 문제가 주어졌을때
 * 55-(50+40)-(40+40)-(30+15)-20 해주면 가장 최소값을 구할 수 있다.
 * 따라서 처음에오는 마이너스부호, 그 뒤에오는 모든 정수는 다 음수로 취급해줘도 무방함.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;

		int tokenizedCnt = 0;	// StringTokenizer로 자른 토큰개수
		int plusSum = 0;	// 양수값의 합
		int minusSum = 0;	// 음수값의 합
		
		st1 = new StringTokenizer(br.readLine(), "-");	// '-' 문자기준으로 자른다.
		while(st1.hasMoreTokens()) {
			st2 = new StringTokenizer(st1.nextToken(), "+");	// 다시 '+' 기준으로 자른다.
			while(st2.hasMoreTokens()) {
				if(tokenizedCnt > 0) {	// 만족한다면 무조건 음수취급해버리면 된다.
					minusSum += Integer.parseInt(st2.nextToken());
				} else {
					plusSum += Integer.parseInt(st2.nextToken());
				}
			}
			tokenizedCnt++;	// '-'문자기준으로 처음자르고오는 token 문자열은 양수값이지만. 그다음부터는 모두 음수값으로 취급하는 기준이 될 tokenized 횟수
		}

		br.close();
		bw.write(plusSum - minusSum + "");
		bw.flush();
		bw.close();
	}
}