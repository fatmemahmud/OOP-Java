package pieces;


import chess.Board;
import chess.Square;

public class Chudaka 
			extends ChessPiece 
			{
	
	public Chudaka(String colorIn) {
		super(colorIn, "pawn");
		
		if(color == "white"){
			symbol = String.valueOf((char)(Integer.parseInt("2659",16)));
		}
		else{
			symbol = String.valueOf((char)(Integer.parseInt("265F",16)));
		}
	}
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		
		int moveFromX = moveFromReq[0];
		int moveFromY = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		
		int moveForwardOne;
		int pawnRowOnPlySide;
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		if(!testKing){
			if(toSquare.getType() == "king"){
				return false;
			}
		}
		
		if(plyColor == "white"){

			moveForwardOne = -1;
			pawnRowOnPlySide = 1;
		}
		else{
			
			moveForwardOne = 1;
			pawnRowOnPlySide = 1;
		}

		if(moveToY == moveFromY + moveForwardOne){

			if((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)){
				if((toSquare.getType() != "blank") && (toSquare.getColor() != plyColor)){
					return true; 
				}
			}
			else if((moveToX == moveFromX) && (toSquare.getType() == "blank")){ 
				return true;
			}
		}
		else if((moveToY == moveFromY + moveForwardOne) && (moveToX == moveFromX) && (toSquare.getType() == "blank")){ 
			if(moveFromY == pawnRowOnPlySide){
				return true;
			}
		}
		
		return false;
	}
	@Override
	public void specialMove(String color) {
		// TODO Auto-generated method stub
		
	}	

			}
	

