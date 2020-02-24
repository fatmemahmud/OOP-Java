package chess;

import com.sun.java_cup.internal.runtime.Scanner;


import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Player<king> {
	
	private String name;
	private String color;
	public Pawn pawns []= new Pawn[4];
	public Rook rook [] = new Rook[2];
	public Knight knight [] = new Knight[2];
	public Bishop bishops [] = new Bishop[2];
	public King king;
	public Queen queen;
	private Rook[] rooks;
	
	public Player(String type, Grid [][] grid) 
	{
		color = type;
		if(type.equals("white"))
		{
			setupWhitePieces( grid);
		}
		else
		{
			setupBlackPieces(grid);
		}
	}


	public Player(String player1Name, String string) {
		// TODO Auto-generated constructor stub
	}


	private void setupWhitePieces(chess.Grid[][] grid) 
	{

		int i;
		//set up pawns
		for(i = 0; i < pawns.length; i++)
		{
			pawns[i]= new Pawn();
			pawns[i].positions.setCoords(i+2, 6);
			g[i+2][6].color="white";
			g[i+2][6].occupied = true;
		}
	
			

		//rooks
		for(i = 0; i < 2; i++)
		{
			rooks[i] = new Rook();
			if(i == 0)
			{
				rooks[i].positions.setCoords(0, 7);
				g[0][7].color="white";
				g[0][7].occupied = true;
			}
			else
			{
				rooks[i].positions.setCoords(7, 7);
				g[7][7].color="white";
				g[7][7].occupied = true;
			}
		}
		
		//knight
		for(i = 0; i < 2; i++)
		{
			knight[i] = new Knight();
			if(i == 0)
			{
				knight[i].positions.setCoords(1, 7);
				g[1][7].color="white";
				g[1][7].occupied = true;
			}
			else
			{
				knight[i].positions.setCoords(6, 7);
				g[6][7].color="white";
				g[6][7].occupied = true;
			}
		}
		
		//bishops
		for(i = 0; i < 2; i++)
		{
			bishops[i] = new Bishop();
			if(i == 0)
			{
				bishops[i].positions.setCoords(2, 7);
				g[2][7].color="white";
				g[2][7].occupied = true;
			}
			else
			{
				bishops[i].positions.setCoords(5, 7);
				g[5][7].color="white";
				g[5][7].occupied = true;
			}
		}
		
		//king
		king = new King();
		king.positions.setCoords(4, 7);
		g[4][7].color="white";
		g[4][7].occupied = true;
		
		//queen
		queen = new Queen();
		queen.positions.setCoords(3, 7);
		g[3][7].color="white";
		g[3][7].occupied = true;
		


	}

	private void setupBlackPieces(chess.Grid[][] grid) {
		int i;
		//set up pawns
		for(i = 0; i < pawns.length; i++)
		{
			pawns[i]= new Pawn();
			pawns[i].positions.setCoords(i+2, 6);
			g[i+2][6].color="black";
			g[i+2][6].occupied = true;
		}
	
		//Rook

		for(i = 0; i < 2; i++)
		{
			rooks[i] = new Rook(color);
			if(i == 0)
			{
				rooks[i].positions.setCoords(0, 7);
				g[0][7].color="black";
				g[0][7].occupied = true;
			}
			else
			{
				rooks[i].positions.setCoords(7, 7);
				g[7][7].color="black";
				g[7][7].occupied = true;
			}
		}
		
		//knight
		for(i = 0; i < 2; i++)
		{
			knight[i] = new Knight();
			if(i == 0)
			{
				knight[i].positions.setCoords(1, 7);
				g[1][7].color="black";
				g[1][7].occupied = true;
			}
			else
			{
				knight[i].positions.setCoords(6, 7);
				g[6][7].color="black";
				g[6][7].occupied = true;
			}
		}
		
		//bishops
		for(i = 0; i < 2; i++)
		{
			bishops[i] = new Bishop();
			if(i == 0)
			{
				bishops[i].positions.setCoords(2, 7);
				g[2][7].color="black";
				g[2][7].occupied = true;
			}
			else
			{
				bishops[i].positions.setCoords(5, 7);
				g[5][7].color="black";
				g[5][7].occupied = true;
			}
		}
		
		//king
		king = new King();
		king.positions.setCoords(4, 7);
		g[4][7].color="black";
		g[4][7].occupied = true;
		
		//queen
		queen = new Queen();
		queen.positions.setCoords(3, 7);
		g[3][7].color="black";
		g[3][7].occupied = true;
		

		// TODO Auto-generated method stub
		
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
