import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/8 19:18
 * @Version v0.1
 **/
public class Case1 {
    /*
     * class TreeNode {
     *   int val = 0;
     *   TreeNode left = null;
     *   TreeNode right = null;
     *   public TreeNode(int val) {
     *     this.val = val;
     *   }
     * }
     */
    public boolean isSubtree (TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            boolean equal = equal(poll, t);
            if (equal){
                return equal;
            }
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        return false;
    }
    public static boolean equal(TreeNode s, TreeNode t){
        if (s==null&&t==null){
            return true;
        }
        if (s!=null&&t==null){
            return false;
        }
        if (t!=null&&s==null){
            return false;
        }
        if (s.val==t.val){
            return equal(s.right,t.right)&&equal(s.left,t.left);
        }else{
            return false;
        }
    }
    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
