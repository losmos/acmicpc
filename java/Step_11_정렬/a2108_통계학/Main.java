/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2108
 	문제번호 : 2108
 	알고리즘 : 수학, 구현, 정렬
*/
package Step_11_정렬.a2108_통계학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SortInfo {
	int avg;	// 산술평균
	int median;	// 중앙값
	int mode;	// 최빈값
	int range;	// 범위
	int[] sortedArr;	// 최종적으로 sorting된 결과를 담을 배열
}

class Main {

	 /**
	  * @param _inputNumbers	: 정렬해야될 input 배열
	  * @param _si				: 문제의 최종결과를 담을 변수와, _inputNumbers가 정렬완료된 배열 sortedArr을 가지고있는 클래스
	  * @param _max				: input값중 max값. countingArr 초기화할때 쓰임.
	  * @return
	  */
	public SortInfo countingSort(int[] _inputNumbers, SortInfo _si, int _max) {
		int[] countingArr = new int[_max + 1];	//값과 주소값을 1:1매핑할거기때문에. +1해줘야됨
		// Step03에해당 하는 로직 수행
		for(int i = 0; i < _inputNumbers.length; i++)  {
			countingArr[_inputNumbers[i]]++;
		}


		int mode = 8001, secondMode = 8001;	// 최빈값, second 최빈값
		int modeCnt = 0, secondModeCnt = 0;	// 최빈값 출현횟수, second 최빈값 출현횟수
		// 최빈값 구하는 loop
		for(int i = 0; i < countingArr.length; i++)  {
			if(countingArr[i] != 0 && countingArr[i] >= modeCnt) {	// i의 counting값이 최빈값보다 많거나 같을 때
				if(countingArr[i] == modeCnt) {	// 최빈값과 출현횟수가 같을때
					if (countingArr[i] > secondModeCnt || i < secondMode) {	// 두번째최빈값보다 출현횟수가 더 많거나 || 기존 second최빈값보다는 값이 작은경우
						secondMode = i;
						secondModeCnt = countingArr[i];
					}
				} else if (countingArr[i] > modeCnt){	// 최빈값 갱신조건
					mode = i;					// 최빈값 갱신
					modeCnt = countingArr[i];	// 최빈값의 출현횟수 갱신
				}
			}
		}
		if(modeCnt > secondModeCnt) {
			_si.mode = mode;
		} else {
			_si.mode = secondMode;
		}

		// Step04에 해당하는 로직 수행
		for(int i = 0; i < countingArr.length - 1; i++) {
			countingArr[i+1] = countingArr[i] + countingArr[i+1];
		}

		// Step05에해당 하는 로직 수행
		for(int i = 0; i < _inputNumbers.length; i++)  {
			_si.sortedArr[countingArr[_inputNumbers[i]]-1] = _inputNumbers[i];
			countingArr[_inputNumbers[i]]--;
		}

		return _si;
	}

	/*
	 * 카운팅 정렬로 풀건데, 입력값중에 음수값이있으므로. 카운팅배열 선언할때 가장최소 음수값만큼 + 해줘서 index값을 보정해줄것임.
	 * 예를들면 입력값중에 max가 1000일경우 카운팅정렬 length도 1000짜리를 만들어주지만, 음수값이 -100이 있을경우, +100만큼 보정해서 -100과 매핑되는 주소값이 0이될수 있도록 해줌
	 * 그외는 특이사항 없음. 출력할 때 보정값 감안해서 원래대로 출력 해주면 됨.
	 */
	public static void main(String[] args) throws IOException{
		SortInfo si = new SortInfo();
		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] inputNumbers = new int[N];
		si.sortedArr = new int[N];

		double sum = 0;
		int max = 0;	// 정렬하고자하는 값중 제일 큰값
		int min = 0;	// 정렬하고자 하는 값중 제일 작은 값(음수값 넣을거임)

		for (int i = 0; i < N; i ++) {
			inputNumbers[i] = Integer.parseInt(br.readLine());
			if (inputNumbers[i] > max) {	// input 받는김에 for문돌면서 max값도 미리 구해둠
				max = inputNumbers[i];
			}

			if(inputNumbers[i] < 0 && inputNumbers[i] < min) {	// input값이 음수이면서 제일 작은수라면
				min = inputNumbers[i];
			}

			sum += inputNumbers[i];
		}

		si.avg = (int)Math.round(sum / N);
		int correctionValue = 0;
		if(min < 0 ) {	// 음수값이 있다면
			correctionValue = Math.abs(min);
			max = max + correctionValue;	// 음수만큼 더하기해서 보정함. max값을 늘려줌.
			for(int i = 0; i < inputNumbers.length; i++) {
				inputNumbers[i] += correctionValue;	// 모든 input값에 보정값을 더해줌
			}
		}
		si = main.countingSort(inputNumbers, si, max);

		if(inputNumbers.length == 1) {
			si.range = 0;
		} else {
			si.range = si.sortedArr[N-1] - si.sortedArr[0];
		}

		int mid = N / 2;

		// 출력
		bw.write(si.avg + "\n");								// 산술평균
		bw.write(si.sortedArr[mid] - correctionValue + "\n");	// 중앙값
		bw.write(si.mode - correctionValue + "\n");				// 최빈값
		bw.write(si.range + "\n");								// 범위


		br.close();
		bw.flush();
		bw.close();
	}
}