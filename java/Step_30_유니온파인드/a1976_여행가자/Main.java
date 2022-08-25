/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1976
 	문제번호 : 1976
 	알고리즘 : 그래프 이론, 자료 구조, 그래프 탐색, 분리 집합
*/
package Step_30_유니온파인드.a1976_여행가자;

import java.util.Scanner;

class IO {
	Scanner scan = new Scanner(System.in);
	
	//input Method
	public int input()
	{
		return scan.nextInt();
	}
	
	public int[][] input(int _N)
	{
		int[][] cityConnectionInfo = new int[_N][_N];
		for(int i=0; i<_N; i++)
		{
			for(int j=0; j<_N; j++)
			{
				cityConnectionInfo[i][j] = scan.nextInt();
			}
		}
		
		return cityConnectionInfo;
	}
	
	public int[] inputPlanCity(int _numberOfCityPlan)
	{
		int[] cityOfPlanInfo = new int[_numberOfCityPlan];
		
		for(int i=0; i<_numberOfCityPlan; i++)
		{
			cityOfPlanInfo[i] = scan.nextInt() -1 ;	// 입력받은 도시번호에서 -1해줘서 추후 다룰 인덱스번호로 바꿔줌.
		}
		
		return cityOfPlanInfo;
	}
	
	//output Method
	public void output(boolean _result)
	{
//		System.out.println(_result==true ? "YES" : "NO");
		if(_result==true)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
}

class Calc{
	
	public int[] setParent(int[][] _cityConnectionInfo, int[] _cityUnionInfo)
	{
//		_cityUnionInfo[0] = 0;	// 0번도시의 부모는 본인
		
		for(int i=0; i<_cityConnectionInfo.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(_cityConnectionInfo[i][j] == 1)
				{
					if(_cityUnionInfo[i] == i)
					{
						_cityUnionInfo[i] = j;
					}
					else if(_cityUnionInfo[j] == j)
					{
						_cityUnionInfo[j] = i;
					}
					else
					{
						int getP = find(_cityUnionInfo, j);
						
						if(getP != 0)
						{
//							_cityUnionInfo[getP] = i;
							//위에 코드로 eclipse에서 돌리면 반례못찾을정도로 정답잘나오는데.. 백준에 해답제출하면 런타임 에러뜬다. 왜????.. 결국 원인못찾음
							_cityUnionInfo[getP] = 0;	//위에코드로돌리면 런타임에러나서, 결국 부모노드의 최종종착지인 0값을 상수값으로 넣어주니 잘된다. 이해안됨.
						}
					}
				}
			}
		}
		
		return _cityUnionInfo;
	}
	
	public boolean getResult(int[] _cityUnionInfo, int[] _cityOfPlanInfo)
	{
		for(int i=0; i<_cityOfPlanInfo.length -1; i++)
		{
			if(_cityUnionInfo[_cityOfPlanInfo[i]] != _cityUnionInfo[_cityOfPlanInfo[i+1]])
			{
				return false;	//부모노드가 하나라도 서로다른게있다면 여행 불가능
			}
		}
		
		return true;	// 계획된 도시의 부모노드가 모두 같은값이라면 여행 가능
	}
	
	//노드의 최종 부모 idx 값을 return
	public int find(int[] _cityUnionInfo, int _idx)
	{
		if(_cityUnionInfo[_idx] == _idx)
		{
			return _idx;
		}
		else
		{
			return find(_cityUnionInfo, _cityUnionInfo[_idx]);
		}
	}
	
	public int[] updateUnionInfo(int[] _cityUnionInfo)
	{
		for(int i=0; i<_cityUnionInfo.length; i++)
		{
			_cityUnionInfo[i] = find(_cityUnionInfo, i);
		}
		
		return _cityUnionInfo;
	}
}


public class Main {
	
	public static void main(String args[])
	{
		// 첫번째줄에는 도시수 N
		// 두번째줄에는 여행계획에 속할 도시 수 M
		// N * N 행렬정보에 index번호간 길이 연결되어있으면 1, 길이없다면 0 입력. (ex- [0,1]값이 1이라면 1번도시와 2번도시는 길이 연결되어있음)
		// 설계 : union-find 알고리즘을 활용해서 도시번호가 높은쪽에서 낮은쪽으로 parent 할당해준다. 따라서 1번도시(index:0)의 부모는 본인
		// 		여행계획에속한 모든도시가 하나의 부모노드로 귀결된다면 이 도시들은 전부연결되어있다고 판단, 하나라도 다른 부모노드값을 가지고있다면 여행불가.
		// 유의점 : N * N 행렬이고, [0,3]값이 연결되어있다면 [3,0]값도 연결되어있기때문에 중복해서 연산을해줄필요가없다. 따라서 행렬의 좌측상단 꼭지점부터 우측하단꼭지점을 기준으로 포개서 접는다고했을때 윗쪽면부분은 연산할필요가없음.
		//		  여행계획도시 입력 시 같은도시가 연속으로 입력될 수 있음.
		
		int numberOfCity = 0;		// 도시 수
		int numberOfCityPlan = 0;	// 여행계획 도시(도시번호)
		int[][] cityConnectionInfo = null;
		int[] cityUnionInfo = null;
		int[] cityOfPlanInfo = null;
		
		IO io = new IO();
		numberOfCity = io.input();
		numberOfCityPlan = io.input();
		cityConnectionInfo = io.input(numberOfCity);
		cityUnionInfo = new int[numberOfCity];
		
		for(int i=0; i<numberOfCity; i++)
		{
			cityUnionInfo[i] = i;
		}
		
		cityOfPlanInfo = io.inputPlanCity(numberOfCityPlan);
		
		Calc calc = new Calc();
		cityUnionInfo = calc.setParent(cityConnectionInfo, cityUnionInfo);	// 각 도시들의 부모노드 설정(Union-Find)
		cityUnionInfo = calc.updateUnionInfo(cityUnionInfo);
		
		boolean result = calc.getResult(cityUnionInfo, cityOfPlanInfo);
		
		io.output(result);
	}
		
}