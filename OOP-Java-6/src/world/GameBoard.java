package world;

import java.util.ArrayList;

import javax.tools.DocumentationTool.Location;

import ChessBoard.Grid;
import Pieces.Bishop;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;

public class GameBoard extends World<Piece> {  
	    private static final String DEFAULT_MESSAGE = "Click on a piece to make a move.";
	    private int whoseTurnCounter;
		private boolean hasPickedPiece;
		private Piece selectedPiece;
		
		private ArrayList<Piece> whitePieces;
		private ArrayList<Piece> blackPieces;
		private ArrayList<Piece> whiteTakenPieces;
		private ArrayList<Piece> blackTakenPieces;
		
	
		public GameBoard(){
			super(10,10);
			whoseTurnCounter =0;
			hasPickedPiece = false;
			whitePieces = new ArrayList<Piece>();
			blackPieces = new ArrayList<Piece>();
			whiteTakenPieces = new ArrayList<Piece>();
			blackTakenPieces = new ArrayList<Piece>();
			selectedPiece = null;
		}
	    
		
		public void setUpPieces(){
			Piece currentPiece;
			Piece currentBlackPiece;
			Piece currentWhitePiece;
			String WHITE = "White";
			String BLACK = "Black";
			
			for(int i=0;i<8;i++){
				currentPiece = new Pawn();
				currentPiece.placeSelfInGrid(new Location(6,i));
				whitePieces.add(currentPiece);
				
				currentPiece = new Pawn(BLACK);
				curentPiece.placeSelfInGrid(new Location(1,i));
				blackPieces.add(currentPiece);
				
				if(i==0 || i == 7){
					currentPiece = new Bishop(WHITE);
					currentPiece = new Bishop(BLACK);
				} else if (i==1 || i == 6){
					currentWhitePiece = new Knight(WHITE);
					currentBlackPiece = new Knight(BLACK);
				} else if(i == 2 || i == 5){
					currentWhitePiece = new Bishop(WHITE);
					currentBlackPiece = new Bishop(BLACK);
				} else if (i == 3){
					currentWhitePiece = new King(WHITE);
					currentBlackPiece = new Queen(BLACK);
				}else if(i == 4){
					currentWhitePiece = new Queen(WHITE);
					currentBlackPiece = new King(BLACK);
				}
				
				currentWhitePiece.placeSelfInGrid(new Location(7,i));
				whitePieces.add(currentPiece);
				
				currentBlackPiece.placeSelfInGrid(new Location(0,i));
				blackPieces.add(currentPiece);
			
			public void setHasSelectedPiece()
			{
				if(hasSelectedPiece){
					hasSelectedPiece = false;
				} else {
					hasSelectedPiece = true;
				}
			}
			
			
			public String whoseTurn()
			{
				if(whoseTurnCounter % 2 == 0){
					return "White";
				} 
				return "Black";
			}
			
			
			public boolean isCorrectColor(Piece selectedPiece){
				if (selectedPiece.getColor().equals(whoseTurn())){
					return true;
				}
				return false;
			}
			
			
			public boolean whiteCheck(){
				boolean check=false;
				 return check;
			}
		
			public boolean blackCheck(){
				boolean check=false;
				 return check;
			}
			
			
			public boolean blackCheckMate(){
				boolean checkMate=false;
				 return checkMate;
			}
			
			public boolean whiteCheckMate(){
				boolean checkMate=false;
				 return checkMate;
			}
			
			
		    public boolean locationClicked(Location loc)
		    {
		       if(!hasPickPiece)
		       {
		    	   if(getGrid().get(loc) == null)
		    	   {
		    		   setMessage("There is not a piece in that location");
		    		   return null;
		    	   }
		    	   
		    	   selectedPiece = getGrid().get(loc);
		    	   if(isCorrectColor(selectedPiece))
		    	   {
		    		   setHasSelectedPiece();
		    		   for (Location currentLocation: selectedPiece.getPossibleMoveLocations())
		    		   {
		    			   getFrame().highlightLocation(currentLocation);
		    		   }
		    	   } else {
		    		   setMessage("It is " + whoseTurn() + "'s turn.");
		    	   }
		       } else {
		    	   if(selectedPiece.getLocation().equals(loc))
		    	   {
		    		   selectedPiece = null;
		    		   setHasSelectedPiece();
		    		   
		    	   }
		    	   else if(!isPossibleMoveLocation(loc, selectedPiece.getPossibleMoveLocations()))
		    	   {
		    		   setMessage("That is not a valid move location for that piece");
		    	   } else {
		    		   if(getGrid().get(loc) != null){
		    			   if (tempPiece.getColor().equals("Black"))
		    				   takeBlackPiece(loc);
		    			   else 
		    				   takeWhitePiece(loc);
		    		   }
		    		   selectedPiece.moveTo(loc);
		    	   }
		       }
		       
		    }
		    
		    
		    public void takeWhitePiece(Location loc)
		    {
		    	for(int i=0;i<whitePieces.size();i++)
		    	{
		    		if (whitePieces.get(i).getLocation().equals(loc)
		    		{
		    			whitePieces.get(i).removeSelfFromGrid();
		    			whiteTakenPieces.add(whitePieces.get(i));
		    			whitePieces.remove(i);
		    			
		    		}
		    	}
		    }
		   
		    public void takeBlackPiece(Location loc)
		    {
		    	for(int i=0;i<blackPieces.size();i++)
		    	{
		    		if (blackPieces.get(i).getLocation().equals(loc)
		    		{
		    			blackPieces.get(i).removeSelfFromGrid();
		    			blackTakenPieces.add(blackPieces.get(i));
		    			blackPieces.remove(i);
		    			
		    		}
		    	}
		    }
		    public boolean isPossibleMoveLocation(Location loc, ArrayList<Location> locs)
		    {
		    	for(Location currentLocation :locs)
		    	{
		    		if(currentLocation.equals(loc))
		    			return true;
		    	}
		    	return false;
		    }
		    
		    public void show()
		    {
		    	if (getMessage() == null)
		    		setMessage(DEFAULT_MESSAGE);
		    	super.show();
		    }

		    public void step()
		    {
		        Grid<Actor> gr = getGrid();
		        ArrayList<Actor> actors = new ArrayList<Actor>();
		        for (Location loc : gr.getOccupiedLocations())
		            actors.add(gr.get(loc));
	
		        for (Actor a : actors)
		        {
		            
		            if (a.getGrid() == gr)
		                a.act();
		        }
		    }

		   
		    public void add(Location loc, Actor occupant)
		    {
		        occupant.putSelfInGrid(getGrid(), loc);
		    }

		   
		    public Actor remove(Location loc)
		    {
		        Actor occupant = getGrid().get(loc);
		        if (occupant == null)
		            return null;
		        occupant.removeSelfFromGrid();
		        return occupant;
		    }		
	}
		
