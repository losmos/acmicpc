/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/17478
 	문제번호 : 17478
 	알고리즘 : 구현, 재귀
*/
package Step_09_재귀.a17478_재귀함수가뭔가요;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	// 반복될 교수님 말씀
	public String[] getStr() {
		String[] rStr = new String[6];
		rStr[0] = "\"재귀함수가 뭔가요?\"";
		rStr[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		rStr[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		rStr[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		rStr[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		rStr[5] = "라고 답변하였지.";

		return rStr;
	}

	// 1차 재귀함수 run && 출력
	public String whatIsRecursive(String[] _rStr, int _targetIndex) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if(_targetIndex == 0)	// 입력값 n에도달하면 값 return
		{
			bw.write(_rStr[0]+'\n');
			bw.write(_rStr[4]+'\n');
			bw.flush();
			return _rStr[5];
		}

		for(int i=0; i< 4; i++)
		{
			bw.write(_rStr[i]+'\n');
			bw.flush();
		}
		
		_rStr[0] = "____" + _rStr[0];
		_rStr[1] = "____" + _rStr[1];
		_rStr[2] = "____" + _rStr[2];
		_rStr[3] = "____" + _rStr[3];
		_rStr[4] = "____" + _rStr[4];
		_rStr[5] = "____" + _rStr[5];

		return whatIsRecursive(_rStr, _targetIndex-1);
	}

	// 라고 답변하였지. 재귀로 출력하면서 마무리
	public void outputLastStr(String _str, int n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(_str+'\n');
		bw.flush();

		_str = _str.substring(4, _str.length());	// 맨앞 ____ 잘라서 없앰
		
		if(n == 0) {	// 재귀 종료조건
			return;
		}
		
		outputLastStr(_str, n-1);
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");	// 교수님 훈화말씀 start
		bw.flush();

		String result = main.whatIsRecursive(main.getStr(), n);		// 교수님 재귀에 빠져보자!
		main.outputLastStr(result, n);

		bw.close();
	}
}