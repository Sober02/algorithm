package competition;

import java.util.ArrayList;

public class ScoreRecord {
    private ArrayList<Integer> scores;
    private int maxScore;
    private int minScore;
    private int finalScore;


    public ScoreRecord() {
    }

    public ScoreRecord(ArrayList<Integer> scores, int maxScore, int minScore, int finalScore) {
        this.scores = scores;
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.finalScore = finalScore;
    }

    /**
     * 获取
     * @return scores
     */
    public ArrayList<Integer> getScores() {
        return scores;
    }

    /**
     * 设置
     * @param scores
     */
    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    /**
     * 获取
     * @return maxScore
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * 设置
     * @param maxScore
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * 获取
     * @return minScore
     */
    public int getMinScore() {
        return minScore;
    }

    /**
     * 设置
     * @param minScore
     */
    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    /**
     * 获取
     * @return finalScore
     */
    public int getFinalScore() {
        return finalScore;
    }

    /**
     * 设置
     * @param finalScore
     */
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public String toString() {
        return "ScoreRecord{scores = " + scores + ", maxScore = " + maxScore + ", minScore = " + minScore + ", finalScore = " + finalScore + "}";
    }
}
