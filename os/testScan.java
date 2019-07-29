package sust.os;

/**
 * Author:gagayu
 * Created:2019/1/4
 */
public class testScan {
    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (1 + Math.random() * 300);

        }

        arr[(int)(1+Math.random()*14)]=100;//将序列中一个磁道号设为100

        System.out.print("磁盘请求序列为: ");
        for(int k=0;k<arr.length;k++) {
            System.out.print(arr[k]+" ");
        }

        System.out.println();
        ScanDisk scanDisk = new ScanDisk(arr);
        scanDisk.scan();
    }


}
