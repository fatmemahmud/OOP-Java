package ChessGame;


import ChessBoard.Grid;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;


public class Player {
	
	public Pawn pawns []= new Pawn[4];
	public Rook rooks [] = new Rook[2];
	public Knight knights [] = new Knight[2];
	public Bishop bishops [] = new Bishop[2];
	public King king;
	public Queen queen;
	public String color;
	private Knight[] knight;
	

	
	public Player(String type, Grid [][] grid) 
	{
		color = type;
		if(type.equals("white"))
		{
			setupWhitePieces( grid);
		}
		else
		{
			setupBlackPieces(grid);
		}
	}

	
	
	private void setupWhitePieces(Grid [][] g) 
	{	
		int i;
		//set up pawns
		for(i = 0; i < pawns.length; i++)
		{
			pawns[i]= new Pawn();
			pawns[i].positions.setCoords(i+2, 6);
			g[i+2][6].color="white";
			g[i+2][6].occupied = true;
		}

		//rooks
		for(i = 0; i < 2; i++)
		{
			rooks[i] = new Rook();
			if(i == 0)
			{
				rooks[i].positions.setCoords(0, 7);
				g[0][7].color="white";
				g[0][7].occupied = true;
			}
			else
			{
				rooks[i].positions.setCoords(7, 7);
				g[7][7].color="white";
				g[7][7].occupied = true;
			}
		}
		
		//knight
		for(i = 0; i < 2; i++)
		{
			knight[i] = new Knight();
			if(i == 0)
			{
				knight[i].positions.setCoords(1, 7);
				g[1][7].color="white";
				g[1][7].occupied = true;
			}
			else
			{
				knight[i].positions.setCoords(6, 7);
				g[6][7].color="white";
				g[6][7].occupied = true;
			}
		}
		
		
		//bishops
		for(i = 0; i < 2; i++)
		{
			bishops[i] = new Bishop();
			if(i == 0)
			{
				bishops[i].positions.setCoords(2, 7);
				g[2][7].color="white";
				g[2][7].occupied = true;
			}
			else
			{
				bishops[i].positions.setCoords(5, 7);
				g[5][7].color="white";
				g[5][7].occupied = true;
			}
		}
		
		//king
		king = new King();
		king.positions.setCoords(4, 7);
		g[4][7].color="white";
		g[4][7].occupied = true;
		
		//queen
		queen = new Queen();
		queen.positions.setCoords(3, 7);
		g[3][7].color="white";
		g[3][7].occupied = true;
		
	

	}

	
	private void setupBlackPieces( Grid [][] g) 
	{
		int i;
		for(i = 0; i < pawns.length; i++)
		{
			pawns[i]= new Pawn();
			pawns[i].positions.setCoords(i+2, 1);
			g[i+2][1].color="black";
			g[i+2][1].occupied = true;
		}
		
		//Rook

		for(i = 0; i < 2; i++)
		{
			rooks[i] = new Rook();
			if(i == 0)
			{
				rooks[i].positions.setCoords(0, 7);
				g[0][7].color="black";
				g[0][7].occupied = true;
			}
			else
			{
				rooks[i].positions.setCoords(7, 7);
				g[7][7].color="black";
				g[7][7].occupied = true;
			}
		}
		
		//knight
		for(i = 0; i < 2; i++)
		{
			knight[i] = new Knight();
			if(i == 0)
			{
				knight[i].positions.setCoords(1, 7);
				g[1][7].color="black";
				g[1][7].occupied = true;
			}
			else
			{
				knight[i].positions.setCoords(6, 7);
				g[6][7].color="black";
				g[6][7].occupied = true;
			}
		}
		
		//bishops
		for(i = 0; i < 2; i++)
		{
			bishops[i] = new Bishop();
			if(i == 0)
			{
				bishops[i].positions.setCoords(2, 0);
				g[2][0].color="black";
				g[2][0].occupied = true;
			}
			else
			{
				bishops[i].positions.setCoords(5, 0);
				g[5][0].color="black";
				g[5][0].occupied = true;
			}
		}
		
		//king
		king = new King();
		king.positions.setCoords(4, 0);
		g[4][0].color="black";
		g[4][0].occupied = true;
		
		//queen
		queen = new Queen();
		queen.positions.setCoords(3, 0);
		g[3][0].color="black";
		g[3][0].occupied = true;
		
		
		
	}



	public Piece validPieceSelected(int mouseX, int mouseY) 
	{
		int index;
		for(index = 0; index < pawns.length; index++)
		{	
			if( (mouseX == pawns[index].positions.getX()) && (mouseY == pawns[index].positions.getY()) )
			{
				pawns[index].selected = true;
				return pawns[index];
			}
		}
			
		for(index = 0; index < rooks.length; index++)
		{	
			if( (mouseX == rooks[index].positions.getX()) && (mouseY == rooks[index].positions.getY()) )
			{
				rooks[index].selected = true;
				return rooks[index];
			}
		}
		
		for(index = 0; index < knights.length; index++)
		{	
			if( (mouseX == knights[index].positions.getX()) && (mouseY == knights[index].positions.getY()) )
			{
				knights[index].selected = true;
				return knights[index];
			}
		}
		
		for(index = 0; index < bishops.length; index++)
		{	
			if( (mouseX == bishops[index].positions.getX()) && (mouseY == bishops[index].positions.getY()) )
			{
				bishops[index].selected = true;
				return bishops[index];
			}
		}
		
		if( (mouseX == queen.positions.getX()) && (mouseY == queen.positions.getY()) )
		{
			queen.selected = true;
			return queen;
		}
		if( (mouseX == king.positions.getX()) && (mouseY == king.positions.getY()) )
		{
			king.selected = true;
			return king;
		}
		
		
		
		return null;
	}



	public boolean movePiece(Piece p, int newX, int newY, int player, Grid[][] g) 
	{
		
		if(p.canMove(newX, newY, player, g))
		{
			p.move(newX, newY);
			return true;
		}
		
		return false;
	}



	public Piece checkEaten(int newX, int newY)
	{
		int i;
		for(i = 0; i < pawns.length; i++)
		{	
			if((newX == pawns[i].positions.getX()) && (newY == pawns[i].positions.getY()))
			{
				pawns[i].isEaten = true;
				return pawns[i];
			}
		}
		
			
		
		//rooks
		for(i = 0; i < rooks.length; i++)
		{
			if((newX == rooks[i].positions.getX()) && (newY == rooks[i].positions.getY()))
			{
				rooks[i].isEaten = true;
				return rooks[i];
			}
		}
		
		//knights
		for(i = 0; i < knights.length; i++)
		{
			if((newX == knights[i].positions.getX()) && (newY == knights[i].positions.getY()))
			{
				knights[i].isEaten = true;
				return knights[i];
			}
		}
		
		//bishops
		for(i = 0; i < bishops.length; i++)
		{
			if((newX == bishops[i].positions.getX()) && (newY == bishops[i].positions.getY()))
			{
				bishops[i].isEaten = true;
				return bishops[i];
			}

		}
		
		//king
		if((newX == king.positions.getX()) && (newY == king.positions.getY()))
		{
			king.isEaten = true;
			return king;
		}

		if((newX == queen.positions.getX()) && (newY == queen.positions.getY()))
		{
			queen.isEaten = true;
			return queen;
		}

        return null;

	}
}
