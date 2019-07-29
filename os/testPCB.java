package sust.os;

import java.util.*;

/**
 * Author:gagayu
 * Created:2018/12/9
 */
public class testPCB {
    public static void main(String[] args) {
        Method method =new Method();
        method.input();
        method.run();
        System.out.println("-----------------------------------------------");

    }
}


class PCB {
    private String name;//进程名
    private String status;//状态
    private int time;//运行时间
    private int priority;//优先数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}


class Method {

    ArrayList<PCB> list = new ArrayList<>();

    //输入进程
    public  void input() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入PCB[" + (i + 1) + "]  name  time  priority ");
            PCB p = new PCB();
            p.setName(in.next());
            Random random = new Random();
            int time = (int) (random.nextInt(10));
            int priority = (int)(random.nextInt(10));
            p.setTime(time);
            p.setPriority(priority);
            p.setStatus("ready");
            list.add(p);

        }
    }

    //获取优先权最大的进程
    public  int getMaxPriority(List<PCB> list) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int p = 0;
        Iterator<PCB> iterator = list.iterator();
        while (iterator.hasNext()) {
            PCB pcb = iterator.next();
            if (pcb.getPriority() > max) {
                max = pcb.getPriority();
                p = i;
            }
            i++;
        }
        return p ;

    }


    //运行后优先权-1
    public  void update(PCB p) {
        if (p.getPriority() != 0) {
            p.setPriority(p.getPriority() - 1);
        } else {
            p.setPriority(0);
        }
    }


    //运行
    public  void run() {
        while (list.size()!=0){
            int max= getMaxPriority(list);
            PCB pcb=list.get(max);
            if(pcb.getTime()!=0){
                pcb.setStatus("working");
                pcb.setTime(pcb.getTime()-1);
                show();
                pcb.setStatus("ready");
            }
            else{
                pcb.setStatus("end");
                pcb.setTime(pcb.getTime()-1);
                show();
                pcb.setStatus("ready");
            }
            update(pcb);
            list.set(max,pcb);
            if(pcb.getTime()<=0){
                System.out.println("             进程"+pcb.getName()+"结束");
                list.remove(max);
            }

        }

    }


    public  void show(){
        Iterator<PCB> iterator=list.iterator();
        while(iterator.hasNext()){
            PCB pcb=iterator.next();
            System.out.println("              "+pcb.getName()+"        "+pcb.getTime()+"        "+pcb.getPriority()+"       "+pcb.getStatus());
        }
        System.out.println();
    }


}























