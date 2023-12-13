package competition;

public class Judge {
    private String name;
    private int score;


    public Judge() {
    }

    public Judge(String name, int score) {
        this.name = name;
        this.score = score;
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
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "Judge{name = " + name + ", score = " + score + "}";
    }
}
