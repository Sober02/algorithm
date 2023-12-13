package competition;

import java.util.ArrayList;

public class Singer {
    private String id;
    private String name;
    private int age;
    private ArrayList<Integer> scores;
    private int finalScore;
    private ScoreRecord scoreRecords;


    public Singer() {
    }

    public Singer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
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

    public ScoreRecord getScoreRecords() {
        return scoreRecords;
    }

    public void setScoreRecords(ScoreRecord scoreRecords) {
        this.scoreRecords = scoreRecords;
    }

    public String toString() {
        return "Singer{id = " + id + ", name = " + name + ", age = " + age + ", scores = " + scores + ", finalScore = " + finalScore + "}";
    }
}
