/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1912
 	문제번호 : 1912
 	알고리즘 : 다이나믹 프로그래밍
*/
package Step_16_동적계획법1.a1912_연속합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [문제풀이 컨셉]
 * 14
 * 1 3 -5 10 -4 3 1 5 6 -3 12 21 -1 -5
 *    ↑(idx start point)        ↑(idx end point)
 * 1 + 3 까지는 숫자의 합이 증가하지만, 세번째 수인 -5를 더하는 순간 0보다 작아짐.
 * 그렇다는 의미는, 임의의 중간지점에서 부터 값을 왼쪽방향으로 더해간다고 했을 때, -5를 넘어서까지 더할필요가 없단 의미임.
 * (오른쪽에서 왼쪽방향으로) -5를 더해서 지금 당장 숫자의 합이 감소했더라도, 그 이후 숫자의 합으로 인해 -5를 커버할만큼 누적 합계가 늘어날 수 있다면 계속해서 더해가도 되지만, 그렇지 않기 때문.
 * 그렇단즉슨, 왼쪽부터 오른쪽방향으로 숫자를 더해가며 진행할 때, 숫자의 합이 0보다 작아지는 시점이 온다면, 그 기점부터 왼쪽방향범위의 합은 음수값이기 때문에
 * 그기점 다음 index부터 (index startpoint)를 지정해주고, sum =0 부터 초기화하여 새롭게 더해가며 검사해도 된다는 뜻.
 * 
 * 위 테스트 케이스를 예를들어 보면
 * 1, 3, -5 더했으나 음수가 됐기 때문에 10부터 시작해서 오른쪽방향으로 10, -4, 3, 1, 5, 6, -3, 12, 21, -1, -5까지 더해 줄 수 있음
 * but, 맨 뒤쪽 -1, -5값을 더하더라도 숫자의 총합이 음수로 전환되지는 않지만 음수를 더하면서 max값은 더이상 아니게 됨.
 * 따라서 매번 숫자를 더할때마다 max값을 갱신할 수 있는지 체크 해가면서 max값이 갱신된다면 (idx end point)를 지정해주고, max값을 따로 보관해야함.
 * 
 * 참고)위 컨셉에서는 idx start point와 idx end point를 지정해주는 식으로 설명했지만
 * 실제로 index값까지 보관할 필요는 없고, sum값에대한 max값만 따로 계산하여 갖고있으면 됨.
 */

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		st = new StringTokenizer(br.readLine());
		
		input[0] = Integer.parseInt(st.nextToken());
        int sum = 0;		// input[0]이 음수일경우는 0으로 초기화해줘도됨. 음수값끼리는 더하는게 의미 없기때문. 가장 큰 음수값 한개가. max가 될 수 있음. 
        if(input[0] > 0) {	
            sum = input[0];
        }
		
		int max = input[0];
		for(int i = 1; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());	// input에 값 저장
			sum += input[i];								// 동시에 sum값 계산
			
			if(sum > max) {		// max 갱신조건
				max = sum;
			}
			
			if(sum < 0) {	// sum이 음수가된다면. 0으로 초기화 (맨 위 문제풀이 컨셉 참고)
				sum = 0;
			}
		}
		
		br.close();
		bw.write(max + "");
		bw.flush();
		bw.close();
	}	
}