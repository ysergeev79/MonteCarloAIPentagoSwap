/*
    Yulia Volodina
    260745612
 */

package student_player;

import boardgame.Move;

import pentago_swap.PentagoMove;
import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.RandomPentagoPlayer;


import java.util.LinkedList;


public class PlaySimulations {


              PentagoBoardState boardState;
              int currentPlayer;

              public PlaySimulations(PentagoBoardState pbs){

                  this.boardState = pbs;
                  this.currentPlayer = pbs.getTurnPlayer();
              }



    public Score playGame(RandomPentagoPlayer player1, RandomPentagoPlayer player2) {
        LinkedList<RandomPentagoPlayer> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        while (!boardState.gameOver()) {
            PentagoPlayer player = players.get(currentPlayer);

            Move move = player.chooseMove(boardState);
            boardState.processMove((PentagoMove)move);
            currentPlayer = (currentPlayer == 0) ? 1 : 0;
        }
           if(boardState.getWinner() == 0 ) {
               return new Score(1,-1);
           }else if(boardState.getWinner() == 1 )  {
               return new Score(-1,1);
           }
           return new Score(0,0);

    }


}
