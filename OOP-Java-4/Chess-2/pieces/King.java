package pieces;

import java.util.Vector;

import ChessBoards.Grid;
import Pieces.Pair;
import chess.Board;
import chess.Square;

public class King extends ChessPiece {

	public King(String colorIn) {
		super(colorIn, "king");
		
		if(this.color == "white"){
			symbol = String.valueOf((char)(Integer.parseInt("2654",16)));
		}
		else{
			symbol = String.valueOf((char)(Integer.parseInt("265A",16)));
		}
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		
		int moveFromX = moveFromReq[0];
		int moveFromY = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		for (int moveAwayX = -1; moveAwayX <= 1; moveAwayX++){
			for (int moveAwayY = -1; moveAwayY <= 1; moveAwayY++){
				if(moveToX == moveFromX + moveAwayX && moveToY == moveFromY + moveAwayY){
					if((toSquare.getType() != "blank") && (toSquare.getColor() != plyColor)){
						return true;
					}
					else if(toSquare.getType() == "blank"){
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public void specialMove(String color) {
		return;
		// TODO Auto-generated method stub
		
	}
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
