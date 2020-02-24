package pieces;

import chess.Board;
import chess.Square;

public class Bishop extends ChessPiece {

	public Bishop(String colorIn) {
		super(colorIn, "bishop");
		
		if(color == "white"){
			symbol = String.valueOf((char)(Integer.parseInt("2657",16)));
		}
		else{
			symbol = String.valueOf((char)(Integer.parseInt("265D",16)));
		}
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		
		int moveFromX = moveFromReq[0];
		int moveFromY = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		int moveDistance = Math.abs(moveToX - moveFromX);
		
		if(!testKing){
			if(toSquare.getType() == "king"){
				return false;
			}
		}
		
		String direction;
		
		if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = "topRight";
			}
			else{
				direction = "botRight";
			}
		}
		else{
			if(moveToY < moveFromY){
				direction = "topLeft";
			}
			else{
				direction = "botLeft";
			}
		}
		
		
		Square testSquare;

		for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
			if(direction == "topRight"){
				testSquare = Board.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
			}
			else if(direction == "botRight"){
				testSquare = Board.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
			}
			else if(direction == "topLeft"){
				testSquare = Board.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
			}
			else{
				testSquare = Board.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
			}
			
			if((testSquare.getType() != "blank") && (diagMoveAway != moveDistance)){
				return false;
			}
			else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != plyColor) || (testSquare.getType() == "blank"))){
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
