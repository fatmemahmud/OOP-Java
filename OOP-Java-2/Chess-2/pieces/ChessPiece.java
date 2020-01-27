package pieces;

import chess.Square;

public abstract class ChessPiece extends Square{
	
	public ChessPiece(String colorIn, String typeIn) {
		super(typeIn);
		color = colorIn;
	} 
}
