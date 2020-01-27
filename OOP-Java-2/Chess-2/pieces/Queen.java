package pieces;

import chess.Board;
import chess.Square;

public class Queen extends ChessPiece {

	public Queen(String colorIn) {
		super(colorIn, "queen");
		
		if(color == "white"){
			symbol = String.valueOf((char)(Integer.parseInt("2655",16)));
		}
		else{
			symbol = String.valueOf((char)(Integer.parseInt("265B",16)));
		}
	}

	@Override
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		
		int moveFromX = moveFromReq[0];
		int moveFromY = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		String direction;
		String type;
		
		if(!testKing){
			if(toSquare.getType() == "king"){
				return false;
			}
		}
		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = "right";
				type = "straight";
			}
			else{
				direction = "left";
				type = "straight";
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = "bot";
				type = "straight";
			}
			else{
				direction = "top";
				type = "straight";
			}
		}
		else if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = "topRight";
				type = "diagonal";
			}
			else{
				direction = "botRight";
				type = "diagonal";
			}
		}
		else if(moveToX < moveFromX){
			if(moveToY < moveFromY){
				direction = "topLeft";
				type = "diagonal";
			}
			else{
				direction = "botLeft";
				type = "diagonal";
			}
		}
		else{
			return false;
		}
		
		Square testSquare;
		
		if(type == "diagonal"){
			int moveDistance = Math.abs(moveToX - moveFromX);
		
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
		}
		else{
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
		}
		return false;
	}

}
