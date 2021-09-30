package advanced;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author:syx
 * @date:2021/9/19 9:51
 * @version:v1.0
 */
public class Of043 {
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

    public class CBTInserter {
        private TreeNode root;
        private Map<Integer, TreeNode> indexMap;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.indexMap = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            int index = 1;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                indexMap.put(index++, poll);
            }
        }

        public int insert(int v) {
            int index = indexMap.size() + 1;
            int parIndex = index / 2;
            TreeNode parent = indexMap.get(parIndex);
            TreeNode node = new TreeNode(v);
            if (index % 2 == 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            indexMap.put(index, node);
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
