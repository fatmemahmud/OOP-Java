package ChessBoard;

public abstract class Square {
	protected String symbol;
	public String color;
	public String type;
	public boolean occupied;
	
	public Square(String typeIn){
		type = typeIn;
	}
	
	String getSymbol(){
		return symbol;
	}
	public String getColor(){
		return color;
	}
	public String getType(){
		return type;
	}

	public abstract boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing);
}
