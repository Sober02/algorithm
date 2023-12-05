package scoremanagementsystem;

public class Student {
    private String id; // 学号
    private String name; // 姓名
    private String className; // 班级
    private double chineseScore; // 语文成绩
    private double mathScore; // 数学成绩
    private double englishScore; // 英语成绩
    private double totalScore; // 总分


    // 构造函数
    public Student(String id, String name, String className, double chineseScore, double mathScore, double englishScore) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = chineseScore + mathScore + englishScore;
    }

    // 获取学号
    public String getId() {
        return id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 获取班级
    public String getClassName() {
        return className;
    }

    // 获取语文成绩
    public double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(double chineseScore) {
        this.chineseScore = chineseScore;
    }

    // 获取数学成绩
    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }


    // 获取英语成绩
    public double getEnglishScore() {
        return englishScore;
    }


    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public void setTotalScore(double chineseScore,double mathScore,double englishScore) {
        this.totalScore = chineseScore + mathScore + englishScore;
    }

    // 获取总分
    public double getTotalScore() {
        return totalScore;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", className = " + className + ", chineseScore = " + chineseScore + ", mathScore = " + mathScore + ", englishScore = " + englishScore + ", totalScore = " + totalScore + "}";
    }
}
