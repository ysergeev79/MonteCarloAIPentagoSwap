/*
    Yulia Volodina
    260745612
 */
package student_player;

import java.util.HashMap;

public class Score {


    HashMap<Integer, Integer> scores = new HashMap<>();
    public Score(int score1, int score2){
        scores.put(0, score1);
        scores.put(1, score2);
    }

    public HashMap<Integer, Integer> getScore(){
        return scores;
    }

    public int getScoreForPlayer(int playerNumber){
        return scores.get(playerNumber);
    }

    public void addScore(Score score) {
        scores.put(0, scores.get(0) + score.getScoreForPlayer(0));
        scores.put(1, scores.get(1) + score.getScoreForPlayer(1));
    }
}

