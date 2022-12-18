/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2161
 	문제번호 : 2161
 	알고리즘 : 구현, 자료 구조, 큐
*/
package Step_etc.a2161_카드1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {   // queue에 1 ~ N까지의 숫자 push
            queue.offer(i);
        }

        while(true) {
            int card = queue.poll();    // 큐의 맨 앞에있는 값 반환 후 삭제
            sb.append(card).append(" ");
            if(queue.isEmpty()) {
                bw.write(sb.toString());
                break;
            } else {
                card = queue.peek();    // 큐의 맨 앞에있는 값 반환(삭제는 안함), 참고로 그냥 queue.poll로 해줘도 되지만 peek함수 사용해보려고 써봄
                queue.remove();         // 큐의 맨 앞에있는 값 삭제
                queue.offer(card);      // 큐 맨 뒤에 삽입
            }
        }

        br.close();
        bw.flush();
        bw.close();
	}
}