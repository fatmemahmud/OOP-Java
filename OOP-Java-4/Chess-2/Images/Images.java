package Images;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {

	public BufferedImage whitePawnImage;
	public BufferedImage whiteRookImage;
	public BufferedImage whiteKnightImage;
	public BufferedImage whiteBishopImage;
	public BufferedImage whiteQueenImage;
	public BufferedImage whiteKingImage;

	public BufferedImage blackPawnImage;
	public BufferedImage blackRookImage;
	public BufferedImage blackKnightImage;
	public BufferedImage blackBishopImage;
	public BufferedImage blackQueenImage;
	public BufferedImage blackKingImage;

	public Image whiteRooksImage;
	public Image blackRooksImage;
	public Image whiteKnightsImage;
	public Image blackKnightsImage;

	
	// Initialize all the images
	 
	public Images() {
		
		//white pawn
		try {
			whitePawnImage = ImageIO.read(new File("ChessPieces/White_pawn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white rook
		try {
			whiteRookImage = ImageIO.read(new File("ChessPieces/White_rook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white knight
		try {
			whiteKnightImage = ImageIO.read(new File("ChessPieces/White_knight.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white bishop
		try {
			whiteBishopImage = ImageIO.read(new File("ChessPieces/White_bishop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white queen
		try {
			whiteQueenImage = ImageIO.read(new File("ChessPieces/White_queen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white king
		try {
			whiteKingImage = ImageIO.read(new File("ChessPieces/White_king.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 
		//black pawn
		try {
			blackPawnImage = ImageIO.read(new File("ChessPieces/Black_pawn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black castle
		try {
			blackRookImage = ImageIO.read(new File("ChessPieces/Black_rook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black horse
		try {
			blackKnightImage = ImageIO.read(new File("ChessPieces/Black_knight.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black bishop
		try {
			blackBishopImage = ImageIO.read(new File("ChessPieces/Black_bishop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black queen
		try {
			blackQueenImage = ImageIO.read(new File("ChessPieces/Black_queen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black king
		try {
			blackKingImage = ImageIO.read(new File("ChessPieces/Black_king.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		}
		
	}


