/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/15595
 	문제번호 : 15595
 	알고리즘 : 구현
*/

package Step_etc.a15595_정답비율계산하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		Map<String, Boolean> correctUsers = new HashMap<>();
		Map<String, Integer> submitCounts = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			st.nextToken();				// 채점 번호
			String id = st.nextToken(); // 유저 아이디
			if(id.equals("megalusion")) {
				continue;
			}

			int result = Integer.parseInt(st.nextToken());	// 채점 결과

			if(result == 4) {	// 맞았습니다!!

                if(correctUsers.get(id) == null) {  // 한번에 맞았을 경우
                    correctUsers.put(id, true);	
                    submitCounts.put(id, 1);
                }

                if(!correctUsers.get(id)) { // 틀리다가 최초로 맞았을경우
                    correctUsers.put(id, true);	
                    if(submitCounts.get(id) != null) {
                        submitCounts.put(id, submitCounts.get(id) + 1);
                    } else {
                        submitCounts.put(id, 1);
                    }
                }
					
			} else {
                if(submitCounts.get(id) == null) {  // 처음제출이 틀렸을 경우
                    correctUsers.put(id, false);
                    submitCounts.put(id, 1);
                } else if(correctUsers.get(id)) {   // 이미 맞은상태에서 제출 했을 경우
                    // Nothing
                    continue;
                } else {    // 한번도 맞은적이 없고, 틀렸을경우
                    submitCounts.put(id, submitCounts.get(id) + 1);
                }

			}
		}

        int numerator  = 0;     // 분자
        int denominator = 0;    // 분모
        for (String key : correctUsers.keySet()) {
            if(correctUsers.get(key)) {
                numerator += 1;
                denominator += submitCounts.get(key);
            }
        }


		br.close();
		if(numerator == 0) {
			bw.write(0 + "");
		} else {
			bw.write(((double)numerator / (double)denominator)*100 + "");
		}
		bw.flush();
		bw.close();
	}
}