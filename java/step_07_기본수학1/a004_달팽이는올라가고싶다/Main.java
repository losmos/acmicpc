/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2869
 	문제번호 : 2869
 	알고리즘 : 수학
*/
package step_07_기본수학1.a004_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 반례(출력 : 맞는답)
	 * 	395271219 358589396 978208508
		17
		113567503 44910068 559112065
		8
		538983717 345864604 686576387
		2
		50482339 38379071 448269744
		34
		949090445 441184086 853233990
		1
		133893346 84406835 623602655
		11
		142389552 92341344 720292915
		13
		641225091 287278156 160391879
		1
		169992989 64774767 844145170
		8
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		double A = Double.parseDouble(st.nextToken());	// 낮에 올라갈수있는 거리 A
		double B = Double.parseDouble(st.nextToken());	// 밤되면 미끄러지는 거리 B
		double V = Double.parseDouble(st.nextToken());	// 올라가고자하는 목표 정상거리 C
		
		double targetV = V - A;	// 낮 A만큼을 뺀 거리. 즉 targetV만큼 도달한다음에. 다음날 낮에 A만큼 한번만 올라가면 정상도함.
		
		int day = (int)Math.ceil(targetV / (A-B)); 
		
		bw.write(String.valueOf(day + 1));
		
		bw.flush();
		bw.close();
	}
}
