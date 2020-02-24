package pieces;

import java.util.Vector;

import ChessBoards.Grid;
import Pieces.Pair;
import chess.Board;
import chess.Square;

public class Rook extends ChessPiece {

	public Rook(String colorIn) {
		super(colorIn, "rook");
		
		if(color == "white"){
			symbol = String.valueOf((char)(Integer.parseInt("2656",16)));
		}
		else{
			symbol = String.valueOf((char)(Integer.parseInt("265C",16)));
		}
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		
		int moveFromX = moveFromReq[0];
		int moveFromY = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		String direction;
		
		if(!testKing){
			if(toSquare.getType() == "king"){
				return false;
			}
		}
		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = "right";
			}
			else{
				direction = "left";
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = "bot";
			}
			else{
				direction = "top";
			}
		}
		else{
			return false;
		}
		
		Square testSquare;
		
		if((direction == "right") || (direction == "left")){
			int displaceMax = Math.abs(moveToX - moveFromX);
		
			for(int displace = 1; displace <= displaceMax; displace++){
				if(direction == "right"){
					testSquare = Board.board[moveFromY][moveFromX + displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
						return true;
					}
				}
				else{
					testSquare = Board.board[moveFromY][moveFromX - displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
						return true;
					}
				}
			}
		}
		else{
			int displaceMax = Math.abs(moveToY - moveFromY);
				
			for(int displace = 1; displace <= displaceMax; displace++){
				
				if(direction == "top"){
					testSquare = Board.board[moveFromY - displace][moveFromX];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
						return true;
					}
				}
				else{
					testSquare = Board.board[moveFromY + displace][moveFromX];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor))){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void specialMove(String color) {
		// TODO Auto-generated method stub
	return;	
	}
	 @Override
	    public Vector<Pair> addMoves(int player, Grid[][] g) {
	        Vector<Pair> values = new Vector<Pair>();

	        for(int i = 0; i < 8;i++ )
	        {
	            for(int j = 0; j < 8;j++)
	            {
	                if( canMove(i, j, player, g) )
	                    values.add(new Pair(i, j) );
	            }
	        }

	        return values;
	    }

}
