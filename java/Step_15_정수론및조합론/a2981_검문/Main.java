/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2981
 	문제번호 : 2981
 	알고리즘 : 수학, 정수론, 유클리드 호제법
*/
package Step_14_정수론및조합론.a2981_검문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {

	/**
	 * =========================================================================
	 * 
	 * 일단 유클리드호제법을 이해해야함.
	 * 유클리드 호제법은 GCD(a,b) = GCD(b,r)을 의미하는데 (여기서 GCD(a,b)는 a와b의 최대공약수(GCD)를 의미함)
	 * 예를들어 581, 322라는 수가 있을때 두수의 나머지 r = 259임.
	 * 따라서 유클리드 호제법에 의해 GCD(581,322) = GCD(322,259)라는 의미인데 왜그런지 간단하게 증명하는식을 정리해보면
	 * 두수 A,B 가있을때 A가 B보다크고 A % B = r 이라고할때 A = Bq + r로 나타낼 수 있음 (나머지정리와 동일한 형태임)
	 * 그리고 A와 B의 최대공약수를 d라고 한다면 A=ad, B=bd로 나타낼 수 있음. 그리고 a와 b는 자연스럽게 서로소임. (서로소가 아니여서 약수를 동시에 가지고 있다면 d값이 다시 변할것임)
	 * 위에서 A = Bq + r 이라고 했기 때문에, 이항하면 r = A - Bq를 얻을 수 있음
	 * 여기서 A = ad, B = bd로 표현할 수 있기때문에
	 * r = ad - bdq 로 나타낼 수 있고 r = d(a - bq)로 묶을 수 있음
	 * B = bd 이고, r = (a - bq)d 이기때문에 B와 r은 공통된약수 d를 갖고있음.
	 * 다시말해 d 는 B와r의 공약수라는 의미임. 위 식에서 공약수 d를 제거한 b와 (a - bq)가 서로소라면 공약수 d는 "최대공약수"임을 알 수 있음.
	 * b와 (a - bq)가 서로소임을 증명하기 위해서는 귀류법으로 증명이 가능한데
	 * b와 (a - bq)가 서로소가 아니라고 가정하고, 모순을 찾아내면 됨
	 * b와 (a - bq)가 서로소가 아니라는 의미는, 두 수는 공약수를 갖고 있다는 의미가 되기때문에 두수의 공약수를 p라고 두면
	 * b = mp, (a - bq) = np 로표현할 수 있음.
	 * b = mp라고 했기 때문에[ (a - bq)를 (a - mpq)로 표현 할 수 있음
	 * 따라서 (a - mpq) = np이고 이항하면 a = np + mpq임.
	 * 여기서 p로 묶으면 a = (n + mq)p 가 됨.
	 * a = (n + mq)p 이고 b = np로 표현 할 수 있다고 했기 때문에 결과적으로 a와 b는 p를 공약수로 갖기때문에 처음의 가정이 모순됨을 알 수 있음.
	 * 따라서 공약수 d는 최대공약수가 증명 되었기 때문에
	 * d는 B와 r의 공약수라고 했으니, d는 최대공약수 이므로, GCD(A,B) = GCD(B,r)또한 만족함을 알 수 있음. 이게 유클리드 호제법임
	 * 
	 * 참고사이트 : https://st-lab.tistory.com/154#algorithm ([백준] 2609번 : 최대공약수와 최소공배수 - JAVA [자바])
	 * 
	 * =========================================================================
	 * 
	 * 이제 본론이었던, 검문 문제를 풀어볼건데 
	 * 일단 두 수 A, B가 있다고 할때 나머지 정리에 의해서
	 * A = Ma + r1 이고 B = Mb + r2로 표현 할 수 있음. 따라서 뺄셈을 해주게 되면
	 * A - B = (Ma + r1) - (Mb + r2) 이고
	 * A - B = Ma - Mb - r1 + r2 이고
	 * A - B = M(a - b) + (r2 - r1)임을 알 수 있음. 근데 여기서 나머지들이 같은 M을구하는 문제기 때문에 나머지는 같고, 따라서 r2 - r1 은 0임.
	 * 그럼 A - B = M(a - b)로 표현할 수 있는데. 이게 뭘의미 하냐면.
	 * 위의 식은 처음 A, B를 두고 도출한 과정이기 때문에
	 * A - B = M(a - b)라고했고 이 A와 B 두 수를 뺀값인 A - B 는 M이라는 공통 약수를 갖는다는 것을 의미함 (a - b)가 무슨값인지는 몰라도되고.
	 * 따라서 문제룰 풀기위해서는 공약수 M의 리스트들을 찾으면 됨.
	 * 근데 A와 B의 공약수 M의 리스트를 구한다는 것은, A와 B의 "최대공약수"를 찾고 그 "최대공약수"의 약수를 구하면 된다는 의미와 동일함.
	 * 모든 input값들의 최대공약수를 구하기 위해서는
	 * inputArr[1] - inputArr[0]과 inputArr[2] - inputArr[1]의 최대공약수를 먼저 구하고
	 * 위에서 구한 최대공약수와 inputArr[3] - inputArr[2]의 최대공약수를 구하고
	 * 위에서 구한 최대공약수와 inputArr[4] - inputArr[3]의 최대공약수를 구하고
	 * ...
	 * 위에서 구한 최대공약수와 inputArr[n] - inputArr[n-1]의 최대공약수를 구하면
	 * 모든 input값의 최대공약수를 구할 수 있음.
	 * 그리고 이 값의 약수를 찾으면 문제 해결.
	 * 
	 * 참고사이트 : https://st-lab.tistory.com/155 ([백준] 2981번 : 검문 - JAVA [자바])
	 * 
	 * =========================================================================
	 */

	 
	// 최대공약수 구하는 메소드
	public int getGCD(int input1, int input2) {
		int mod = 0;
		while(true) {
			mod = input1 % input2;
			if(mod == 0) {
				break;
			}
			input1 = input2;
			input2 = mod;
		}
		return input2;
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];

		for(int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(inputArr);	// 정렬

		int gcdVal = inputArr[1] - inputArr[0];
		for(int i = 2; i < N; i++) {	// 모든 input의 최대공약수를 구함
			gcdVal = main.getGCD(gcdVal, inputArr[i] - inputArr[i-1]);
		}

		ArrayList<Integer> resultArr = new ArrayList<>();
		// 최대공약수인 gcdVal의 약수를 구해서 출력함.
		// 여기서 루프를 Math.sqrt(gcdVal)까지 도는 이유는 https://www.acmicpc.net/problem/9020문제 풀면서 주석 달았던 내용과 동일함.
		for(int i = 2; i <= Math.sqrt(gcdVal); i++) {
			if(i*i == gcdVal) {	// 두번넣는걸 방지하기위해 한번만 add해줌
				resultArr.add(i);
			}else if(gcdVal % i == 0) {
				resultArr.add(i);
				resultArr.add(gcdVal / i);
			}
		}
		Collections.sort(resultArr);	// 오름차순 정렬
		for(int v : resultArr) {
			sb.append(v).append(" ");	// 출력을위해 StringBuilder에 append
		}
		sb.append(gcdVal);

		bw.write(sb.toString());	// 출력
		br.close();
		bw.flush();
		bw.close();
	}
}