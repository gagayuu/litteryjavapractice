package cn.cn.homework;

public class NineEight {
    public static void main(String[] args) {
        String idc = "61030219980228402x";
        //1
        if (idc.substring(8, 10).equals("98")) {
            System.out.println("这个人是98年的1");
        }
        //2
        if (idc.indexOf("98", 8) == 8) {
            System.out.println("这个人是98年的2");
        }
        //3
        char i = idc.charAt(8);
        char j = idc.charAt(9);
        if (i == '9' && j == '8') {
            System.out.println("这个人是98年的3");
        }
        //4
        if (idc.indexOf("98")==8) {
            System.out.println("这个人是98年的4");
        }

    }
}
