package cn.cn.homework;

import java.util.Scanner;

public class TestSubstring {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入学号：");
        String id=sc.nextLine();
        if(id.substring(0,6).equals("201606")){
            System.out.println("该学生是电信学院2016级的");
        }

    }
}
