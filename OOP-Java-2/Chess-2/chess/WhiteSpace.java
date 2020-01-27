package chess;

public class WhiteSpace extends Square{
	
	public WhiteSpace() {
		super("blank");
		symbol = "   ";
		color = null;
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
		return false;
	}

}
