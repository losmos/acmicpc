/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2004
 	문제번호 : 2004
 	알고리즘 : 수학, 정수론
*/
package Step_14_정수론및조합론.a2004_조합0의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	/**
	 * [문제풀이 컨셉]
	 * 입력값 범위가 20억이기 때문에. 파스칼의 삼각형 + 숫자를 String으로 변환 하는방식을 활용하면 시간초과뜨거나 메모리 터질게 뻔한상황.
	 * 검색해서 찾아보니 소인수분해를 활용할 수 있었다.(요즘들어 수학적 지식이 많이 필요하다 느끼고있다)
	 * 그리고 양의정수는 소수의 곱으로 표현할 수 있음을 이미 알고 있다. 
	 * 1의 자리수가 0이라는건 10의배수라는거고. 10은 5와 2의 곱으로 표현할 수 있음(둘다 소수)
	 * 다시말해 어떠한 수를 소인수분해 했을 때 5의개수가 10개, 2의개수가 15개라면, 5*2의 조합을 10개만들수있고, 0의개수 또한 10개라는 의미와 같음.
	 * 이 문제에서 입력값을 일일이 소인수분해를 할수는 없고.
	 * (참고)조합공식 : nCr = n! / r! * (n-r)!  
	 * 조합 공식 특성상 5의배수의 숫자가 몇개인지 알아 낼 수 있다. 무슨말이냐면
	 * n! 에서 n이 24라면 24 * 23 * 22 * 21 * ... * 1 로 풀어낼 수 있고 여기서 5의배수는 20,15,10,5로 총 4개의숫자가 5의배수로 존재한다고 알 수 있음.
	 * 그럼 이 20,15,10,5를 소인수분해 해서 최종적인 5의개수, 2의개수를 구해내면된다. (근데 사실 2의개수는 안구해도되고 5의개수만 구해서 계산해도된다)
	 * (2의개수는 5의개수보다 많을수 밖에 없음. 짝수하나만 소인수분해해도 2의 소인수가 쏟아져나올것이기 때문에 ㅎㅎㅎ)
	 * 
	 * (추가+) 5의개수가 2의개수보다 항상 작을거라 생각했는데 반례가 있네. 2의 개수도 구해줘야됨.
	 * 반례 :5C1, 5C4
	 */

	
	// 파라미터 _number를 소인수분해 했을때 5의 개수를 return하는 개념
	public int get5Count(int _number) {
		int count = 0;

		while(_number >= 5) {
			count += _number / 5;
			_number /= 5;
		}
		return count;
	}

	// 파라미터 _number를 소인수분해 했을때 2의 개수를 return하는 개념
	public int get2Count(int _number) {
		int count = 0;

		while(_number >= 2) {
			count += _number / 2;
			_number /= 2;
		}
		return count;
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());


		// 조합공식 : nCr = n! / r! * (n-r)!
		int count5 = main.get5Count(n) - main.get5Count(r) - main.get5Count(n-r); 
		int count2 = main.get2Count(n) - main.get2Count(r) - main.get2Count(n-r);

		bw.write(String.valueOf(Math.min(count5, count2)));
		br.close();
		bw.flush();
		bw.close();
	}
}