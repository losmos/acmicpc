/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/11729
 	문제번호 : 11729
 	알고리즘 : 재귀
*/
package Step_09_재귀.a11729_하노이탑이동순서;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class HanoiStack {
	int[] stack;
	int top;		// pop 포인터 역할

	public HanoiStack(int _size) {
		stack = new int[_size];
	}

	// 최상단 블락 pop하고 그 block값 return
	public int pop() {
		int block = stack[--top];
		stack[top] = 0;
		return block;
	}

	// 블락 push
	public void push(int _param) {
		stack[top++] = _param;
	}
}

class HanoiTopInfo {
	HanoiStack[] hanoiStack;
	int fromIndex;	// '기준블락'이 있던 자리
	int nowIndex;	// '기준블락'의 현재 위치
	int size;		// 하노이 탑 블럭 개수
	int heavyIndex;	// '제일무거운 블락'이 위치한 Index 번호
	int heavyBlock;	// '제일무거운 블락'값

	int resultCount;
	StringBuilder result = new StringBuilder();
	
	// 생성자
	public HanoiTopInfo(HanoiStack[] hanoiStack, int fromIndex, int nowIndex, int size, int heavyIndex) {
		this.hanoiStack = hanoiStack;
		this.fromIndex = fromIndex;
		this.nowIndex = nowIndex;
		this.size = size;
		this.heavyIndex = heavyIndex;
		this.heavyBlock = size;
	}

	// 지정된 Index의 hanoiStack에서 최상단에있는 블락 값을 get함
	public int getTop(int _index) {
		if(hanoiStack[_index].top >= 1) {	// 해당 index에 블럭이있으면
			return hanoiStack[_index].stack[hanoiStack[_index].top - 1];
		} else {	// 블락이없는 빈공간이면
			return 0;
		}
	}

