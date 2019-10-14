//Solves Sudokus with the approach of backtracking

public class SudokuSolver{
	
	static int[][] grid; //= new int[9][9];
	static int recursionDepth = 0;
	static int changes = 0;
	
	//Driver method
	public static void main(String[] args){
		grid = new int[][] {{7, 0, 9,  3, 0, 0,  0, 0, 0}, 
							{0, 1, 0,  5, 0, 0,  6, 0, 0},
							{5, 0, 3,  0, 1, 0,  2, 4, 9},
							
							{0, 3, 0,  9, 5, 0,  7, 0, 0},
							{4, 0, 0,  1, 0, 0,  0, 0, 8},
							{0, 0, 0,  0, 3, 8,  0, 6, 0},
							
							{3, 0, 1,  0, 6, 0,  4, 0, 2},
							{0, 0, 2,  0, 0, 1,  0, 7, 0},
							{0, 0, 0,  0, 0, 3,  9, 0, 0}};
		
		boolean[][] boolGrid = fillBoolGrid(grid);
		
		System.out.println("\nTo solve: \n");
		draw(grid);
		
		//start at the top left
		int rowCurrent=0, columnCurrent=0, rowNext, columnNext, numberLast=0; 
		
		if(boolGrid[0][0]){
			rowNext = 0;
			columnNext = 0;
		} else{
			int nextFieldReturn = nextField(boolGrid, rowCurrent, columnCurrent);
			rowNext = nextFieldReturn/10;
			columnNext = nextFieldReturn%10;
		}
		
		boolean solvable = false;
		
		try{
			solvable = solve(grid, boolGrid, rowNext, columnNext);
		} catch(Exception e){
			e.printStackTrace();	
		}
		
		if(solvable){
			System.out.println("\n\nSolution: \n");
			draw(grid);
			System.out.println("\nMaximum depth of recursion: " + recursionDepth);
			System.out.println("Number of changes: " + changes);
		} else {
			System.out.println("Not solvable!");
		}
	}
	
	//checks if the number fits at the given position
	static boolean check(int[][] grid, int row, int column, int number){
		
		for(int indexRow=0; indexRow<9; indexRow++){
			if(number == grid[indexRow][column]){
				return false;
			}
		}
		
		for(int indexColumn=0; indexColumn<9; indexColumn++){
			if(number == grid[row][indexColumn]){
				return false;
			}
		}
		
		int borderColumn = column/3*3;
		int borderRow = row/3*3;
		for(int indexBlockColumn = borderColumn; indexBlockColumn < borderColumn+3; indexBlockColumn++){
			for(int indexBlockRow = borderRow; indexBlockRow < borderRow+3; indexBlockRow++){
				if(number == grid[indexBlockRow][indexBlockColumn]){					
					return false;
				}	
			}
		}
		return true;
	}
	
	
	//returns 10*nextRow + nextColumn so that nextRow = nextField/10 and nextColumn = nextField%10
	static int nextField(boolean[][] boolGrid, int rowCurrent, int columnCurrent){ 
		
		int rowNext, columnNext;
		//at the end of a row
		if(columnCurrent >= 8){
			columnNext = 0;
			rowNext = rowCurrent+1;
		} else {
			columnNext = columnCurrent+1;
			rowNext = rowCurrent;
		}
		
		for(int row=rowNext; row<9; row++){
			for(int column=columnNext; column<9; column++){
				if(boolGrid[row][column]){ //true if the field is changeable
					return (int) 10*row + column; //for conersion back: row=return/10, column=return%10
				}
			}
			columnNext = 0;
		}	
		return -1; //if there are no more fields
	}
	
	//creates a boolean-grid to safe which field is changeable
	static boolean[][] fillBoolGrid(int[][] grid){
		boolean[][] boolGrid = new boolean[9][9];
		for(int row=0; row<9; row++){
			for(int column=0; column<9; column++){
				if(grid[row][column] == 0){ //erfüllt wenn wir ein bearbeitbares Feld kontrollieren
					boolGrid[row][column] = true;
				}
			}
		}	
		return boolGrid;
	}
	
	//returns the previously changed Field encoded with 10*previousRow + previousColumn
	static int lastField(boolean[][] boolGrid, int rowCurrent, int columnCurrent){
		
		int columnLast, rowLast;
		
		if(columnCurrent == 0){
			columnLast = 8;
			rowLast = rowCurrent-1;
		} else {
			columnLast = columnCurrent-1;
			rowLast = rowCurrent;
		}
		
		for(int row=rowLast; row>=0; row--){
			for(int column=columnLast; column>=0; column--){
				if(boolGrid[row][column]){
					return (int) 10*row + column; //for conversion back: row=return/10, column=return%10
				}
			}
			columnLast = 8;
		}	
		return -1; //if there is no previous field		
		
	}
	
	//coordinated the process
	//returns true if a number was placed and false if no number has been placed
	static boolean solve(int[][] grid, boolean[][] boolGrid, int rowCurrent, int columnCurrent){
		
		recursionDepth++;
		
		//System.out.println("recursionDepth Current: " + recursionDepth);
		
		int testnumber = 1;
		boolean alreadyChanged = false;
		
		do{
			//System.out.println("testnumber " + testnumber);
			if(check(grid, rowCurrent, columnCurrent, testnumber)){
				grid[rowCurrent][columnCurrent] = testnumber;
				
				alreadyChanged = true; //indicates if the number has already been changed
				
				int nextFieldReturn = nextField(boolGrid, rowCurrent, columnCurrent);
		
				if(nextFieldReturn == -1){ //if finished
					return true;
				}	
		
				int rowNext = nextFieldReturn/10;
				int columnNext = nextFieldReturn%10;
				
				if(solve(grid, boolGrid, rowNext, columnNext)){
					return true; //if no changes are necessary
				} else {
					grid[rowCurrent][columnCurrent] = 0; //step backwards
					alreadyChanged = false;
					changes++;
				}
				
			}
			testnumber++;
			
		}while(testnumber<10);
		
		if(!alreadyChanged){ //if no number has been changed
			grid[rowCurrent][columnCurrent] = 0;
			recursionDepth--;
			return false;
		}
		return false;
	}
	
	//draws the grid
	static void draw(int[][] feld){	
		for(int a = 0; a < feld[1].length; a++){
			String row = "";
			
			if (a % 3 == 0) {
				for (int i = 0; i < feld.length; i++) {
					row += "--";
				}
				row += "-----\n";
			}
			
			row += "|";
			
			for(int b = 0; b < feld.length; b++){
				row = row + feld[a][b] + ((b+1) % 3 == 0 && b < feld.length - 1 ? " | " : "|");
			}
			
			row += "\n";
			
			System.out.print(row);
		}
	}
		
}
