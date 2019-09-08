/*
    Yulia Volodina
    260745612
 */
package student_player;

import java.util.Random;

import pentago_swap.PentagoMove;

import pentago_swap.PentagoBoardState;
import java.util.ArrayList;
public class Node {

        PentagoBoardState board;
        Node parent;
        int numOfSimulations = 0;
        Score score;
        ArrayList<Node> children = new ArrayList<>();
        ArrayList<PentagoMove> unexploredMoves;
        int player;
        PentagoMove moveUsedToGetToNode;

        public Node(Node parent, PentagoMove move, PentagoBoardState pbs) {
            this.parent = parent;
            this.moveUsedToGetToNode = move;
            this.unexploredMoves = pbs.getAllLegalMoves();
            this.score = new Score(0, 0);;
            this.player = pbs.getTurnPlayer();
        }

        public Node select() {
            Node selectedNode = this;
            double max = Integer.MIN_VALUE;

            for (Node child : getChildren()) {
                double uctFunction = getUct(child);

                if (uctFunction > max) {
                    max = uctFunction;
                    selectedNode = child;
                }
            }

            return selectedNode;
        }

        private double getUct(Node child) {
            double uctValue;

            if (child.getNumberOfSimulations() == 0) {
                uctValue = 1;
            } else {
                uctValue = (1.0 * child.getScoreForPlayer(getPlayer())) / (child.getNumberOfSimulations() * 1.0) + (Math.sqrt(2 * (Math.log(getNumberOfSimulations() * 1.0) / child.getNumberOfSimulations())));
            }
              // allow for unexplored variety
            Random r = new Random();
            uctValue += (r.nextDouble() / 10000000);
            return uctValue;
        }


        public Node expand(PentagoBoardState board) {
            if (!canStillExpand()) {
                return this;
            }
            //expand along a random unexplored move
            Random random = new Random();
            int moveIndex = random.nextInt(unexploredMoves.size());

            PentagoMove move = unexploredMoves.remove(moveIndex);
            board.processMove(move);
            Node child = new Node(this, move, board);
            children.add(child);
            return child;
        }

        public void propagate(Score score) {
            this.score.addScore(score);
            this.numOfSimulations++;
            if (parent != null) {
                parent.propagate(score);
            }
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public int getNumberOfSimulations() {
            return numOfSimulations;
        }

        public int getPlayer() {
            return player;
        }

        public double getScoreForPlayer(int player) {
            return score.getScoreForPlayer(player);
        }

        public boolean canStillExpand() {
            return unexploredMoves.size() > 0;
        }

        public Node getMostVisitedNode() {
            int mostVisitCount = 0;
            Node bestChild = null;

            for (Node child : getChildren()) {
                if (child.getNumberOfSimulations() > mostVisitCount) {
                    bestChild = child;
                    mostVisitCount = child.getNumberOfSimulations();
                }
            }

            return bestChild;
        }

        public PentagoMove getMoveUsedToGetToNode() {

            return moveUsedToGetToNode;
        }



    }



