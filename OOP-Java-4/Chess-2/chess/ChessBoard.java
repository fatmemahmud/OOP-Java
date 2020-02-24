package chess;

import chess.Player;


public interface ChessBoard {


	    public Player getPieces(Player player, char name, int index);

	    public void moveSelectedPiece(int newX, int newY);

	    public void undo();

	    public void forfeit();

	    public void printGrid();

		void moveSelectedPiece(int newX, int newY, Object undo);

		void moveSelectedChessPiece(int newX, int newY, Object undo);


	}