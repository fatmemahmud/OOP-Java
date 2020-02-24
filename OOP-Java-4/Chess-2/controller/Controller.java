package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.glass.events.MouseEvent;

import chess.TraditionalBoard;
import chessgame.GameViewer;
import javafx.event.ActionEvent;
import jdk.internal.util.xml.impl.Pair;
import pieces.ChessPiece;

public class Controller {

    static GameViewer viewer; // User interaction
    public static TraditionalBoard board;
    Controller()
    {
        board = new TraditionalBoard();
    }
   
    public static void main(String[] args) throws InterruptedException
    {
        Controller c = new Controller();
        viewer = new GameViewer();

    }

    public static JMenuBar getMenu() {
        JMenuBar menuBar;
        JMenu menu;
        ActionListener actionlistener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                char command =s.charAt(0);
                switch(command)
                {
                    case 'N':
                        viewer.updateScore(board.turn);
                        board = new TraditionalBoard();
                        viewer.pause = false;
                        viewer.repaint();
                        break;
                    case 'R':
                        board = new TraditionalBoard();
                        viewer.pause = false;
                        viewer.repaint();
                        break;
                    case 'P':
                        viewer.pause = !viewer.pause;
                        break;
                    case 'U':
                        board.undo();
                        viewer.repaint();
                        System.out.println("Undo !!!!");  //undo
                        break;
                    case 'Q':
                        board.forfeit();
                        viewer.updateScore(board.turn);
                        System.out.println("Quit!!");
                        break;

                }
            }

			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        };
        //Create the menu bar.
        menuBar = new JMenuBar();
        //Build the first menu.
        menu = new JMenu("Board");
        JMenuItem menuitem = new JMenuItem("Settings");
        menuitem = new JMenuItem("New Game");
        menuitem.setActionCommand("N");
        menuitem.addActionListener(actionlistener);
        menu.add(menuitem);
        menuitem = new JMenuItem("Restart");
        menuitem.setActionCommand("R");
        menuitem.addActionListener(actionlistener);
        menu.add(menuitem);
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Pause");
        cbMenuItem.setActionCommand("P");
        cbMenuItem.addActionListener(actionlistener);
        menu.add(cbMenuItem);
        menuitem = new JMenuItem("Quit");
        menuitem.setActionCommand("Q");
        menuitem.addActionListener(actionlistener);
        menu.add(menuitem);
        menuBar.add(menu);
        menu = new JMenu("Edit");
        menuitem = new JMenuItem("Settings");
        menuitem = new JMenuItem("Undo");
        menuitem.setActionCommand("U");
        menuitem.addActionListener(actionlistener);
        menu.add(menuitem);
        menuBar.add(menu);
        return menuBar;
    }
    public static MouseListener getMouse() {
        MouseListener mouselistener = new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                if(!viewer.pause)
                {
                    //gets the x and y coordinates on the board
                    int newx = (int) ((board.getWidth() * e.getX()) / viewer.getWidth() ) ;
                    int newy = (int) ((board.getHeight() * (e.getY()-40)) / viewer.getHeight() );
                    boolean movePiece = e.isShiftDown();
                    if(movePiece)
                    {
                        board.moveSelectedPiece(newx, newy);
                        movePiece = false;
                    }
                    else
                    {
                        viewer.mouseX=newx;
                        viewer.mouseY=newy;
                        board.mouseX=newx;
                        board.mouseY=newy;
                        Vector<Pair> moves = board.getValidMoves();
                        viewer.addMoves(moves);
                        viewer.repaint();
                    }
                }
                //pause is true
                else
                {
                    viewer.pause = true;
                }
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        };
        return mouselistener;

    }
  
    public ChessPiece getPieces(int player, char name, int index )
    {
        if(player ==1)
            return board.getChessPiece(board.player1, name, index);
        else
            return board.getChessPiece(board.player2, name, index);
    }
 
    public int getW()
    { return board.getWidth(); }

    public int getH()
    { return board.getHeight(); }


    public int gameOver()
    {
        if(board.player1.king.isEaten)
        {
            return 1;

        }
        else if(board.player2.king.isEaten)
        {
            return 2;
        }
        else
            return -1;
    }
}
