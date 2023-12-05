package scoremanagementsystem;

import java.util.*;

public class StudentManager {
    // 学生列表
    static List<Student> list = new ArrayList<>();

    // 添加学生
    static {
        list.add(new Student("001", "张三", "一班", 80, 90, 85));
        list.add(new Student("002", "李四", "一班", 90, 75, 80));
        list.add(new Student("003", "王五", "二班", 70, 80, 90));
        list.add(new Student("004", "赵六", "二班", 60, 75, 85));
        list.add(new Student("005", "小明", "一班", 90, 85, 85));
    }

    public static void StartStudentManager() {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("-----------------欢迎来到学生管理系统----------------");
            System.out.println("1.录入成绩");
            System.out.println("2.删除成绩");
            System.out.println("3.修改成绩");
            System.out.println("4.查询成绩");
            System.out.println("5.查询某门课程的平均分");
            System.out.println("6.查询某学生的班级排名");
            System.out.println("7.查询某门课程不同分数段的学生人数及学生信息");
            System.out.println("8.查询某学生的各课程分数，总分及其班级排名");
            System.out.println("9.输出全部学生信息");
            System.out.println("10.退出");
            System.out.println("请输入您的选择：");

            Scanner sc = new Scanner(System.in);
            //使用字符串格式，用户输入字符导致程序报错。
            String choose = sc.next();
            switch (choose) {
                case "1" -> addScore(list);
                case "2" -> deleteScore(list);
                case "3" -> updateScore(list);
                case "4" -> queryScore(list);
                case "5" -> courseAvg(list);
                case "6" -> studentRank(list);
                case "7" -> courseInfo(list);
                case "8" -> queryStudent(list);
                case "9" -> printAllInfo(list);
                case "10" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }


    private static void printAllInfo(List<Student> list) {
        System.out.println("学号\t姓名\t班级\t语文  \t数学  \t英语  \t总分  \t班级排名");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            String line = student.getId() + "\t" + student.getName() + "\t" + student.getClassName() + "\t"
                    + student.getChineseScore() + "\t" + student.getMathScore() + "\t" + student.getEnglishScore()
                    + "\t" + student.getTotalScore() + "\t" + calculateClassRanking(student.getId());
            System.out.println(line);
        }
    }

    //查询某学生的各课程分数，总分及其班级排名
    private static void queryStudent(List<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学生id");
        String id = sc.next();
        int index = getIndex(id);
        if (index < 0) {
            //id不存在，提示不存在，返回菜单
            System.out.println("id不存在");
            return;
        }
        System.out.println("学号\t姓名\t班级\t语文  \t数学  \t英语  \t总分  \t班级排名");
        Student s = findStudentById(id);
        String info = s.getId() + "\t" + s.getName() + "\t" + s.getClassName() + "\t"
                + s.getChineseScore() + "\t" + s.getMathScore() + "\t" + s.getEnglishScore()
                + "\t" + s.getTotalScore() + "\t" + calculateClassRanking(s.getId());
        System.out.println(info);
    }

