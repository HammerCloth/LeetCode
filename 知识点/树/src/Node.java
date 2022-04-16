/**
 * @author:syx
 * @date: 2021/6/20 15:55
 * @version:v1.0
 */
public class Node {
    int value;
    Node leftNode;
    Node rightNode;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }
}
