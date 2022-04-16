/**
 * 用数组结构实现大小固定的栈
 * @author:syx
 * @date:2021/6/13 15:38
 * @version:v1.0
 */
public class ZCY301 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        for (int i=0;i<11;i++){
            stack.push(i);
        }
        System.out.println(stack.toString());
        for (int i=11;i>=0;i--){
            stack.peek();
        }
        System.out.println(stack.toString());

    }
}
class ArrayStack{
    static int size = 0 ;
    static int[] array ;
    static int point = 0;

    public ArrayStack(int lengh) {
        this.array = new int[lengh];
    }

    public static int peek(){
        if (isEmpty()){
            return -1;
        }
        return array[point-1];
    }

    public static int pop(){
        if (isEmpty()){
            return -1;
        }
        size--;
        return array[--point];
    }

    public static void push(int element){
        if (isFull()){
            return;
        }
        array[point++] = element;
        size++;
    }

    public static boolean isEmpty(){
        return size==0;
    }

    public static boolean isFull(){
        if (size==array.length){
            System.out.println("Stack is full");
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        for (int i=0;i<size;i++){
            builder.append(array[i]+"\t");
        }
        builder.append("]");
        return builder.toString();
    }
}
