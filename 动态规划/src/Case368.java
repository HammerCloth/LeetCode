import java.util.*;

/**
 * 最大整除子集
 * 给你一个由无重复正整数组成的集合，请你找回其中最大的整除子集，子集中的每一个元素对都应该满足
 * 互相整除。
 * @author:syx
 * @date: 2021/4/23 8:56
 * @version:v1.0
 */
public class Case368 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,8,10,240};
        List<Integer> list = largestDivisibleSubset(nums);
        System.out.println(list.toString());
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0] );
            return list;
        }
        Map<Integer,Node> map = new HashMap<>();//用于存储数据的dp表
        Arrays.sort(nums);
        //dp表初始化
        map.put(nums[0],new Node(nums[0],-1,1));
        int max = 1;
        int maxCount = 1;
        for (int i=1;i<nums.length;i++){
            int count=1;
            int lastNum=-1;
            for (int j=i-1;j>=0;j--){//选择了这个数，倒序查找
                if (nums[i]%nums[j]==0){
                    if (count<map.get(nums[j]).count+1){
                        count = map.get(nums[j]).count+1;
                        lastNum = nums[j];//更新上一个数
                    }
                }
            }
            if (count>maxCount){
                maxCount=count;
                max=i;
            }
            map.put(nums[i],new Node(nums[i],lastNum,count));
        }
        List<Integer> list = new ArrayList<>();
        Node start = map.get(nums[max]);
        list.add(start.num);
        while(start.lastNum!=-1){
            start = map.get(start.lastNum);
            list.add(start.num);
        }
        return list;
    }
     static class Node{
        int num;
        int lastNum;
        int count;

         public int getNum() {
             return num;
         }

         public void setNum(int num) {
             this.num = num;
         }

         public int getLastNum() {
             return lastNum;
         }

         public void setLastNum(int lastNum) {
             this.lastNum = lastNum;
         }

         public int getCount() {
             return count;
         }

         public void setCount(int count) {
             this.count = count;
         }

         public Node(int num, int lastNum, int count) {
            this.num = num;
            this.lastNum = lastNum;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", lastNum=" + lastNum +
                    ", count=" + count +
                    '}';
        }
    }
}
