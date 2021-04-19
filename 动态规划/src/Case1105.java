import java.util.ArrayList;
import java.util.List;

/**
 * 填充书架
 * 附近的家具城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上
 * 你把要摆放的书books都整理好，叠成一摞，从上往下，第I本书的厚度为books【i】【0】
 * 高度为books【i】【1】
 * 按顺序讲这些书摆放到总宽度为shelf-width的书架上
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），
 * 然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。
 * 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 *每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 *以这种方式布置书架，返回书架整体可能的最小高度。
 * @author:syx
 * @date:2021/4/19 19:53
 * @version:v1.0
 */
public class Case1105 {
    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelf_width = 4;
        System.out.println(minHeightShelves(books,shelf_width));
    }
    public static int minHeightShelves(int[][] books, int shelf_width) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);//还没有放入书籍时，书架的层高为0；
        for(int i =0;i<books.length;i++){
            // 一开始将书籍单一放入一层，然后再逐个将前面书拉下来放入同一层，看看是否高度减少，当本层挤不下书籍时，就放弃拿书下来，因为会多加一层，且上一层高度为最小值
            int tmp_w = books[i][0];//本层书籍的厚度
            int tmp_h = books[i][1]+dp.get(i);//书架的最高度
            int h = books[i][1];
            for (int k = i-1;k>=0;k--){
                if (tmp_w+books[k][0]>shelf_width){
                    break;
                }else{
                    tmp_w = tmp_w+books[k][0];
                    h = Math.max(h,books[k][1]);
                    tmp_h = Math.min(tmp_h,dp.get(k)+h);
                }

            }
            dp.add(tmp_h);//循环过后，写入最低总高度
        }
        return dp.get(books.length);
    }
}
