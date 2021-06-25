import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:syx
 * @date: 2021/6/21 16:52
 * @version:v1.0
 */
public class PrefixTree {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(word2List("hello")));
    }
    private static Map<String,Node> headMap;

    public PrefixTree() {
        this.headMap = new HashMap<>();
    }

    public void insert(String word){
        String[] strings = word2List(word);
        Node head;
        if (!headMap.containsKey(strings[0])){
            head = new Node(strings[0]);
            headMap.put(strings[0],head);
            head.pass++;
        }else{
            head = headMap.get(strings[0]);
            head.pass++;
        }
        if (strings.length==1){
            head.end++;
        }else{
            for (int i=1;i<strings.length;i++){
                if (head.nextNodes.containsKey(strings[i])){
                    head = head.nextNodes.get(strings[i]);
                    head.pass++;
                }else{
                    Node node = new Node(strings[i]);
                    node.pass++;
                    head.nextNodes.put(strings[i],node);
                    head = node;
                }
            }
            head.end++;
        }
    }

    public int findWord(String word){
        String[] strings = word2List(word);
        if (!headMap.containsKey(strings[0])){
            return -1;
        }else{
            Node head = headMap.get(strings[0]);
            for (int i=1;i<strings.length;i++){
                if (head.nextNodes.containsKey(strings[i])){
                    head = head.nextNodes.get(strings[i]);
                }else{
                    return -1;
                }
            }
            return head.end;
        }

    }

    public static String[] word2List(String word){
        String[] wordList = new String[word.length()];
        for (int i=0;i<word.length();i++){
            wordList[i] = word.substring(i,i+1);
        }
        return wordList;
    }
}
class Node{
    String str;//节点的代表的值
    int pass;//经过这个节点的单词的数量
    int end;//以这个节点作为单词结尾的数量
    Map<String,Node> nextNodes = new HashMap<>();

    public Node(String str) {
        this.str = str;
        this.pass = 0;
        this.end = 0;
    }
}