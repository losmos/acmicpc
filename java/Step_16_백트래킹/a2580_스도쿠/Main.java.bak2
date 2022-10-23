/*
 	문제출처 : BACKJOON, https://www.acmicpc.net/problem/2580
 	문제번호 : 2580
 	알고리즘 : 백트래킹
*/
package Step_15_백트래킹.a2580_스도쿠;

import java.util.ArrayList;
import java.util.Scanner;

// 스도쿠 빈칸정보 저장할 클래스
class SD{
	private int x;
	private int y;
	
	//생성자
	public SD(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
}

class tempSave_XY{
	private int tempNum = 0;
	private int tempX = 0;
	private int tempY = 0;
	
	//생성자
	public tempSave_XY(int tempNum, int tempX, int tempY)
	{
		this.tempNum = tempNum;
		this.tempX = tempX;
		this.tempY = tempY;
	}
	
	public int getTempNum()
	{
		return this.tempNum;
	}
	
	public int getTempX()
	{
		return this.tempX;
	}
	
	public int getTempY()
	{
		return this.tempY;
	}
	
	
}

class IO {
	Scanner scan = new Scanner(System.in);
	
	// 스도쿠판 정보 입력
	public int[][] inputSudoku()
	{
		int[][] sudoku = new int[9][9];
		
		for(int i=0; i<9; ++i)
		{
			for(int j=0; j<9; ++j)
			{
				sudoku[i][j] = scan.nextInt();
			}
		}
		
		return sudoku;
	}
	
	// 스도쿠판의 빈칸정보 init
	public ArrayList<SD> initBlankSudokuInfo(int[][] _sudoku)
	{
		ArrayList<SD> blankSudokuInfo = new ArrayList<SD>();
		
		for(int i=0; i<9; ++i)
		{
			for(int j=0; j<9; ++j)
			{
				if(_sudoku[i][j] == 0)
				{
					blankSudokuInfo.add(new SD(i,j));
				}
			}
		}
		
		return blankSudokuInfo;
	}
	
	// 출력
	public void output(int[][] _sudoku)
	{
		for(int x=0; x<9; ++x)
		{
			for(int y=0; y<9; ++y)
			{
				System.out.print(_sudoku[x][y] + " ");
			}
			System.out.println("");
		}
	}
}

class Calc{
	
	int[][] sudoku = null;
	ArrayList<SD> initBlankSudokuInfo = null;
	ArrayList<tempSave_XY> tempSave = new ArrayList<tempSave_XY>();
//	ArrayList<Integer> initNumberInfo = new ArrayList<Integer>();
	boolean result = false;
	
	public int[][] run(int[][] _sudoku, ArrayList<SD> _initBlankSudokuInfo)
	{
		sudoku = _sudoku;
		initBlankSudokuInfo = _initBlankSudokuInfo;
		boolean last = false;
		for(int i=0; i<initBlankSudokuInfo.size(); ++i)
		{
			last = dfs(i);
			if(last)
			{
				break;
			}
		}
		
		return sudoku;
	}
	
	// 01. 공백좌표 for문 체크
	// 02. 공백위치 x,y index를 dfs에던져서 재귀호출검사
	public boolean dfs(int _idx)
	{

		if(_idx == 8)
		{
			System.out.println("");
		}
		
		// 스도쿠 숫자 전부다 채워넣은경우
		if(_idx == initBlankSudokuInfo.size())
		{
			return true;	// 스도쿠 종료
		}
		//스도쿠 전부다 채워넣을경우
		
		for(int i=1; i<10; ++i)
		{
			if(checkInitPossible(i, initBlankSudokuInfo.get(_idx).getX(), initBlankSudokuInfo.get(_idx).getY()))	// i값이 공백에 들어 갈 수 있다면
			{
				sudoku[initBlankSudokuInfo.get(_idx).getX()][initBlankSudokuInfo.get(_idx).getY()] = i;
				tempSave.add(new tempSave_XY(i, initBlankSudokuInfo.get(_idx).getX(), initBlankSudokuInfo.get(_idx).getY()));
				
				result = dfs(_idx +1);
				
				if(result)
				{
					return true;
				}
				else
				{
					// 최근에 넣은 값 0으로 다시 초기화
					sudoku[tempSave.get(tempSave.size()-1).getTempX()][tempSave.get(tempSave.size()-1).getTempY()] = 0;
					tempSave.remove(tempSave.size()-1);
//					return false;
					//initNumberInfo.remove(initNumberInfo.size()-1);
				}
			}
		}
		
		return false;
		
	}
	
	public boolean checkInitPossible(int _num, int _x, int _y)
	{
		// return true  : 전달받은 숫자가 위치 할 수 있음
		// return false : 전달받은 숫자가 중복으로인해 위치 할 수 없음
		
		if(!check3x3(_num, _x, _y))
		{
			return false;
		}
		if(!checkRow(_num, _x))
		{
			return false;
		}
		if(!checkCol(_num, _y))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean check3x3(int _num, int _x, int _y)
	{
		int xMultiple = 0;
		int yMultiple = 0;
		
		xMultiple = _x / 3 + 1;	//3x3에서 검사할 x의 시작점 설정을 위한 값
		yMultiple = _y / 3 + 1 ;	//3x3에서 검사할 y의 시작점 설정을 위한 값
		
		int startX = (xMultiple * 3) -3;
		int endX = startX + 3;
		
		int startY = (yMultiple * 3) -3;
		int endY = startY + 3;
		
		for(int x=startX; x<endX; ++x)
		{
			for(int y=startY; y<endY; ++y)
			{
				if(sudoku[x][y] == 0)
				{
					continue;
				}
				
				if(sudoku[x][y] == _num)
				{
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public boolean checkRow(int _num, int _x)
	{
		for(int i=0; i<9; ++i)
		{
			if(sudoku[_x][i] == 0)
			{
				continue;
			}
			
			if(sudoku[_x][i] == _num)
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean checkCol(int _num, int _y)
	{
		for(int i=0; i<9; ++i)
		{
			
			if(sudoku[i][_y] == 0)
			{
				continue;
			}
			
			if(sudoku[i][_y] == _num)
			{
				return false;
			}
		}
		
		return true;
	}
	
}


public class Main {
	
	/*
	 	<반례>
		0 0 0 0 0 0 0 0 0
		0 0 0 0 0 3 0 8 5
		0 0 1 0 2 0 0 0 0
		0 0 0 5 0 7 0 0 0
		0 0 4 0 0 0 1 0 0
		0 9 0 0 0 0 0 0 0
		5 0 0 0 0 0 0 7 3
		0 0 2 0 1 0 0 0 0
		0 0 0 0 4 0 0 0 9

	 */
	
	// 01. 스도쿠 사이즈는 9 x 9
	// 02. 빈칸은 0으로 채움
	// 03. 빈칸좌표정보를 가지고있는 클래스 SD를 따로 할당해서 활용
	public static void main(String[] args)
	{
		IO io = new IO();
		
		int[][] sudoku = io.inputSudoku();	// 스도쿠 배열에 숫자입력받음
		ArrayList<SD> initBlankSudokuInfo = io.initBlankSudokuInfo(sudoku);	// 빈칸정보 따로 init
		
		Calc calc = new Calc();
		
		sudoku = calc.run(sudoku, initBlankSudokuInfo);
		
		io.output(sudoku);
		
	}
}
