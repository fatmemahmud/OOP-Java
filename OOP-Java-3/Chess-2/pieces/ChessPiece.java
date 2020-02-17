package pieces;


import chess.Square;

public abstract class ChessPiece extends Square{
	
	public Pair positions;
	public boolean selected;
	public boolean isEaten;

	public ChessPiece(String colorIn, String typeIn) {
		super(typeIn);
		color = colorIn;
	} 
}
