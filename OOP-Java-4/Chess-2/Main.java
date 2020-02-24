import chess.Player;
import chess.Square;

import static chess.Board.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Plovdiv University Console Chess");

        String player1Name = getName(1, null);
        String player2Name = getName(2, player1Name);

        Player whitePly = new Player(player1Name, "white");
        Player blackPly = new Player(player2Name, "black");

        setup();

        while(true){

            for(int i = 1; i <= 2; i++){
                draw();

                int move[][] = new int[2][2];

                while(true){

                    if(i == 1){
                        move = whitePly.getMove();
                    }
                    else{
                        move = blackPly.getMove();
                    }

                    if(move[0][0] == -1){
                        System.out.println("Invalid location. Try again.");
                        continue;
                    }

                    int[] moveFrom = move[0];
                    int[] moveTo = move[1];
                    Square fromSquare = board[moveFrom[1]][moveFrom[0]];

                    boolean checkValue;
                    if(i == 1){
                        checkValue = fromSquare.checkMove(moveFrom, moveTo, "white", false);
                    }
                    else{
                        checkValue = fromSquare.checkMove(moveFrom, moveTo, "black", false);
                    }
                    if(checkValue){
                        update(moveFrom, moveTo);

                        if(i == 1){
                            if (checkForCheckOrMate("white") == "check"){
                                System.out.println("Check!");
                            }
                        }
                        else{
                            if (checkForCheckOrMate("black") == "check"){
                                System.out.println("Check!");
                            }
                        }
                        break;
                    }
                    System.out.println("Invalid move. Try again.");
                }
            }
        }
    }
}
