package sust.buildingsystem.entity;

public class People {

    private int no;

    private int num;

    private String name;
    private String sex;

    public People(int no, int num, String name, String sex){
        this.no=no;
        this.num=num;
        this.name=name;
        this.sex=sex;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "no=" + no +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
