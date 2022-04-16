import java.util.ArrayList;

/**
 * @ClassName Teree
 * @Description TODO
 *     给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *     展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 展开后的单链表应该与二叉树 先序遍历 顺序相同。   示例 1：
 *     输入：root = [1,2,5,3,4,null,6]
 *     输出：[1,null,2,null,3,null,4,null,5,null,6]
 *     示例 2：
 *
 *     输入：root = []
 *     输出：[]
 *     示例 3：
 *
 *     输入：root = [0]
 *     输出：[0]
 *     提示：
 *
 *     树中结点数在范围 [0, 2000] 内 -100 <= Node.val <= 100
 * @Author SiYiXiong
 * @Date 2022/3/1 8:37 PM
 * @Version v0.1
 **/
public class Teree {
    public static void main(String[] args) {
        TreeNode text = new TreeNode(1);
        text.right = new TreeNode(5);
        text.left = new TreeNode(2);
        text.right.right = new TreeNode(6);
        text.left.right = new TreeNode(4);
        text.left.left = new TreeNode(3);

        Teree s = new Teree();
        s.toLinkedList(text);
    }
    static class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val){
            this.val =  val;
        }

    }
    public TreeNode toLinkedList(TreeNode node){
        if (node==null){
            return null;
        }
        ArrayList<Integer> preList = getPreList(node);
        TreeNode result = new TreeNode(-1);
        TreeNode temp = result;
        for (int i = 0; i < preList.size(); i++) {
            temp.right = new TreeNode(preList.get(i));
            temp = temp.right;
        }
        return result.right;
    }
    public ArrayList<Integer> getPreList(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left!=null){
            ArrayList<Integer> left = getPreList(root.left);
            result.addAll(left);
        }
        if (root.right!=null){
            ArrayList<Integer>  right = getPreList(root.right);
            result.addAll(right);
        }
        return result;
    }
}
