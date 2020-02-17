package chess;

import java.util.Scanner;

import pieces.ChessPiece;

public class Player {
	
	private String name;
	private String color;
	private Scanner scanner = new Scanner(System.in);
	public ChessPiece[] knights;
	public ChessPiece[] pawns;
	public ChessPiece[] rooks;
	public ChessPiece[] bishops;
	public ChessPiece queen;
	public ChessPiece king;
	
	
	public Player(String nameIn, String colorIn){
		name = nameIn;
		color = colorIn;
	}
	
	private int convertCharToNum(char charIn){
		int numOut = -1;
		
		for(int i = 0; i < Board.sideLetters.length; i++){
			
			if(Board.sideLetters[i] == charIn){
				numOut = i;
			}
		}
		return numOut;
	}
	
	private int convertCharNumtoNum(char charIn){
		int numOut = -1;
		int convertedNum = Character.getNumericValue(charIn); 
		
		for(int i: Board.sideNumbers){
			if(i == convertedNum){
				numOut = convertedNum;   
			}
		}
		return numOut;
	}
	
	public int[][] getMove(){
		
		int[][] move = new int[2][2];
		for(int runNum = 1; runNum <= 2; runNum++){
			while(true){
				if(runNum == 1){
					System.out.print(name + ", input your location to move from. (EX: E4)\n>> ");
				}
				else{
					System.out.print(name + ", input you location to move to. (EX: E4)\n>> ");
				}
				String moveIn = scanner.nextLine().trim();

				if(!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t"))){
				
					if(!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1))){

						int x, y;
			
						if((x = convertCharToNum(Character.toUpperCase(moveIn.charAt(0)))) != -1){
							if((y = convertCharNumtoNum(moveIn.charAt(1))) != -1){
								y = 8 - y;
								int tempArray[] = {x, y};
								if(runNum == 1){
									if(Board.board[y][x].getType() == "blank" || Board.board[y][x].getColor() != color){
										tempArray[0] = -1;																
										tempArray[1] = -1;
										int[][] errorArray = {tempArray, tempArray};
										return errorArray;
									}
								}
								
								move[runNum - 1] = tempArray;
								break;
							}
						}
					}
				}
				System.out.println("Invalid location. Try again.");
			}		
		}
		return move;
	}

	public ChessPiece validChessPieceSelected(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChessPiece checkEaten(int newX, int newY) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean movePiece(ChessPiece pieceSelected, int newX, int newY, int turn, Square[][] grid) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean moveChessPiece(ChessPiece pieceSelected, int newX, int newY, int turn, Square[][] grid) {
		// TODO Auto-generated method stub
		return false;
	}
}
