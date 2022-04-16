import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 随时找到数据流的中位数
 * 有一个源源不断的地吐出整数的数据流，假设你有足够的空间来保存吐出的数
 * 请设计一个名叫MedinHolder的结构，MeidianHolder可以随时取得之前吐出所有的数的
 * 中位数
 * 如果MedinHolder已经保存了吐出的n个数，那么任意时刻将一个新的数加入到MedinHolder的
 * 过程，其时间复杂度为O(logN)
 * 取得已经吐出的N个数整体的众位数的过程，时间复杂度为O(1)
 *
 * @author:syx
 * @date: 2021/6/16 16:28
 * @version:v1.0
 */
public class ZCY401 {
    public static void main(String[] args) {
        MedinHolder medinHolder = new MedinHolder();
        for(int i=0;i<10;i++){
            medinHolder.add(i);
            System.out.println(medinHolder.getMedin());
        }
    }
}

class MedinHolder {
    private static PriorityQueue<Integer> leftHeap = new PriorityQueue<>(new MaxHeapComperator());
    private static PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    private static int size;

    public  void add(int element) {
        if (size == 0) {
            leftHeap.add(element);
            size++;
            return;
        }
        if (element >= leftHeap.peek()) {
            rightHeap.add(element);
            size++;
        } else {
            leftHeap.add(element);
            size++;
        }
        if (rightHeap.size() - leftHeap.size() > 1) {
            //右边的堆数量较多
            leftHeap.add(rightHeap.poll());
        }
        if (leftHeap.size() - rightHeap.size() > 1) {
            //左边的堆数量较多
            rightHeap.add(leftHeap.poll());
        }
    }

    public  double getMedin() {
        if (leftHeap.size() == rightHeap.size()) {
            return (leftHeap.peek() + rightHeap.peek()) * 0.5;
        } else {
            return leftHeap.size() > rightHeap.size() ? leftHeap.peek() : rightHeap.peek();
        }
    }
}

class MaxHeapComperator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return (-1) * o1.compareTo(o2);
    }
}
