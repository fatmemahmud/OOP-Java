package chessgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.sun.xml.internal.ws.api.server.Container;

import Images.Images;
import controller.Controller;
import pieces.ChessPiece;
import pieces.Pair;

public class GameViewer extends JPanel {


    public int mouseX, mouseY;//Mouse position
    public boolean pause;//if game is paused
    private Images pieces;//Image class
    private int xDimensions, yDimensions;
    private Controller controller;
    private static JFrame frame; // The frame on which the board is displayed
    private static JFrame info;
    private static JFrame scoreBoard;
    private String p1Name;
    private String p2Name;
    private int p1Score;
    private int p2Score;
    private Vector<Pair>moves;



     public void initializeBoard()
    {

        pieces = new Images();//initialize images
        pause = false;
    }


    private void setupFrame()
    {
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(550,550);
        frame.setJMenuBar(Controller.getMenu());
        frame.addMouseListener(Controller.getMouse());
        frame.setVisible(true);
    }


    public void paint(Graphics g)
    {

        //displays Chess board
        boardBackground(g);
        highlightMoves(g);
        displayPieces(g);
        GameOver(g);
        repaint();


    }

    private void boardBackground(Graphics g)
    {

        // 8X8 Board
        xDimensions=( getWidth() / controller.getW());
        yDimensions=( getHeight()/ controller.getH());

        int count = 0;
        //BLack and white Background squares
        for(int i=0; i< controller.getW();i++)
        {
            for (int j=0; j<controller.getH(); j++)
            {
                if(count%2==0)
                {
                    g.setColor(new Color(255,204,153));
                    g.fillRect(i * xDimensions, j * yDimensions, xDimensions, yDimensions);
                }
                else
                {
                    g.setColor(new Color(153,76,0));
                    g.fillRect(i * xDimensions, j * yDimensions, xDimensions, yDimensions);
                }
                count++;
            }
            count++;
        }

        //Highlight the square clicked by user
        g.setColor(Color.yellow);
        g.drawRect(mouseX * xDimensions, mouseY * yDimensions, xDimensions, yDimensions);
    }


    private void displayPieces(Graphics g)
    {

        //Player1's pieces display
        getPieces(g, 1, 'P', 4);
        getPieces(g, 1, 'C', 2);
        getPieces(g, 1, 'B', 2);
        getPieces(g, 1, 'H', 2);
        getPieces(g, 1, 'K', 1);
        getPieces(g, 1, 'Q', 1);
        getPieces(g, 1, 'W', 2);
        getPieces(g, 1, 'A', 2);

        //Player2's pieces display
        getPieces(g, 2, 'P', 4);
        getPieces(g, 2, 'C', 2);
        getPieces(g, 2, 'B', 2);
        getPieces(g, 2, 'H', 2);
        getPieces(g, 2, 'K', 1);
        getPieces(g, 2, 'Q', 1);
        getPieces(g, 2, 'W', 2);
        getPieces(g, 2, 'A', 2);


        if(pause)
        {
            g.setColor( new Color(255, 55, 0) );
            Font p3= new Font("Algerian",Font.PLAIN,100);
            g.setFont(p3);
            g.drawString("Paused", getWidth()/3 - 100,getHeight()/2);
        }

    }


 
    private void getPieces(Graphics g, int player, char name, int numElements)
    {

        Image img;
        switch (name) {
            case 'P':
                if(player == 1)
                {img = pieces.whitePawnImage;}
                else
                {img = pieces.blackPawnImage;}
                break;
            case 'C':
                if(player ==1)
                    img = pieces.whiteRooksImage;
                else
                    img = pieces.blackRooksImage;
                break;
            case 'H':
                if(player == 1)
                    img = pieces.whiteKnightsImage;
                else
                    img = pieces.blackKnightsImage;
                break;
            case 'B':
                if(player == 1)
                    img = pieces.whiteBishopImage;
                else
                    img = pieces.blackBishopImage;
                break;
            case 'Q':
                if(player == 1)
                    img = pieces.whiteQueenImage;
                else
                    img = pieces.blackQueenImage;
                break;
            case 'K':
                if(player == 1)
                    img = pieces.whiteKingImage;
                else
                    img = pieces.blackKingImage;
                break;
      
            default :
                img = pieces.whitePawnImage;
                System.out.println("Invalid Image Selection");
                break;
        }//end switch case

        //player1 (white pieces)
     

    }




    public void highlightMoves(Graphics g)
    {
        if(moves != null)
        {
            for(int i = 0; i < moves.size(); i++)
            {
                Pair p = moves.elementAt(i);
                //Highlight the square clicked by user
                g.setColor(Color.red);
                g.fillRect(p.getX() * xDimensions, p.getY() * yDimensions, xDimensions, yDimensions);
            }
        }
    }
    public void GameOver(Graphics g)
    {
        int over = controller.gameOver();

        if(over == 1)
        {
            g.setColor(Color.GREEN);
            Font p3= new Font("Algerian",Font.PLAIN,50);
            g.setFont(p3);
            g.drawString("Player 2 Wins!", getWidth() / 3 - 100, getHeight() / 3);
            pause = true;
        }
        else if(over == 2)
        {
            g.setColor(Color.GREEN);
            Font p3= new Font("Algerian",Font.PLAIN,50);
            g.setFont(p3);
            g.drawString("Player 1 Wins!", getWidth() / 3 - 100, getHeight() / 3);

            pause = true;
        }
    }

}
