package src;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/8 10:49
 * @Version v0.1
 **/
public class Case2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
    }

    public int averageOfSubtree(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int sum = sum(poll);
                int count = count(poll);
                if ((sum/count)== poll.val) result++;
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
        }
        return result;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;
        int result = root.val;
        result += sum(root.right);
        result += sum(root.left);
        return result;
    }

    public int count(TreeNode root) {
        if (root==null) return 0;
        int result = 1;
        result+=count(root.right);
        result+=count(root.left);
        return result;
    }

}