	// '기준블락'이 위치한 index에서 연속된블럭 개수가 홀수이면 return true, 짝수이면 return false
	public boolean getOddInfo() {
		int count = 1;
		boolean continueYn = false;
		for(int i = hanoiStack[nowIndex].stack.length -1 ; i>0; i--) {
			if( hanoiStack[nowIndex].stack[i] != 0 && (hanoiStack[nowIndex].stack[i] + 1 == hanoiStack[nowIndex].stack[i-1])) {
				count++;
				continueYn = true;	// 블럭이 연속되어있기 시작!
			} else {				// 근데 불연속적인게 나왔다?
				if(continueYn) {	// 그이후에 연속적인 블럭이 있더라도 카운팅해주면 안되므로 break (ex : 12378 블럭이 있다면 1.2.3 3개만 연속된걸로 카운팅해야함. 7.8 까지 연속되어있다고 카운팅해주면 안됨 )
					break;
				}
			}
		}

		if(count % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param _hanoiTopInfo
	 * @param _oddOrEven	: 홀수를 의미하는 odd를 넘겨받는다면 더작은 블락이 위치한 index를 return 함, 짝수를 의미하는 even값을 넘겨받는다면 더 큰 블락이 위치한 index값을 return함.
	 */
	// '기준블락'이 위치한 인덱스를 제외한 나머지 두개 인덱스의 맨상단에 블락중에서, 더 작거나 or 더 큰 블락이 위치한 index를 리턴
	// index값은 0,1,2 를 사용함
	public int getTargetIndex(HanoiTopInfo _hanoiTopInfo, String _oddOrEven) {
		int maxTop =0, maxIndex = 0;
		int minTop =21, minIndex = 3;	// 문제조건에의해서 minTop값은 size를 의미하는 20을 넘을 수없고, minIndex는 총 3칸을 이동하는문제이므로 3이상이 될 수 없음.

		for(int i=0; i<3; i++) {
			if(getTop(i) == 0 || i == _hanoiTopInfo.nowIndex) {	// 블락이 없거나, '기준블락'이 위치한 nowIndex를 제외한 나머지 두 Index에서 블락크기 비교할것이므로 continue
				continue;
			}

			if(getTop(i) > maxTop) {
				maxTop = getTop(i);
				maxIndex = i;
			}
			
			if (getTop(i) < minTop){
				minTop = getTop(i);
				minIndex = i;
			}
		}

		if(_oddOrEven.equals("odd")) {
			return minIndex;
		} else {	// if(_oddOrEven.equals("even"))
			return 3 - _hanoiTopInfo.nowIndex - minIndex;
		}
	}

	public void makeResult(int _fromIndex, int _toIndex) {
		result.append(_fromIndex+1).append(" ").append(_toIndex+1).append("\n");
		resultCount++;
	}
}

public class Main {

	// 최초 초기화
	public HanoiTopInfo initHanoiTop(int _size) {
		HanoiStack[] hanoiStack = new HanoiStack[3];
		hanoiStack[0] = new HanoiStack(_size);
		hanoiStack[1] = new HanoiStack(_size);
		hanoiStack[2] = new HanoiStack(_size);


		for(int i=0; i<_size; i++) {
			hanoiStack[0].stack[i] = _size -i;
		}

		hanoiStack[0].top = _size;

		return new HanoiTopInfo(hanoiStack, 0, 0, _size, 0);
	}

	// '제일무거운 블락'이 변경할 조건이라면 변경해주는 메소드
	public void modifyHeavyIndex(HanoiTopInfo _hanoiTopInfo) {
		int heavyBlock = 0;
		if(_hanoiTopInfo.heavyIndex == 2) {
			heavyBlock = _hanoiTopInfo.heavyBlock-1;	// '제일무거운 블락'을 하나더 작은 사이즈의 블락으로 변경
			_hanoiTopInfo.heavyBlock = heavyBlock;

			for(int i=0; i<2; i++) {
				for(int item : _hanoiTopInfo.hanoiStack[i].stack) {
					if(item == heavyBlock) {			// 변경할 '제일무거운 블락'의 위치를 찾았다면
						_hanoiTopInfo.heavyIndex = i;	// 해당index를 heavyIndex로 변경
						break;
					}
				}
			}
		}
	}

	// '제일무거운 블락'을 이동하는 메소드
	public HanoiTopInfo moveHeavyBlock(HanoiTopInfo _hanoiTopInfo) {
		int nowIndex = _hanoiTopInfo.nowIndex;
		int heavyIndex = _hanoiTopInfo.heavyIndex;
		int targetIndex = 0;
		int block = 0;
		int popIndex = 0;

		if(nowIndex == heavyIndex) {	// '제일무거운 블락'과 '기준블락'이 같은 Index에 있다면
			popIndex = _hanoiTopInfo.getTargetIndex(_hanoiTopInfo, "odd");
			targetIndex = 3 - nowIndex - popIndex;		// '기준블락'이 위치 Index 제외, pop한 Index 제외하고 남은 나머지 Index에 push
		}
		else {
			popIndex = heavyIndex;
			targetIndex = 3 - nowIndex - heavyIndex;	// '기준블락'이 위치 Index 제외, pop한 Index 제외하고 남은 나머지 Index에 push
		}

		if(_hanoiTopInfo.getTop(targetIndex) !=0 && _hanoiTopInfo.getTop(popIndex) > _hanoiTopInfo.getTop(targetIndex)) {	// pop은가능하지만 push할곳에 블락이 존재하고, 그블락이 작아서. 더큰 블락이push가 안되는경우
			// popIndex와 targetIndex를 서로 스위치해줌
			popIndex = targetIndex;
			targetIndex = 3 - nowIndex - popIndex;
		}

		block = _hanoiTopInfo.hanoiStack[popIndex].pop();
		_hanoiTopInfo.hanoiStack[targetIndex].push(block);
		if(_hanoiTopInfo.heavyBlock == block) {		// '제일무거운 블락'을 옮겼다면
			_hanoiTopInfo.heavyIndex = targetIndex;	// heavyIndex 변경
		}
		_hanoiTopInfo.makeResult(popIndex, targetIndex);

		return _hanoiTopInfo;
	}

	// 기준블락을 이동하는 메소드
	public HanoiTopInfo move3Blocks(HanoiTopInfo _hanoiTopInfo, int _nowIndex, int _targetIndex, int _elseIndex) {
		int block = _hanoiTopInfo.hanoiStack[_nowIndex].pop();
			_hanoiTopInfo.hanoiStack[_targetIndex].push(block);
			_hanoiTopInfo.makeResult(_nowIndex, _targetIndex);
			block = _hanoiTopInfo.hanoiStack[_nowIndex].pop();
			_hanoiTopInfo.hanoiStack[_elseIndex].push(block);
			_hanoiTopInfo.makeResult(_nowIndex, _elseIndex);
			block = _hanoiTopInfo.hanoiStack[_targetIndex].pop();
			_hanoiTopInfo.hanoiStack[_elseIndex].push(block);
			_hanoiTopInfo.makeResult(_targetIndex, _elseIndex);
			block = _hanoiTopInfo.hanoiStack[_nowIndex].pop();
			_hanoiTopInfo.hanoiStack[_targetIndex].push(block);
			_hanoiTopInfo.makeResult(_nowIndex, _targetIndex);
			block = _hanoiTopInfo.hanoiStack[_elseIndex].pop();
			_hanoiTopInfo.hanoiStack[_nowIndex].push(block);
			_hanoiTopInfo.makeResult(_elseIndex, _nowIndex);
			block = _hanoiTopInfo.hanoiStack[_elseIndex].pop();
			_hanoiTopInfo.hanoiStack[_targetIndex].push(block);
			_hanoiTopInfo.makeResult(_elseIndex, _targetIndex);
			block = _hanoiTopInfo.hanoiStack[_nowIndex].pop();
			_hanoiTopInfo.hanoiStack[_targetIndex].push(block);
			_hanoiTopInfo.makeResult(_nowIndex, _targetIndex);
			
			// targetIndex, nowIndex값 수정
			_hanoiTopInfo.nowIndex = _targetIndex;
			_hanoiTopInfo.fromIndex = _nowIndex;

			return _hanoiTopInfo;
	}

	// 하노이 탑 run
	public HanoiTopInfo run(HanoiTopInfo _hanoiTopInfo) {

		/*	하노이탑 현재상태 출력
		System.out.println("===========");
		for(int i=_hanoiTopInfo.hanoiStack[0].top-1; i>=0; i--) {
			System.out.println(_hanoiTopInfo.hanoiStack[0].stack[i]);
		}
		System.out.println("-----------");
		for(int i=_hanoiTopInfo.hanoiStack[1].top-1; i>=0; i--) {
			System.out.println(_hanoiTopInfo.hanoiStack[1].stack[i]);
		}
		System.out.println("-----------");
		for(int i=_hanoiTopInfo.hanoiStack[2].top-1; i>=0; i--) {
			System.out.println(_hanoiTopInfo.hanoiStack[2].stack[i]);
		}
		System.out.println("===========");
		 */

		if(_hanoiTopInfo.hanoiStack[2].stack[_hanoiTopInfo.size -1 ] == 1) {	// 탑을 다 옮겼다면 return
			return _hanoiTopInfo;
		}

		int nowIndex;
		int targetIndex;
		int elseIndex;

		// 최초 첫번째 call 일때
		if(_hanoiTopInfo.fromIndex == 0 && _hanoiTopInfo.nowIndex == 0) {
			
			if(_hanoiTopInfo.getOddInfo()) {	// '기준블락'이 위치한Index에서 '기준블락'을포함한 연속된 블락개수가 "홀수"개라면
				nowIndex = 0;
				targetIndex = 2;
				elseIndex = 1;
			} else {							// '기준블락'이 위치한Index에서 '기준블락'을포함한 연속된 블락개수가 "짝수"개라면
				nowIndex = 0;
				targetIndex = 1;
				elseIndex = 2;
			}
			
			//기준블럭 이동
			_hanoiTopInfo = move3Blocks(_hanoiTopInfo, nowIndex, targetIndex, elseIndex);

			run(_hanoiTopInfo);
		}
		else {	// 두번째 call 부터 진입

			_hanoiTopInfo = moveHeavyBlock(_hanoiTopInfo);	// '제일무거운 블락' 이동메소드 call
			modifyHeavyIndex(_hanoiTopInfo);				// '제일무거운 블락' 변경 메소드

			if(_hanoiTopInfo.getOddInfo()) {	// '기준블락'이 위치한Index에서 '기준블락'을포함한 연속된 블락개수가 "홀수"개라면
				nowIndex = _hanoiTopInfo.nowIndex;
				targetIndex = _hanoiTopInfo.getTargetIndex(_hanoiTopInfo, "odd");
				elseIndex = 3 - nowIndex - targetIndex;
			} else {							// '기준블락'이 위치한Index에서 '기준블락'을포함한 연속된 블락개수가 "짝수"개라면
				nowIndex = _hanoiTopInfo.nowIndex;
				targetIndex = _hanoiTopInfo.getTargetIndex(_hanoiTopInfo, "even");
				elseIndex = 3 - nowIndex - targetIndex;
			}

			//기준블럭 이동
			_hanoiTopInfo = move3Blocks(_hanoiTopInfo, nowIndex, targetIndex, elseIndex);
			
			run(_hanoiTopInfo);
		}
		
		return _hanoiTopInfo;
	}

	/*
	 * nowIndex		: '기준블럭'이 현재 위치한 자리
	 * targetIndex	: '기준블럭'이 이동할 자리
	 * fromIndex	: '기준블럭'이 targetIndex로 이동하기 직전에 위치했던 자리
	 */

	// 첫번째 자리에서 세번째자리로 탑 전체를 이동시키는게 목표이며. 편의상 이 3개의 자리를 index라고 칭하겠음.
	// 최상단에있는 제일작은 블럭 3개를 기준으로 할거임. 편의상 이 3개블락을 통칭해서 '기준블락' 이라 칭하겠음.
	// 제일 큰 블락을 편의상 '제일무거운 블락'이라 칭하겠음.

	// '제일무거운 블락'이 위치한곳에서 꼭대기에있는 블락을 pop함
		// 만약에 '제일무거운 블락'이 '기준블락과' 동일한곳에 위치한다면 해당index에서 pop하지 않고. 남은 두 index중에서 좀더 크기가 작은 블락이 있는index에서 pop한다.
		// 만약에 '제일무거운 블락' 위치한곳에서 pop할 수 없다면(pop을해도 push할 자리가 없다면). 다른 나머지 index에서 pop함.(둘중에 하나는 '기준블락'이 위치해있으므로 남는자리는 하나임)
	// push할 targetIndex는 '기준블락'이 위치하지 않은곳으로 함.
	
	// '기준블락' 포함해서 연속된 블락개수가 홀수개라면. targetIndex로 이동
		// targetIndex	: '기준블락'을 제외한 index에있는 블락 중 더 작은블락이 위치한곳
	// '기준블락' 포함해서 연속된 블락개수가 짝수개라면. elseIndex로 이동
		// elseIndex	: '기준블락'을 제외한 index에있는 블락 중 더 큰 블락이 위치한곳

	// '제일무거운 블락'이 3번째자리로 이동했다면 더이상 움직일 필요가 없으므로. 앞으로는 '제일무거운 블락'을 그보다 한단계 작은크기의 블럭으로 변경시킨다.
	public static void main(String[] args) throws IOException {
		// long start = System.nanoTime();

		Main main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 하노이탑 개수가 2이하면 따로 처리
		if(N <= 2) {
			if(N == 2 ) {
				bw.write("3" + "\n");
				bw.write("1 2" + "\n");
				bw.write("1 3" + "\n");
				bw.write("2 3" + "\n");
			} else {
				bw.write("1" + "\n");
				bw.write("1 3" + "\n");
			}
		}
		else {	// 3개이상이면
			HanoiTopInfo hanoiTopInfo = main.initHanoiTop(N);
			hanoiTopInfo = main.run(hanoiTopInfo);

			bw.write(String.valueOf(hanoiTopInfo.resultCount) + "\n");
			bw.write(hanoiTopInfo.result.toString());
		}

		bw.flush();
		// long end = System.nanoTime();
		// bw.write("수행시간: " + (end - start) / 1000000 + " ms");
		// bw.flush();
		bw.close();
	}
}