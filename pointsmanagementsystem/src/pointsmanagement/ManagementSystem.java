package pointsmanagement;


import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
    //需要一个集合存储客户对象
    static ArrayList<Custom> list = new ArrayList<>();

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------欢迎来到客户积分管理系统----------------");
            System.out.println("1.添加客户");
            System.out.println("2.删除客户");
            System.out.println("3.修改客户");
            System.out.println("4.展示客户信息");
            System.out.println("5.增加客户积分");
            System.out.println("6.查询客户的打折优惠");
            System.out.println("7.退出");
            System.out.println("请输入您的选择：");

            String choose = sc.next();
            switch (choose) {
                case "1" -> addCustom(list);
                case "2" -> deleteCustom(list);
                case "3" -> updateCustom(list);
                case "4" -> showCustomInfo(list);
                case "5" -> addCustomPoints(list);
                case "6" -> queryCustomDiscount(list);
                case "7" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void queryCustomDiscount(ArrayList<Custom> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入客户的id");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index < 0) {
                System.out.println("id不存在，请重新输入");
                continue;
            }
            Custom custom = list.get(index);
            int points = custom.getBonusPoints();
            if (points >= 100 && points < 500) {
                System.out.println("客户的优惠折扣是九折");
                break;
            } else if (points >= 500 && points < 1000) {
                System.out.println("客户的优惠折扣是八折");
                break;
            } else if (points >= 1000) {
                System.out.println("客户的优惠折扣是七折");
                break;
            }
        }

    }

    private static void addCustomPoints(ArrayList<Custom> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要增加积分的客户的id");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index < 0) {
                System.out.println("id不存在，请重新输入");
                continue;
            } else {
                System.out.println("请输入增加的积分");
                String strPoints = sc.nextLine();
                int points = Integer.parseInt(strPoints);
                list.get(index).addBonusPoints(points);
                System.out.println("增加成功！");
                break;
            }
        }
    }


    private static void showCustomInfo(ArrayList<Custom> list) {
        System.out.println("id\t  姓名  \t年龄  \t消费积分");
        for (Custom custom : list) {
            System.out.println(custom.getId() + "\t " + custom.getName() + "\t" +
                    custom.getAge() + "  \t" + custom.getBonusPoints());
        }
    }


    //添加客户
    public static void addCustom(ArrayList<Custom> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入客户的id");
        String id = sc.nextLine();
        int index = getId(list, id);
        if (index >= 0) {
            System.out.println("id已存在！");
            return;
        }
        System.out.println("请输入客户的名字");
        String name = sc.nextLine();
        System.out.println("请输入客户的年龄");
        String strAge = sc.nextLine();
        int age = Integer.parseInt(strAge);
        System.out.println("请输入客户的消费积分");
        String strPoints = sc.nextLine();
        int points = Integer.parseInt(strPoints);
        list.add(new Custom(id, name, age, points));
        System.out.println("添加成功！");
    }

    //删除客户
    public static void deleteCustom(ArrayList<Custom> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除客户的id");
        String id = sc.nextLine();
        int index = getId(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！没有这个id");
        }
    }

    public static int getId(ArrayList<Custom> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Custom custom = list.get(i);
            if (id.equals(custom.getId())) {
                //id存在
                return i;
            }
        }
        return -1;
    }

    //修改客户
    public static void updateCustom(ArrayList<Custom> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改客户的id");
            String id = sc.nextLine();
            int index = getId(list, id);
            if (index < 0) {
                System.out.println("修改失败！没有这个id，请重新输入");
                continue;
            }
            System.out.println("请输入要修改的名字");
            String name = sc.nextLine();
            System.out.println("请输入要修改的年龄");
            String strAge = sc.nextLine();
            int age = Integer.parseInt(strAge);
            System.out.println("请输入要修改的消费积分");
            String strPoints = sc.nextLine();
            int points = Integer.parseInt(strPoints);
            Custom custom = list.get(index);
            custom.setName(name);
            custom.setAge(age);
            custom.setBonusPoints(points);
            System.out.println("修改成功！");
            break;
        }
    }
}
