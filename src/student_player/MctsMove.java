/*
    Yulia Volodina
    260745612
 */
package student_player;


import pentago_swap.PentagoMove;
import pentago_swap.PentagoBoardState;
import pentago_swap.RandomPentagoPlayer;


public class MctsMove {


    public int maxTime;

    public MctsMove(int time) {
        this.maxTime = time;
    }

    public PentagoMove getMove(PentagoBoardState board) {
        Node rootNode = new Node(null, null, board);
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < maxTime) {
            //clone the bord so as not to ruin the states during simulations
            PentagoBoardState boardCopy = (PentagoBoardState)board.clone();
            Node node = select(rootNode, boardCopy); //select a node
            node = node.expand(boardCopy); //expand the node
            Score score = rollout(boardCopy); //obtain the reward
            node.propagate(score); //propagate the reward back
        }

        Node mostVisitedChild = rootNode.getMostVisitedNode(); //the child that is most visited will be used for the UCT
        return mostVisitedChild.getMoveUsedToGetToNode(); //returns the move used to get to the given node
    }

    private Node select(Node node, PentagoBoardState boardCopy) {
        while (!node.canStillExpand() && !boardCopy.gameOver()) {
            node = node.select();
            PentagoMove move = node.getMoveUsedToGetToNode();
            if (move != null) {
                boardCopy.processMove(move);
            }
        }

        return node;
    }

    private Score rollout(PentagoBoardState boardCopy) {
        RandomPentagoPlayer randomPlayer1 = new RandomPentagoPlayer();
        RandomPentagoPlayer randomPlayer2 = new RandomPentagoPlayer();
        PlaySimulations simulatedGame = new PlaySimulations(boardCopy);
        Score score = simulatedGame.playGame(randomPlayer1, randomPlayer2);

        return score;
    }
}

















