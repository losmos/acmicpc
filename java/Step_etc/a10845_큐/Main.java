/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/10845
 	문제번호 : 10845
 	알고리즘 : 자료 구조, 큐
*/
package Step_etc.a10845_큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public Queue<Integer> push(Queue<Integer> queue, int number) {
        queue.offer(number);
        return queue;
    }

    public int pop(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return -1;
        } else {
            int peek =  queue.peek();
            queue.poll();
            return peek;
        }
    }

    public int size(Queue<Integer> queue) {
        return queue.size();
    }

    public int empty(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }
    }

    public boolean back(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

	public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int last = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nextToken = st.nextToken();
            if(nextToken.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                main.push(queue, last);
            } else if (nextToken.equals("pop")) {
                sb.append(main.pop(queue)).append("\n");
            } else if (nextToken.equals("size")) {
                sb.append(main.size(queue)).append("\n");
            } else if (nextToken.equals("empty")) {
                sb.append(main.empty(queue)).append("\n");
            } else if (nextToken.equals("front")) {
                sb.append(main.front(queue)).append("\n");
            } else if (nextToken.equals("back")) {
                if(main.back(queue)) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(last).append("\n");
                }
            }

        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
	}
}