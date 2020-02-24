package chess;

import java.util.Scanner;
import pieces.*;
public abstract class Board {
	
	static final char sideLetters[] = {'A','B','C','D','E','F','G','H'};
	static final int sideNumbers[] = {1,2,3,4,5,6,7,8};
	public static Square board[][] = new Square[8][8];
	public static Object player1;
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public  static void setup(){
		board[0][0] = new Rook("black");
		board[0][1] = new Knight("black");
		board[0][2] = new Bishop("black");
		board[0][3] = new Queen("black");
		board[0][4] = new King("black");
		board[0][5] = new Bishop("black");
		board[0][6] = new Knight("black");
		board[0][7] = new Rook("black");

		for(int i = 0; i < 8; i++){
			board[1][i] = new Pawn("black");
		}
		
		for(int i = 2; i < 6; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = new WhiteSpace();
			}
		}

		for(int i = 0; i < 8; i++){
			board[6][i] = new Pawn("white");
		}

		board[7][0] = new Rook("white");
		board[7][1] = new Knight("white");
		board[7][2] = new Bishop("white");
		board[7][3] = new Queen("white");
		board[7][4] = new King("white");
		board[7][5] = new Bishop("white");
		board[7][6] = new Knight("white");
		board[7][7] = new Rook("white");
		
	}
	
	public static String checkForCheckOrMate(String plyColor){
		for(int kingY = 0; kingY < 8; kingY++){
			for(int kingX = 0; kingX < 8; kingX++){
				Square kingSquare = board[kingY][kingX];
				
				String kingColor;
				if(plyColor == "white"){
					kingColor = "black";
				}
				else{
					kingColor = "white";
				}
				
				if((kingSquare.getType() == "king") && (kingSquare.getColor() == kingColor)){
					
					for(int threatY = 0; threatY < 8; threatY++){
						for(int threatX = 0; threatX < 8; threatX++){
							Square threatSquare = board[threatY][threatX];
							
							if((threatSquare.getType() != "blank") && (threatSquare.getColor() == plyColor)){
								int[] moveFrom = {threatX, threatY};
								int[] moveTo = {kingX, kingY};
							
								if(threatSquare.checkMove(moveFrom, moveTo, plyColor, true)){
									return "check";
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static void update(int[] origLoc, int[] newLoc){
		board[newLoc[1]][newLoc[0]] = board[origLoc[1]][origLoc[0]];
		board[origLoc[1]][origLoc[0]] = new WhiteSpace();
	}
	
	public static void draw(){
		System.out.print("\n   ");
		
		for(char i: sideLetters){
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 8; i++){
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		for(int i = 0; i < 8; i++){
			System.out.print(" " + (8 - i) + " ");
			
			for(Square j: board[i]){
				System.out.print("|" + j.getSymbol() + "|");
			}
			System.out.print(" " + (8 - i) + " ");
			
			System.out.print("\n   ");
			
			for(int j = 0; j < 8; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		for(char i: sideLetters){
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}

	public static String getName(int playerNum, String prevName){
		String name;
		
		while(true){
			System.out.print("Player " + playerNum + " please enter your name.\n>> ");
			name = scanner.nextLine().trim();
			if(!name.isEmpty() && !(name.contains(" ") || name.contains("\t")) && !name.equals(prevName))
				break;
			else
				System.out.println("Invalid name. Try again.");
		}
		return name;
	}

	public abstract int getWidth();
}
