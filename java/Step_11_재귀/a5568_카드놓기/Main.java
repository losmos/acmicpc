/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/5568
 	문제번호 : 5568
 	알고리즘 : 자료 구조, 브루트포스 알고리즘, 해시를 사용한 집합과 맵, 재귀
*/
package Step_11_재귀.a5568_카드놓기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * [문제풀이 컨셉]
 * nArr에 카드숫자를 입력하고, k개수만큼 뽑아서 이어붙였을때 완성되는 숫자의 조합개수를 찾으면 됨.
 * visited[n] 만큼을 만들어서 dfs태우면될듯.
 * 완성된 숫자는 StringBuilder 로만든다음에 Integer.parseInt로 변환해서 맵에 저장하면 될듯함.
 */

class CardInfo {
	int n;
	int k;
	int[] nArr;	// 카드숫자 list
	boolean[] visited;	// dfs 방문여부 
	int[] pickedCard;	// 선택한카드
	int pickedCardIdx = 0;	//pickedCard의 index pointer
	StringBuilder sb = new StringBuilder();	// pickedCard[] -> sb에 담아서 최종적으로 Integer.parseInt로 변환할 용도
	Map<Integer, Boolean> map = new HashMap<>();	// 최종숫자 담을 map

	CardInfo(int n, int k) {
		this.n = n;
		this.k = k;
		nArr = new int[n];
		pickedCard = new int[k];
		visited = new boolean[n];
	}
}

public class Main {

	public void dfs(CardInfo cardInfo, int nowDepth) {
		if(nowDepth == cardInfo.k) {
			cardInfo.sb.delete(0, cardInfo.sb.length());
			for(int i = 0; i < cardInfo.k; i++) {
				cardInfo.sb.append(cardInfo.pickedCard[i]);
			}

			cardInfo.map.put(Integer.parseInt(cardInfo.sb.toString()), true);
			return;
		}

		for(int i = 0; i < cardInfo.n; i++) {
			if(!cardInfo.visited[i]) {
				cardInfo.visited[i] = true;
				cardInfo.pickedCard[cardInfo.pickedCardIdx] = cardInfo.nArr[i];
				cardInfo.pickedCardIdx++;
				dfs(cardInfo, nowDepth+1);
				cardInfo.visited[i] = false;
				cardInfo.pickedCardIdx--;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		CardInfo cardInfo = new CardInfo(n, k);

		for(int i = 0; i < n; i++) {
			cardInfo.nArr[i] = Integer.parseInt(br.readLine());	
		}

		main.dfs(cardInfo, 0);

		bw.write(cardInfo.map.size() + "");
		br.close();
		bw.flush();
		bw.close();
	}
}