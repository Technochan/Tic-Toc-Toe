package TikTacToe;

import java.util.Scanner;

public class Main {
	
	public static boolean checkWon(char[][] map,char player) {
		for(int row = 0 ; row<map.length ; row++) {
			if((map[row][0] == player && map[row][1] == player && map[row][2] == player) ||
				(map[0][row] == player && map[1][row] == player && map[2][row] == player ) ||
				(map[0][0] == player && map[1][1] == player && map[2][2] == player) ||
				(map[0][2] == player && map[1][1] == player && map[2][0] == player)) {
				return true;
			}
		}
		return false;
	}
	public static void display(char[][] map) {
		for(int i =0 ; i<map.length ; i++) {	
			for(int j=0 ; j<map.length ; j++) {
				System.out.print(map[i][j]+" | ");
			}		 
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] map= new char[3][3];
		char player = 'X';
		
		for(int i=0 ; i<map.length ; i++) {
			for(int j=0 ; j<map[i].length ; j++) {
				map[i][j] = ' ';
			}
		}
		
		boolean gameOver = false;
		display(map);
		while(!gameOver) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Player "+player+" Enter :");
			int row = scan.nextInt();
			int col = scan.nextInt();
			
			if(map[row][col] == ' ') {
				map[row][col] = player;
				boolean won = checkWon(map,player);
				
				if(won) {
					System.out.println("Congratzzz Player "+player+" Won");
					gameOver = true;
				} else {
					player = player == 'X' ? 'O' : 'X';
				}
			} else {
				System.out.println("Invalid Move");
			}
			display(map);
		}
	}
}
