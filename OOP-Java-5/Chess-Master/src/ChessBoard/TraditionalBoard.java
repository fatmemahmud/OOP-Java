package ChessBoard;

import java.util.Vector;
import java.awt.Image;
import ChessGame.Player;
import Pieces.Pair;
import Pieces.Piece;

public class TraditionalBoard {

	// The player type (i.e. white or black)
    public Player player1;
    public Player player2;

	//board dimensions
	private  final int width = 10;
	private final int height = 10;
	public Grid [][] grid = new Grid[width][height];
    public int mouseX, mouseY;     //Mouse position
    public int turn;           //turn%2 is player1's turn, else it is player2's turn
    private MoveHolder undo;

    
    public TraditionalBoard() {

        undo = new MoveHolder();
        turn=0;    //player 1's turn
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				grid[i][j] = new Grid();
			}
		}
		
		//setup both players 
		player1 = new Player("white", grid);
		player2 = new Player("black", grid);
	
	}
    
	public void undo() {
		   //invalid undo
        if(turn ==0)
            return;

        undo.movePrev(grid);
        turn++;

    }
	public void forfeit() {
		if(turn%2==0)
            player1.king.isEaten= true;
       else
           player2.king.isEaten = true;
		
	}
	public Vector<Pair> getValidMoves() {

	       Vector<Pair> moves;

	        int p;
	        if(turn%2==0)
	            p =0;
	        else
	            p = 1;

	       Piece selected = selection();

	        if(selected != null)
	        {
	           moves = selected.addMoves(p, grid);
	           return moves;
	        }

	        return null;

	
	}
	public int getWidth() 
	{	return width;	}
	
	public int getHeight() 
	{	return height;	}
	
	public void moveSelectedPiece(int newX, int newY) {
		//Determines whether a valid piece is selected
        Piece pieceSelected = selection();
        boolean moved = false;

        if(pieceSelected != null)
        {

            //player1's turn
            if(turn%2 == 0)
            {
                moved = movePiece(pieceSelected, newX, newY, turn);

                if(moved)
                {

                    //update grid
                    grid[mouseX][mouseY].occupied= false;
                    grid[newX][newY].occupied= true;
                    grid[newX][newY].color = "white";

                    Piece eaten = player2.checkEaten(newX, newY);
                    undo.update(pieceSelected, eaten, "white",new Pair(mouseX, mouseY), new Pair(newX, newY) );
                    pieceSelected.selected = false;
                    turn++;
                }

            }
            //player2's turn
            else
            {
                moved = player2.movePiece(pieceSelected, newX, newY, turn, grid);
                if(moved)
                {

                    //update grid
                    grid[mouseX][mouseY].occupied= false;
                    grid[newX][newY].occupied= true;
                    grid[newX][newY].color = "black";

                    Piece eaten = player1.checkEaten(newX, newY);
                    undo.update(pieceSelected, eaten,"black" ,new Pair(mouseX, mouseY), new Pair(newX, newY) );
                    pieceSelected.selected = false;
                    turn++;
                }
            }
            printGrid();
        }
	

}

	private void printGrid() {
		System.out.println("Begin");
		for(int j = 0; j < height; j++)
		{
			for(int i =0; i < width;i++ )
			{
				if(grid[i][j].occupied)
				{
					if(grid[i][j].color.equals("white"))
						System.out.print( "W ");
					else
						System.out.print("B ");
				}
				else
					System.out.print(". ");
			}
			System.out.println();
		}
		System.out.println("End");
		
	}

	private boolean movePiece(Piece pieceSelected, int newX, int newY, int turn2) {
		// TODO Auto-generated method stub
		return false;
	}

	private Piece selection() {
		// TODO Auto-generated method stub
		return null;
	}

	public Piece getPieces(Player player12, char name, int index, Player player) {
		Piece p;
		switch (name) {
        case 'P':
        		if(player == player1)
        			{p= player1.pawns[index];}
        		else
        			{p= player2.pawns[index];}      		
                break;
        case 'C':
    			if(player == player1)
    				{p= player1.rooks[index];}
        		else
        			{p= player2.rooks[index];} 
    			break;
        case 'H':
        		if(player == player1)
        			{p= player1.knights[index];}
        		else
        			{p= player2.knights[index];}
        		break;
        case 'B':
	    		if(player == player1)
					{p= player1.bishops[index];}
				else
					{p= player2.bishops[index];}      		
		        break;
        case 'Q':
        		if(player == player1)
        			{p= player1.queen;}
        		else
        			{p= player2.queen;}      		
        		break;
        case 'K':
    			if(player == player1)
    				{p= player1.king;}
    			else
    				{p= player2.king;}      		
    			break;
   
        default : 
        		p = null;
        		System.out.println("Invalid getPiece Selection");
        		break;
		}//end switch case
		return p;
	}

	
}