package chess;
import java.awt.Image;


import pieces.ChessPiece;
import pieces.Pair;


public class TraditionalBoard implements ChessBoard{
	
	 private static final int turn = 0;
	
	public Player player1;
    public Player player2;
    
	private  final int width = 8;
	private final int height = 8;
	public Square [][] grid = new Square[width][height];
    public int mouseX, mouseY;
	@Override
	public Player getPieces(Player player, char name, int index) {

		ChessPiece p;
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
    	
        default : 
        		p = null;
        		System.out.println("Invalid getPiece Selection");
        		break;
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void moveSelectedPiece(int newX, int newY, Object undo) 
	{ //Determines whether a valid piece is selected
        ChessPiece pieceSelected = selection();
        boolean moved = false;

        if(pieceSelected != null)
        {

            //player1's turn
            if(turn%2 == 0)
            {
                moved = moveChessPiece(pieceSelected, newX, newY, turn);

                if(moved)
                {

                    //update grid
                    grid[mouseX][mouseY].occupied= false;
                    grid[newX][newY].occupied= true;
                    grid[newX][newY].color = "white";

                    ChessPiece eaten = player2.checkEaten(newX, newY);
                    undo.update(pieceSelected, eaten, "white",new Pair(mouseX, mouseY), new Pair(newX, newY) );
                    pieceSelected.selected = false;
                    turn++;
                
                }
            }
            }
            //player2's turn
            else
            {
                moved = player2.moveChessPiece(pieceSelected, newX, newY, turn, grid);
                if(moved)
                {

                    //update grid
                    grid[mouseX][mouseY].occupied= false;
                    grid[newX][newY].occupied= true;
                    grid[newX][newY].color = "black";

                    ChessPiece eaten = player1.checkEaten(newX, newY);
                    undo.update(pieceSelected, eaten,"black" ,new Pair(mouseX, mouseY), new Pair(newX, newY) );
                    pieceSelected.selected = false;
                    turn++;
		
                }
              }
	private boolean moveChessPiece(ChessPiece pieceSelected, int newX, int newY, int turn2) {
		
		
		// TODO Auto-generated method stub
		return false;
	}
	private boolean movePiece(ChessPiece pieceSelected, int newX, int newY, int turn2) {
		// TODO Auto-generated method stub
		return false;
	}
	private ChessPiece selection() {
		

        if(turn%2==0)
            return player1.validChessPieceSelected(mouseX, mouseY);
        else
            return player2.validChessPieceSelected(mouseX, mouseY);
	}
	@Override
	public void undo() {
		 if(turn ==0)
	            return;


	
		// TODO Auto-generated method stub
		
	}
	@Override
	public void forfeit() {
		

        if(turn%2==0)
             player1.king.isEaten= true;
        else
            player2.king.isEaten = true;
	
		// TODO Auto-generated method stub
		
	}
	@Override
	public void printGrid() {
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
	}
		// TODO Auto-generated method stub
	@Override
	public void moveSelectedPiece(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}
}

