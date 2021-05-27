import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * @author:syx
 * @date: 2021/5/8 8:43
 * @version:v1.0
 */
public class Case1723 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 3};
        int k = 1;
        System.out.println(minimumTimeRequired(a, 1));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        if (k == 1 || k == jobs.length) {
            return Arrays.stream(jobs).max().getAsInt();
        } else {
            //倒序搜索然后填充
        }
        return -1;
    }

}

