/**
 * @author:syx
 * @date: 2021/6/21 17:32
 * @version:v1.0
 */
public class TestPreTree {
    public static void main(String[] args) {
        PrefixTree tree = new PrefixTree();
        String[] strings = new String[]{"hello","hello","world"};
        for (int i=0;i<strings.length;i++){
            tree.insert(strings[i]);
        }
        System.out.println(tree.findWord("world"));
    }
}
