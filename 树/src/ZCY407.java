import org.junit.jupiter.api.Test;

/**
 *在二叉树中找到一个节点的后继节点
 * 现有一种新的二叉树节点类型如下
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一棵Node类型节点组成的二叉树，树
 * 中的每个节点的parent执政都正常的指向node，请实现返回node的后继节点的函数。在二叉树中序遍历的序列中node
 * 的下一个节点叫做node的后继节点。
 * @author:syx
 * @date:2021/6/21 15:37
 * @version:v1.0
 */
public class ZCY407 {

    @Test
    public static void main(String[] args) {

    }

    /**
     * 对于一个节点的后继节点：
     * 1. 当这个节点有右子树的话，那么这个这个节点的右子树的最左边的节点就是后继节点
     * 2. 当这个节点没有右子树的话
     *      1. 如果为是父节点的左子节点，则父节点就是该节点后继节点
     *      2. 如果是右子节点，则在其父节点中，有一个父节点是左子节点，其父节点就是后继节点。
     * @param node
     * @return
     */
    public static Node getNextNode(Node node){

        if(node.right==null){
            if (node.parent!=null&&node.parent.left==node){
                return node.parent;
            }else{
                Node result = node.parent;
                while(result.parent!=null&&result.parent.left!=result){
                    result = result.parent;
                }
                if (result.parent!=null&&result.parent.left==result){
                    return result;
                }else{
                    return null;
                }
            }
        }else{
            Node result = node.right;
            while(result.left!=null){
                result = result.left;
            }
            return result;
        }
    }
}
class Node {
    public int value;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int data){
        this.value = data;
    }
}