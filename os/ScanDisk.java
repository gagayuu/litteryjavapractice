package sust.os;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:gagayu
 * Created:2019/1/3
 */
public class ScanDisk {
    private Set<Integer> trackSet = new HashSet<>();
    private int[] tracks;//磁道数组
    private int headAt;//磁头处于磁道位置
    // private boolean direction;//true为左，false为右,但题目已规定增加方向
    private int distance=0;

    public ScanDisk(int[] tracks) {
        this.tracks = tracks;
        for (int i : tracks) {
            trackSet.add(i);
        }
    }


    public  void scan() {
        int[] orderTracks = this.tracks.clone();
        for (int i = 0; i < orderTracks.length; i++) { //冒泡排序，从小到大
            for (int j = i + 1; j < orderTracks.length; j++) {
                if( orderTracks[i] > orderTracks[j]) {
                    int tmp = orderTracks[i];
                    orderTracks[i] = orderTracks[j];
                    orderTracks[j] = tmp;
                }
            }

           }
        System.out.print("由大到小排序后的磁盘请求序列为：");
        for (int k = 0; k <orderTracks.length; k++) {
            System.out.print(orderTracks[k] + " ");
            if(orderTracks[k]==100){
                this.headAt=k;
            }
        }

        int head =this.headAt;

        System.out.println();
        System.out.print("寻道顺序为: ");
        //以磁道号增加方向移动
        for (int i = head; i < orderTracks.length; i++) {
            System.out.print(orderTracks[i] + " ");
            this.distance += Math.abs(orderTracks[this.headAt] - orderTracks[i]);
            this.headAt= i;
        }
        for (int i=head-1; i >= 0; i--) {
            System.out.print(orderTracks[i] + " ");
            this.distance += Math.abs(orderTracks[this.headAt]- orderTracks[i]);
            this.headAt = i;
        }
        System.out.println();
        System.out.println("总路程=" + this.distance);


    }


}
