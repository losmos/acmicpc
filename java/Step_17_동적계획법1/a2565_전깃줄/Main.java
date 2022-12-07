/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2565
 	문제번호 : 2565
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_17_동적계획법1.a2565_전깃줄;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * A-B가 연결되어있을 때. 예를들어 a[1] -- b[8]이 연결되어있을 때 
 * a[i] -- b[j] 가 연결되어있다면, 여기서  교차되는 전기줄의 조건은
 * i > 1 && j < 8 또는
 * a < 1 && j > 8 인 경우이다.
 * 즉 i가 1보다 크면, j는 8보다 작아야되고
 * i가 1보다 작으면, j는 8보다 커야만, 전깃줄이 교차된다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	}
}