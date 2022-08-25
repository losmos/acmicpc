/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/1671
 	문제번호 : 1671
 	알고리즘 : 이분 매칭
*/
package Step_43_이분매칭.a1671_상어의저녁식사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Shark
{
	private int size;
	private int speed;
	private int IQ;
	
	private boolean beEaten;	// 잡아먹히는 경우 true, 나를 잡아먹는 상어가 없을경우 false
	private int beEatenIdx;		// 잡아먹히는경우에, 나를 잡아먹는 상어의 Index 번호 저장
	
	public Shark(int _size, int _speed, int _IQ)
	{
		this.size = _size;
		this.speed = _speed;
		this.IQ = _IQ;
		
		this.beEaten = false;
		this.beEatenIdx = -1;
	}
	
	public void setBeEaten(boolean _beEaten)
	{
		this.beEaten = _beEaten;
	}
	
	public void setBeEatenIdx(int _beEatenIdx)
	{
		this.beEatenIdx = _beEatenIdx;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public int getIQ()
	{
		return this.IQ;
	}
	
	public boolean getBeEaten()
	{
		return this.beEaten;
	}
	
	public int getBeEatenIdx()
	{
		return this.beEatenIdx;
	}
}

class IO
{
   Scanner scan = new Scanner(System.in);
   
   public int inputN()
   {
	   int N = scan.nextInt();
	   return N;
   }
   
   public ArrayList<Shark> inputSharkStat(int _N)
   {
	   ArrayList<Shark> sharkArr = new ArrayList<Shark>();
	   int size, speed, IQ;
	   
	   for(int i=0; i<_N; ++i)
	   {
		   size = scan.nextInt();
		   speed = scan.nextInt();
		   IQ = scan.nextInt();
		   
		   sharkArr.add(new Shark(size, speed, IQ));
	   }
	   
	   return sharkArr;
   }
   
   public void output(ArrayList<Shark> _sharkArr, int _N)
   {
	   int alive = 0;
	   
	   for(int i=0; i<_N; ++i)
	   {
		   if(_sharkArr.get(i).getBeEaten() == false)
		   {
			   alive ++;
		   }
	   }
	   
	   System.out.println(alive);
   }
}

class Calc
{
	int N = 0;
	ArrayList<Shark> sharkArr = null;
	boolean[] visited = null; 
	
	public ArrayList<Shark> run(int _N, ArrayList<Shark> _sharkArr)
	{
		this.N = _N;
		this.sharkArr = _sharkArr;
		this.visited = new boolean[_N];
		
		for(int i=0; i<N; ++i)
		{
			for(int j=0; j<2; ++j)
			{
				Arrays.fill(visited, false);
				dfs(i);
			}
		}
		
		return sharkArr;
	}
	
	// 01. loop문 돌리면서 각 index 별로 dfs 돌려서 매칭시켜준다.
	// 02. 다음 index상어가 기존 상어의 정점대상이라면 
	//  - 기존상어가 다른 정점을 맺을 수 있는지 체크한다.
	//  - 다른정점을 맺을 수 있다면 그 정점에 매칭시키고, 밀어냈던 상어의 정점은 기존상어의 정점에 맺어준다.
	//  - 만일 밀어내기에실패하면 다음 index의 이분매칭 검사로 넘어간다.
	public boolean dfs(int _idx)
	{
		if(visited[_idx] == true)
		{
			return false;
		}
		
		visited[_idx] = true;	// 더이상 dfs 돌리지 않도록  visited 값 true 설정
		
		for(int i=0; i<N; i++)
		{
			if(_idx == i)	// 이분매칭 대상이 자기자신일경우는 continue
			{
				continue;
			}
			
			if(canEatCheck(_idx, i))	// 먹을 수 있는데
			{
				// 아직 어떤 상어도 타겟으로 삼지 않았다면
				if(sharkArr.get(i).getBeEaten() == false)
				{
					sharkArr.get(i).setBeEaten(true);
					sharkArr.get(i).setBeEatenIdx(_idx);
					
					return true;
				}
				else	// 누군가의 타겟이 되어있다면, 밀어내기 시도
				{
					boolean result = dfs(sharkArr.get(i).getBeEatenIdx());	// dfs 호출로 밀어내기 시도
					
					if(result)	// 밀어내기가 성공했다면
					{
						sharkArr.get(i).setBeEatenIdx(_idx);
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	// 먹을 수 있는경우  reutrn true
	//  - 자기자신보다 능력치가 같거나 낮을경우
	public boolean canEatCheck(int _index, int _i)
	{
		// 내가 먹을수있는지 체크하는 대상이. 이미 먼저 나를 잡아먹게 되어있다면 (즉, 능력치가 모두같은경우에 해당되며 이미 _i 가 _index를 먹기로 정점연결이 되어있는 상태)
		/*
		if(sharkArr.get(_index).getBeEatenIdx() == _i)
		{
			return false;
		}
		*/
		
		// 이미 _index의 간선이 _i를 향하고있을경우. return true 를 해주게되면 dfs를 또태우게되는 문제가 생기때문에 검사해줌
		if(sharkArr.get(_i).getBeEatenIdx() == _index)
		{
			return false;
		}
		
		int size, speed, IQ;
		int targetSize, targetSpeed, targetIQ;
		
		size = sharkArr.get(_index).getSize();
		speed = sharkArr.get(_index).getSpeed();
		IQ = sharkArr.get(_index).getIQ();
		
		targetSize = sharkArr.get(_i).getSize();
		targetSpeed = sharkArr.get(_i).getSpeed();
		targetIQ = sharkArr.get(_i).getIQ();
		
		if(size >= targetSize && speed >= targetSpeed && IQ >= targetIQ)
		{
			// _i > _index 조건을 줌으로써, 능력치가 전부 동일할경우에는 index번호가 낮은쪽이 높은쪽을 먹을 수 있다는 조건을 줌.
			// 이 조건을 주지않을경우 총 3마리의 상어능력치가 같을떄 서로 트라이앵글처럼 물고물려서 공멸하게되는 경우가 생김
			if(size == targetSize && speed == targetSpeed && IQ == targetIQ && _i > _index)
			{
				return false;
			}
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}

public class Main {

	// 01. 첫째줄 상어의 마리수 N
	// 02. 둘쨰줄부터 각 상어의 크기, 속도, 지능정보 입력
	// 03. 이분매칭 수행
	//  - 유의점 : 상어 1마리당 최대 2개의 간선이 뻗을 수 있으나, 당하는 정점(?)은 최대 1개다.(A를먹는 상어가 2마리이상이면 안된다는 의미.)
	// 05. 남은 생존상어 counting

	public static void main(String args[])
	{
		IO io = new IO();
		
		int N = io.inputN();
		ArrayList<Shark> sharkArr = null;
		sharkArr = io.inputSharkStat(N);
		
		Calc calc = new Calc();
		sharkArr = calc.run(N, sharkArr);
		
		io.output(sharkArr, N);
	}
}