    private static void chineseInfo(List<Student> list) {
        System.out.println("语文  \t学号  \t姓名  \t班级");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getChineseScore() + "  \t"
                    + s.getId() + "  \t" + s.getName() + "  \t" + s.getClassName());
        }
    }

    private static void mathInfo(List<Student> list) {
        System.out.println("数学  \t学号  \t  姓名  \t  班级");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getMathScore() + "  \t"
                    + s.getId() + "  \t" + s.getName() + "  \t" + s.getClassName());
        }
    }

    private static void englishInfo(List<Student> list) {
        System.out.println("英语  \t学号  \t  姓名  \t  班级");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getEnglishScore() + "  \t"
                    + s.getId() + "  \t" + s.getName() + "  \t" + s.getClassName());
        }
    }

    //查询某门课程不同分数段的学生人数及学生信息
    private static void courseInfo(List<Student> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要查询的课程");
            String course = sc.next();
            if (course.equals("语文")) {
                chineseInfo(list);
                break;
            } else if (course.equals("数学")) {
                mathInfo(list);
                break;
            } else if (course.equals("英语")) {
                englishInfo(list);
                break;
            } else {
                System.out.println("输入有误，请重新输入");
                continue;
            }
        }
    }

    private static void studentRank(List<Student> list) {
        System.out.println("请输入要查询的学生id");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int rank = calculateClassRanking(id);
        System.out.println("该学生的排名为：第" + rank + "名");
    }

    private static void courseAvg(List<Student> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要查询的课程平均分");
            String course = sc.next();
            if (course.equals("语文") || course.equals("数学") || course.equals("英语")) {
                double avg = calculateAverageScore(course);
                System.out.println(course + "课程的平均分是" + avg);
                break;
            } else {
                System.out.println("课程不存在，请重新输入");
                continue;
            }

        }
    }


    private static void queryScore(List<Student> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("查询成绩");
            System.out.println("请输入要查询成绩的学生id：");
            String id = sc.next();
            int index = getIndex(id);
            if (index >= 0) {
                //id存在，删除成绩
                Student s = list.get(index);
                System.out.println(s.getName() + "的成绩为： 语文：" + s.getChineseScore()
                        + ", 数学：" + s.getMathScore() + ", 英语：" + s.getEnglishScore());
                break;
            } else {
                //id不存在，提示不存在，返回菜单
                System.out.println("id不存在，请重新输入");
                continue;
            }
        }
    }


    private static void updateScore(List<Student> list) {
        System.out.println("修改成绩");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改成绩的学生id：");
            String id = sc.next();
            int index = getIndex(id);
            if (index < 0) {
                //id不存在，提示不存在，返回菜单
                System.out.println("id不存在，请重新输入");
                continue;
            }
            //id存在，删除成绩
            Student s = list.get(index);
            while (true) {
                System.out.println("请输入需要修改的成绩：语文/数学/英语");
                String course = sc.next();
                if (course.equals("语文")) {
                    System.out.println("请输入修改的分数");
                    double newScore = sc.nextDouble();
                    if (newScore < 0 || newScore > 100){
                        System.out.println("分数不符合规范，修改失败！");
                        return;
                    }
                    s.setChineseScore(newScore);
                    s.setTotalScore(newScore, s.getMathScore(), s.getEnglishScore());
                    System.out.println("修改成功！");
                    return;
                } else if (course.equals("数学")) {
                    System.out.println("请输入修改的分数");
                    double newScore = sc.nextDouble();
                    if (newScore < 0 || newScore > 100){
                        System.out.println("分数不符合规范，修改失败！");
                        return;
                    }
                    s.setMathScore(newScore);
                    s.setTotalScore(s.getChineseScore(), newScore, s.getEnglishScore());
                    System.out.println("修改成功！");
                    return;
                } else if (course.equals("英语")) {
                    System.out.println("请输入修改的分数");
                    double newScore = sc.nextDouble();
                    if (newScore < 0 || newScore > 100){
                        System.out.println("分数不符合规范，修改失败！");
                        return;
                    }
                    s.setEnglishScore(newScore);
                    s.setTotalScore(s.getChineseScore(), s.getMathScore(), newScore);
                    System.out.println("修改成功！");
                    return;
                } else {
                    System.out.println("输入有误，请重新输入！");
                    continue;
                }

            }
        }
    }

    private static void deleteScore(List<Student> list) {
        System.out.println("删除成绩");
        System.out.println("请输入要录入成绩的学生id：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(id);
        if (index >= 0) {
            //id存在，删除成绩
            Student s = list.get(index);
            System.out.println("请输入需要删除的成绩：语文/数学/英语");
            String course = sc.next();
            if (course.equals("语文")) {
                s.setChineseScore(0);
                System.out.println("删除成功！");
                return;
            } else if (course.equals("数学")) {
                s.setMathScore(0);
                System.out.println("删除成功！");
                return;
            } else if (course.equals("英语")) {
                s.setEnglishScore(0);
                System.out.println("删除成功！");
                return;
            }
        } else {
            //id不存在，提示不存在，返回菜单
            System.out.println("id不存在");
        }
    }

    //录入成绩
    public static void addScore(List<Student> list) {
        System.out.println("录入成绩");
        System.out.println("请输入要录入成绩的学生id：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(id);
        if (index >= 0) {
            while (true) {
                //id存在，录入成绩
                Student s = list.get(index);
                //判断录入的成绩是否合法
                double chinese = 0;
                while (true) {
                    System.out.println("请录入该学生的语文成绩");
                    chinese = sc.nextDouble();
                    if (!(chinese >= 0 && chinese <= 100)) {
                        System.out.println("成绩有误，请重新输入");
                        continue;
                    }
                    s.setChineseScore(chinese);
                    break;
                }
                double math = 0;
                while (true) {
                    System.out.println("请录入该学生的数学成绩");
                    math = sc.nextDouble();
                    if (!(math >= 0 && math <= 100)) {
                        System.out.println("成绩有误，请重新输入");
                        continue;
                    }
                    s.setMathScore(math);
                    break;
                }
                double english = 0;
                while (true) {
                    System.out.println("请录入该学生的英语成绩");
                    english = sc.nextDouble();
                    if (!(english >= 0 && english <= 100)) {
                        System.out.println("成绩有误，请重新输入");
                        continue;
                    }
                    s.setEnglishScore(english);
                    break;
                }
                s.setTotalScore(chinese, math, english);
                break;
            }
            //int i = calculateClassRanking(id);
        } else {
            //id不存在，提示不存在，返回菜单
            System.out.println("id不存在");
        }
    }

    //通过id获取索引
    public static int getIndex(String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            //比较集合中的id和要查询的id
            if (stu.getId().equals(id)) {
                //id相同返回索引
                return i;
            }
        }
        //查找不到id返回-1
        return -1;
    }

    /*// 添加学生
    public void addStudent(Student student) {
        list.add(student);
    }

    // 删除学生
    public void removeStudent(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                break;
            }
        }
    }

    // 修改学生信息
    public void updateStudent(String id, String name, String className, double chineseScore, double mathScore, double englishScore) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                Student student = list.get(i);
                list.set(i, new Student(id, name, className, chineseScore, mathScore, englishScore));
                break;
            }
        }
    }*/

    // 根据学号查询学生
    public static Student findStudentById(String id) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // 计算某门课程的平均分
    public static double calculateAverageScore(String courseName) {
        double sum = 0;
        int count = 0;
        for (Student student : list) {
            if (courseName.equals("语文")) {
                sum += student.getChineseScore();
            } else if (courseName.equals("数学")) {
                sum += student.getMathScore();
            } else if (courseName.equals("英语")) {
                sum += student.getEnglishScore();
            }
            count++;
        }
        return sum / count;
    }

    // 计算学生总分排名
    public static List<Student> calculateTotalRanking() {
        List<Student> rankingList = new ArrayList<>(list);
        Collections.sort(rankingList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double diff = o2.getTotalScore() - o1.getTotalScore();
                return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
            }
        });
        return rankingList;
    }

    // 计算学生班级排名
    public static int calculateClassRanking(String id) {
        double totalScore = findStudentById(id).getTotalScore();
        int count = 0;
        for (Student s : list) {
            if (s.getClassName().equals(findStudentById(id).getClassName()) && s.getTotalScore() > totalScore) {
                count++;
            }
        }
        return count + 1;
    }

    // 按学号排序输出全部学生信息
    public List<Student> sortByStudentId() {
        List<Student> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return sortedList;
    }

}
