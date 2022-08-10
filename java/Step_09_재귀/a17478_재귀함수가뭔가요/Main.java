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

	public String getStr() {
		String rStr = "\"재귀함수가 뭔가요?\n\"";
		rStr += "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
		rStr += "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
		rStr += "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

		return rStr;
	}

	public String whatIsRecursive(String _str, int _nowIndex, int _targetIndex) {
		if(_nowIndex == _targetIndex)	// 입력값 n에도달하면 _preVal1 값 return
		{
			return _str;
		}
		_str = 

		whatIsRecursive(_str, _nowIndex + 1, _targetIndex);
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String result = main.whatIsRecursive(main.getStr(), n);		// 교수님 재귀에 빠져보자!

		// bw.write(String.valueOf(result));
		// bw.flush();
		// bw.close();
	}
}