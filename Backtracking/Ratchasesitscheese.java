package lect12backtracking;

import java.util.Scanner;

public class Ratchasesitscheese {
	static Scanner x = new Scanner(System.in);

	public static void main(String[] args) {

		char[][] maze = takeInput();
		int[][] AuxiMaze = new int[maze.length][maze[0].length];
		//int[][] temp = new int[maze.length][maze[0].length];
		paths(maze, 0, 0, AuxiMaze);
		if (c == 0) {
			System.out.println("NO PATH FOUND");
		}

	}

	static int c = 0;

	public static void paths(char[][] maze, int row, int col, int[][] Auxi) {
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			Auxi[row][col] = 1;
			//for(int i=0;i<Auxi.length;i++){
            //for(int j=0;j<Auxi[0].length;j++){
            //    temp[i][j]=Auxi[i][j];
			//display(temp);

			display(Auxi);
			c = 1;
			return;
		}
		if (row == maze.length || col == maze[0].length || row < 0 || col < 0 || maze[row][col] == 'X'
				|| Auxi[row][col] == 1) {
			return;
		}

		Auxi[row][col] = 1;

		paths(maze, row + 1, col, Auxi);

		paths(maze, row, col + 1, Auxi);

		paths(maze, row - 1, col, Auxi);

		paths(maze, row, col - 1, Auxi);
		Auxi[row][col] = 0;

	}

	public static char[][] takeInput() {
		int n = x.nextInt();
		int m = x.nextInt();
		char[][] maze = new char[n][m];
		for (int i = 0; i < n; i++) {
			String a = x.next();
			for (int j = 0; j < m; j++) {
				maze[i][j] = a.charAt(j);
			}
		}
		return maze;
	}

	public static void display(int[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
}
