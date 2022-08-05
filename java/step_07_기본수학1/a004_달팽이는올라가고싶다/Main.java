/*
 	������ó : BACKJOON, https://www.acmicpc.net/problem/2869
 	������ȣ : 2869
 	�˰��� : ����
*/
package step_07_�⺻����1.a004_�����̴¿ö󰡰�ʹ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	/*
	 * �ݷ�(��� : �´´�)
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
		
		double A = Double.parseDouble(st.nextToken());	// ���� �ö󰥼��ִ� �Ÿ� A
		double B = Double.parseDouble(st.nextToken());	// ��Ǹ� �̲������� �Ÿ� B
		double V = Double.parseDouble(st.nextToken());	// �ö󰡰����ϴ� ��ǥ ����Ÿ� C
		
		double targetV = V - A;	// �� A��ŭ�� �� �Ÿ�. �� targetV��ŭ �����Ѵ�����. ������ ���� A��ŭ �ѹ��� �ö󰡸� ������.
		
		int day = (int)Math.ceil(targetV / (A-B)); 
		
		bw.write(String.valueOf(day + 1));
		
		bw.flush();
		bw.close();
	}
}
