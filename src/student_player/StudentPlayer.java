/*
    Yulia Volodina
    260745612
 */

package student_player;

import boardgame.Move;


import pentago_swap.PentagoMove;
import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;




/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260745612");
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move chooseMove(PentagoBoardState boardState) {


        Move move = null;

        //utilize the predefined step, first player win algorithm approach, if you are running as player 0.
        if (boardState.getTurnPlayer() == 0) {
            if (boardState.getTurnNumber() == 0 || boardState.getTurnNumber() == 1 || boardState.getTurnNumber() == 2 || boardState.getTurnNumber() == 3 || boardState.getTurnNumber() == 4) {
                move = MyTools.firstPlayerWin(boardState);
                return move;
            }
        }

        //If you are the second player or have completed the first five moves as first player, run MCTS
        MctsMove ai = new MctsMove(1000);
        Move move_mcts = ai.getMove(boardState);

        return move_mcts;
    }
}














