package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @ClassName Case843
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/24 16:01
 * @Version v0.1
 **/
public class Case843 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        Set<Integer> row = new HashSet<>(); //y
        Set<Integer> edge1 = new HashSet<>(); //x+y
        Set<Integer> edge2 = new HashSet<>(); // x-y
        dfs(array,row,edge1,edge2,0);
    }
    public static void dfs(int[] array,Set<Integer> row,Set<Integer> edge1,Set<Integer> edge2,int start){
        //先确定下子
        if (start == array.length){
            for(int i:array){
                char[] result = new char[array.length];
                Arrays.fill(result,'.');
                result[i] = 'Q';
                for(char c:result) System.out.print(c+" ");
                System.out.println();
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {//每一行都有可能
            //判断
            if (!row.contains(i)&&!edge1.contains(start+i)&&!edge2.contains(i-start)){
                //落子
                array[start] = i;
                row.add(i);
                edge1.add(start+i);
                edge2.add(i-start);
                //dfs
                dfs(array, row, edge1, edge2, start+1);
                //拿走子
                row.remove(i);
                edge1.remove(start+i);
                edge2.remove(i-start);
            }
            //拿走子

        }
    }
}
