import ChessGame.GameViewer;
;
import Controller.Controller;

public class PieceMovements {
    GameViewer newBoard;

 
	public void setUp() throws Exception
	{
		newBoard = new GameViewer("Traditional");
	}
	
	public void testPawn() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 6;
	newBoard.moveSelectedPiece(3, 4);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[1].positions.getY() == 4 && newBoard.board.player1.pawns[1].positions.getX() == 3 ));

		newBoard.mouseX = 4;
		newBoard.mouseY = 6;
		newBoard.moveSelectedPiece(3, 4);
		assertFalse("Piece did move to incorrect place!", newBoard.board.player1.pawns[0].positions.getY() == 4 && newBoard.board.player1.pawns[0].positions.getX() == 3 );
	}

	@Test
	public void testCastle() {
		newBoard.mouseX = 0;
		newBoard.mouseY = 0;
		newBoard.moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.board.player1.castles[0].positions.getY() == 5 && newBoard.board.player1.castles[0].positions.getX() == 5 ));
	}

	@Test
	public void testHorse() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 1;
		newBoard.moveSelectedPiece(5, 5);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[0].positions.getY() == 5 && newBoard.board.player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testWazir() {
		newBoard.mouseX = 5;
		newBoard.mouseY = 6;
		newBoard.moveSelectedPiece(5, 5);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[0].positions.getY() == 5 && newBoard.board.player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testBerolina() {
		newBoard.mouseX = 1;
	newBoard.mouseY = 1;
		newBoard.moveSelectedPiece(5, 5);
		assertFalse("Piece moved to incorrect place!",
				(newBoard.board.player2.berolinas[0].positions.getY() == 5 && newBoard.board.player2.berolinas[0].positions.getX() == 5 ));

	}

	@Test
	public void testBishop() {
		newBoard.mouseX = 0;
		newBoard.mouseY = 0;
		newBoard.moveSelectedPiece(5, 5);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[0].positions.getY() == 5 && newBoard.board.player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testQueen() {
		newBoard.mouseX = 4;
		newBoard.mouseY = 9;
		newBoard.moveSelectedPiece(5, 5);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[0].positions.getY() == 5 && newBoard.board.player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testKing() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 7;
		newBoard.moveSelectedPiece(5, 5);
		assertTrue("Piece didn't move to correct place!",
				(newBoard.board.player1.pawns[0].positions.getY() == 5 && newBoard.board.player1.pawns[0].positions.getX() == 5 ));

	}
}
