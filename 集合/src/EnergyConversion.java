import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 魔法师百小度也有遇到难题的时候——
 * 现在，百小度正在一个古老的石门面前，石门上有一段古老的魔法文字，读懂这种魔法文字需要耗费大量的能量和大量的脑力。
 * 过了许久，百小度终于读懂魔法文字的含义：石门里面有一个石盘，魔法师需要通过魔法将这个石盘旋转X度，以使上面的刻纹与天相对应，才能打开石门。
 * 但是，旋转石盘需要N点能量值，而为了解读密文，百小度的能量值只剩M点了！破坏石门是不可能的，因为那将需要更多的能量。不过，幸运的是，
 * 作为魔法师的百小度可以耗费V点能量，使得自己的能量变为现在剩余能量的K倍（魔法师的世界你永远不懂，谁也不知道他是怎么做到的）。
 * 比如，现在百小度有A点能量,那么他可以使自己的能量变为(A-V)*K点（能量在任何时候都不可以为负，即：如果A小于V的话，就不能够执行转换）。
 * 然而，在解读密文的过程中，百小度预支了他的智商，所以他现在不知道自己是否能够旋转石盘，打开石门，你能帮帮他吗？
 *
 * @author:syx
 * @date:2021/7/20 17:22
 * @version:v1.0
 */
public class EnergyConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long v = sc.nextInt();
            long k = sc.nextInt();
            System.out.println(getResult(n, m, v, k));
        }
    }

    public static int getResult(long n, long m, long v, long k) {
        int count = 0;
        while (m < n && m > v) {
            count++;
            long temp = (m - v) * k;
            if (m == temp){
                return -1;
            }
            m = temp;
        }
        if (m >= n) {
            return count;
        } else {
            return -1;
        }


    }
}
