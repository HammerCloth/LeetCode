/**
 * 用数组结构实现固定大小的队列
 *
 * @author:syx
 * @date:2021/6/13 16:01
 * @version:v1.0
 */
public class ZCY301 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i=0;i<11;i++){
            queue.put(i);
        }
        System.out.println(queue.toString());
        for (int i=11;i>=0;i--){
            System.out.println(queue.get());
        }
        System.out.println(queue.toString());
    }
}

class ArrayQueue {
    private static int size;
    private static int start;
    private static int end;
    private static int[] nums;

    public ArrayQueue(int length) {
        this.nums = new int[length];
    }

    public int get() {
        if (!isEmpty()){
            size--;
            int num = nums[start];
            start=nextIndex(start);
            return num;
        }else{
            return -1;
        }
    }

    public void put(int element) {
        if (!isFull()) {
            nums[end] = element;
            end = nextIndex(end);
            size++;
        }
    }

    public boolean isFull() {
        if (size == nums.length) {
            System.out.println("QUEUE IS FULL");
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("QUEUE IS EMPTY");
            return true;
        } else {
            return false;
        }
    }

    private int nextIndex(int index){
        if (index == nums.length-1){
            return 0;
        }else{
            return ++index;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("start\t");
        int key = start;
        for (int i=0;i<size;i++){
            stringBuilder.append(nums[key]+"\t");
            key = nextIndex(key);
        }
        stringBuilder.append("end\t");
        return stringBuilder.toString();
    }
}
