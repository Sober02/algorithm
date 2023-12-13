package competition;

import java.util.*;

public class CampusSingerContest {
    public CampusSingerContest() {
    }

    //需要一个集合存储比赛选手
    static ArrayList<Singer> list = new ArrayList<>();


    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------欢迎来到校园歌手大赛管理系统----------------");
            System.out.println("1.添加选手信息");
            System.out.println("2.删除选手信息");
            System.out.println("3.修改选手信息");
            System.out.println("4.展示选手信息");
            System.out.println("5.录入选手分数");//在10个评委中找出最公平（最接近平均分）和最不公平的评委
            System.out.println("6.展示选手比赛成绩");//保存每位歌手比赛时的所有评委分数，包括最高分，最低分和最后得分，并对比赛结果进行排序输出:“
            System.out.println("7.退出");
            System.out.println("请输入您的选择：");

            String choose = sc.next();
            switch (choose) {
                case "1" -> addSinger(list);
                case "2" -> deleteSinger(list);
                case "3" -> updateSinger(list);
                case "4" -> showSingerInfo(list);
                case "5" -> addSingerScores(list);
                case "6" -> showSingerScores(list);
                case "7" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private void showSingerScores(ArrayList<Singer> list) {
        System.out.println("姓名\t  最高分  \t最低分  \t最后得分  ");
        for (Singer singer : list) {
            ScoreRecord scoreRecord = singer.getScoreRecords();
            System.out.println(singer.getName() + "  \t  " + scoreRecord.getMaxScore() + "  \t  "
                    + scoreRecord.getMinScore() + "  \t  " + scoreRecord.getFinalScore());
            System.out.println("所有评委分数：" + scoreRecord.getScores());
            System.out.println("-------------------------");
        }
        // 对比赛结果进行排序输出
        Collections.sort(list, (o1, o2) -> o2.getFinalScore() - o1.getFinalScore());
        System.out.println("比赛结果排序：");
        for (int i = 0; i < list.size(); i++) {
            Singer singer = list.get(i);
            System.out.println((i+1) + ". " + singer.getName() + "（得分：" + singer.getScoreRecords().getFinalScore() + "）");
        }
    }

    private void addSingerScores(ArrayList<Singer> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入选手的id：");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index < 0) {
                System.out.println("id不存在，请重新输入！");
                continue;
            }
            //计算总分
            int totalScore = 0;
            //存在，录入成绩
            ArrayList<Integer> scoreList = new ArrayList<>();
            //评委
            ArrayList<Judge> judgeList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                System.out.println("请第" + i + "位评委打分：");
                String strScore = sc.nextLine();
                int score = Integer.parseInt(strScore);
                //添加进成绩集合
                scoreList.add(score);
                Judge j = new Judge("评委" + i, score);
                judgeList.add(j);
                totalScore += score;
            }
            //平均分
            int avg = totalScore / 10;
            Singer s = list.get(index);
            s.setScores(scoreList);
            s.setFinalScore(avg);

            // 记录评委分数
            ScoreRecord scoreRecord = new ScoreRecord(scoreList, Collections.max(scoreList),
                    Collections.min(scoreList), avg);
            s.setScoreRecords(scoreRecord);

            //hm.put(id, judgeList);


            //在10个评委中找出最公平（最接近平均分）和最不公平的评委
            int minDifference = Integer.MAX_VALUE;
            int maxDifference = Integer.MIN_VALUE;
            Judge mostFairJudge = null;
            Judge leastFairJudge = null;

            for (Judge judge : judgeList) {
                int difference = Math.abs(judge.getScore() - avg);
                if (difference < minDifference) {
                    minDifference = difference;
                    mostFairJudge = judge;
                }
                if (difference > maxDifference) {
                    maxDifference = difference;
                    leastFairJudge = judge;
                }
            }
            System.out.println("选手的最终得分是：" + avg);
            System.out.println("最公平的评委是：" + mostFairJudge.getName() + "，评分差距为：" + minDifference);
            System.out.println("最不公平的评委是：" + leastFairJudge.getName() + "，评分差距为：" + maxDifference);
            break;
        }
    }

    public int getSingerId(ArrayList<Singer> singers, String id){
        for (int i = 0; i < singers.size(); i++) {
            Singer s = singers.get(i);
            if (s.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    private void showSingerInfo(ArrayList<Singer> list) {
        System.out.println("id\t  姓名  \t年龄");
        for (Singer s : list) {
            System.out.println(s.getId() + "\t " + s.getName() + "\t" + s.getAge());
        }
    }

    private void updateSinger(ArrayList<Singer> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改选手的id：");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index < 0) {
                System.out.println("id不存在，请重新输入！");
                continue;
            }
            System.out.println("请输入要修改的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入要修改的姓名：");
            String strAge = sc.nextLine();
            int age = Integer.parseInt(strAge);
            Singer s = list.get(index);
            s.setName(name);
            s.setAge(age);
            System.out.println("修改成功！");
            break;
        }
    }

    private void deleteSinger(ArrayList<Singer> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除选手的id：");
        String id = sc.nextLine();
        int index = getId(list, id);
        if (index < 0) {
            System.out.println("id不存在，删除失败！");
        } else {
            list.remove(index);
            System.out.println("删除成功！");
        }
    }

    private void addSinger(ArrayList<Singer> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入选手的id：");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index >= 0) {
                System.out.println("id已存在，请重新输入！");
                continue;
            }
            //不存在继续录入信息
            System.out.println("请输入选手的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入选手的年龄：");
            String strAge = sc.nextLine();
            int age = Integer.parseInt(strAge);
            Singer s = new Singer(id, name, age);
            list.add(s);
            System.out.println("添加成功！");
            break;
        }
    }

    public int getId(ArrayList<Singer> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
