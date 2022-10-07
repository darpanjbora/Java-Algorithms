package lect12backtracking;

import java.util.Scanner;

public class Chessboard2 {
static int count =0;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		boolean[][] arr = new boolean[n][n];
		int[] mp = Makemines(n*n);
		Chessboard2(arr,0,0,"",mp);
		System.out.println();
		System.out.println(count);
		
	}
	public static void Chessboard2(boolean[][] board, int row, int col, String ans,int[] mp) {
		if (row == board.length - 1 && col == board[0].length - 1) {
			System.out.print("{0-0}" + ans+" ");
			count++;
			return;
		}
		if (row >= board.length || col >= board[0].length || board[row][col])
			return;
		board[row][col] = true;
		
		int cell = row * (board[0].length) + col + 1;

		if (mp[cell] == 1) {
			return ;
		} else if (mp[cell] == 2) {
			Chessboard2(board,board.length-1,board[0].length-1, ans + "P{" + (board.length - 1) + "-" + (board[0].length-1) + "}", mp);
		}

		
				Chessboard2(board, row + 2, col + 1, ans + "K" + "{" + (row + 2) + "-" +( col + 1 )+ "}",mp);
		Chessboard2(board, row + 1, col + 2, ans + "K" + "{" + (row + 1) + "-" + (col + 2) + "}",mp);
		if (row == 0 || col == 0 || col == board[0].length - 1 || row == board.length - 1) {
		for(int i =1;i<board.length;i++)
		Chessboard2(board, row , col+i, ans + "R" + "{" + (row ) + "-" + (col+i)+ "}",mp);
		for(int i =1;i<board.length;i++)
		Chessboard2(board, row+i, col , ans + "R" + "{" + (row+i) + "-" + (col ) + "}",mp);}
		if (row == col|| row + col == board.length - 1 ) {
		for(int i =1;i<board.length;i++)
		Chessboard2(board, row + i, col + i, ans + "B" + "{" + (row + i) + "-" + (col + i) + "}",mp);}
		board[row][col] = false;
	}
	public static int[] Makemines(int n)
	{ int arr[] = new int[n+1];
	 int c=1;
	 for(int i=2;i<arr.length;i++)
	 { if(isPrime(i))
	 {if(c%2==1)
		 arr[i] = 1;
	 else
		 arr[i] = 2;
	 c++;
		 
	 }
	}
	 return arr;

}
	public static boolean isPrime(int n)
	{
	for(int i =2;i<n;i++)
		{if(n%i==0)
			return false;}
	return true;
	}
}
	
	
	
	
	
	
	
	
	
