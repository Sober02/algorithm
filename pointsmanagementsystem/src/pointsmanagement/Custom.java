package pointsmanagement;

public class Custom {
    //属性：姓名、年龄、消费积分
    private String id;
    private String name;
    private int age;
    private int bonusPoints;


    public Custom() {
    }

    public Custom(String id, String name, int age, int bonusPoints) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bonusPoints = bonusPoints;
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
     * @return bonusPoints
     */
    public int getBonusPoints() {
        return bonusPoints;
    }

    /**
     * 设置
     * @param bonusPoints
     */
    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public void addBonusPoints(int points){
        this.bonusPoints += points;
    }

    public void subtractBonusPoints(int points){
        this.bonusPoints -= points;
    }

    public String toString() {
        return "Custom{id = " + id + ", name = " + name + ", age = " + age + ", bonusPoints = " + bonusPoints + "}";
    }
}
