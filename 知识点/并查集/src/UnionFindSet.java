import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:syx
 * @date: 2021/6/21 16:29
 * @version:v1.0
 */
public class UnionFindSet implements UnionFind{
    private static Map<Node,Node> headMap = new HashMap<>();
    private static Map<Node,Integer> rankMap = new HashMap<>();

    public void makeSet(List<Node> list){
        for (Node node :list){
            headMap.put(node,node);
            rankMap.put(node,1);
        }
    }

    public Node findHead(Node node){
        Node father = headMap.get(node);
        if (father!=node){
            father=findHead(father);
        }
        headMap.put(node,father);
        return father;
    }
    @Override
    public void union(Node a, Node b) {
        if (a==null||b==null){
            return;
        }
        if (!isSameSet(a,b)) {
            int aRank = rankMap.get(findHead(a));
            int bRank = rankMap.get(findHead(b));
            if (aRank>=bRank){
                headMap.put(findHead(b),findHead(a));
                rankMap.put(findHead(a),aRank+bRank);
            }else{
                headMap.put(findHead(a),findHead(b));
                rankMap.put(findHead(b),aRank+bRank);
            }
        }
    }

    @Override
    public boolean isSameSet(Node a, Node b) {
        return findHead(a)==findHead(b);
    }
}
class Node{
    String value;
}