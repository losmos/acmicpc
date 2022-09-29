/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2164
 	문제번호 : 2164
 	알고리즘 : 자료 구조, 큐
*/
package Step_etc.a2164_카드2;

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

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {   // queue에 1 ~ N까지의 숫자 push
            queue.offer(i);
        }

        while(true) {
            int peek = queue.peek();
            queue.poll();
            if(queue.isEmpty()) {
                bw.write(String.valueOf(peek));
                break;
            } else {
                peek = queue.peek();
                queue.remove();
                queue.offer(peek);
            }
        }

        br.close();
        bw.flush();
        bw.close();
	}
}