package advanced;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author:syx
 * @date:2021/9/22 9:46
 * @version:v1.0
 */
public class Of044 {
    public List<Integer> largestValues(TreeNode root) {
        if (root==null){
            return null;
        }
        Queue<TreeNode> queueA = new LinkedList<>();
        queueA.offer(root);
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        int max;
        while(!queueA.isEmpty()){
            max = Integer.MIN_VALUE;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queueA.isEmpty()){
                TreeNode poll = queueA.poll();
                if (poll.right!=null){
                    temp.offer(poll.right);
                    max = Math.max(max,poll.right.val);
                    temp.offer(poll.right);
                }
                if (poll.left!=null){
                    temp.offer(poll.left);
                    max = Math.max(max,poll.left.val);
                    temp.offer(poll.left);
                }
            }
            if (!temp.isEmpty()){
                result.add(max);
            }
            queueA = temp;
        }
        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
