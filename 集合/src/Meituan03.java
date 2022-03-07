import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Meituan03
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/5 10:30 AM
 * @Version v0.1
 **/
public class Meituan03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt(); //正方体豆腐的大小
            int M = sc.nextInt(); //切豆腐的刀数
            char[] cutVector = new char[M];
            for (int i = 0; i < M; i++) {
                cutVector[i]=sc.next().toCharArray()[0];
            }
             //切法方向
            int[] cutDistance = new int[M];
            for (int i = 0; i < M; i++) {
                cutDistance[i] = sc.nextInt();
            }
            ArrayList<Cod> list = new ArrayList<>();
            list.add(new Cod(0,0,0,N,N,N));
            for (int i = 0; i < M; i++) {
                int max = 0;
                ArrayList<Cod> next = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    Cod temp = list.get(j);
                    int size = temp.maxSize(cutDistance[i], cutVector[i]);
                    max = Math.max(size,max);
                    next.addAll(temp.cutList(cutDistance[i], cutVector[i]));
                }
                list = next;
                System.out.println(max);
            }

        }
    }

   static  class Cod{
        int pointX;
        int pointY;
        int pointZ;
        int x;
        int y;
        int z;

        public Cod(int pointX, int pointY, int pointZ, int x, int y, int z) {
            this.pointX = pointX;
            this.pointY = pointY;
            this.pointZ = pointZ;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int v(int x,int y,int z){
            return x*y*z;
        }

        public int selfv(){
            return v(x,y,z);
        }

        // 给一刀，切出来最大是多少，返回切出来所有块

        public int maxSize(int distance,char vector){
            //刀切不到这个豆腐
            if (vector=='x'){ //  |
                int temp = distance - this.pointX;
                if (temp<=0){
                    //刀没有切到豆腐
                    return selfv();
                }else if(temp<x){
                    //刀切到了豆腐
                    return Math.max(v(temp,y,z),v(x-temp,y,z));
                }else if(temp>=x){
                    //刀切不到豆腐
                    return selfv();
                }
            }else if (vector=='y'){ // ----
                int temp = distance - this.pointY;
                if (temp<=0){
                    //刀没有切到豆腐
                    return selfv();
                }else if(temp<y){
                    //刀切到了豆腐
                    return Math.max(v(x,temp,z),v(x,y-temp,z));
                }else if(temp>=y){
                    //刀切不到豆腐
                    return selfv();
                }
            }else if (vector=='z'){ // +++++
                int temp = distance - this.pointZ;
                if (temp<=0){
                    //刀没有切到豆腐
                    return selfv();
                }else if(temp<z){
                    //刀切到了豆腐
                    return Math.max(v(x,y,temp),v(x,y,z-temp));
                }else if(temp>=z){
                    //刀切不到豆腐
                    return selfv();
                }
            }
            return -1;
        }

        // 给一刀切出了哪些块
        public ArrayList<Cod> cutList(int distance,char vector){
            ArrayList<Cod> list = new ArrayList<>();
            //刀切不到这个豆腐
            if (vector=='x'){ //  |
                int temp = distance - this.pointX;
                if (temp<=0){
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }else if(temp<x){
                    list.add(new Cod(pointX,pointY,pointZ,temp,y,z));
                    list.add(new Cod(pointX+temp,pointY,pointZ,x-temp,y,z));
                    return list;
                }else if(temp>=x){
                    //刀切不到豆腐
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }
            }else if (vector=='y'){ // ----
                int temp = distance - this.pointY;
                if (temp<=0){
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }else if(temp<y){
                    //刀切到了豆腐
                    list.add(new Cod(pointX,pointY,pointZ,x,temp,z));
                    list.add(new Cod(pointX,pointY+temp,pointZ,x,y-temp,z));
                    return list;
                }else if(temp>=y){
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }
            }else if (vector=='z'){ // +++++
                int temp = distance - this.pointZ;
                if (temp<=0){
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }else if(temp<z){
                    //刀切到了豆腐
                    list.add(new Cod(pointX,pointY,pointZ,x,y,temp));
                    list.add(new Cod(pointX,pointY,pointZ+temp,x,y,z-temp));
                    return list;
                }else if(temp>=z){
                    //刀没有切到豆腐
                    list.add(this);
                    return list;
                }
            }
            return list;
        }
    }
}
