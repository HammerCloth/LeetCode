import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 图像渲染
 * @author:syx
 * @date: 2021/8/1 9:24
 * @version:v1.0
 */
public class Case733 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        print2D((image));
        image = floodFill(image,1,1,2);
        print2D((image));

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int realColor = newColor;
        newColor = -1;
        int target = image[sr][sc];//需要被替换的颜色
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while(!stack.empty()){
            int[] pop = stack.pop();
            //上
            if (pop[1]-1>=0){
                if (image[pop[0]][pop[1]-1]==target){
                    image[pop[0]][pop[1]-1]=newColor;
                    stack.push(new int[]{pop[0],pop[1]-1});
                }
            }
            //下
            if (pop[1]+1<=image[0].length-1){
                if (image[pop[0]][pop[1]+1]==target){
                    image[pop[0]][pop[1]+1]=newColor;
                    stack.push(new int[]{pop[0],pop[1]+1});
                }
            }
            //右
            if (pop[0]+1<=image.length-1){
                if (image[pop[0]+1][pop[1]]==target){
                    image[pop[0]+1][pop[1]]=newColor;
                    stack.push(new int[]{pop[0]+1,pop[1]});
                }
            }
            //左
            if (pop[0]-1>=0){
                if (image[pop[0]-1][pop[1]]==target){
                    image[pop[0]-1][pop[1]]=newColor;
                    stack.push(new int[]{pop[0]-1,pop[1]});
                }
            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j]==-1){
                    image[i][j]=realColor;
                }
            }
        }
        return image;
    }

    public static void print2D(int[][] image){
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

}
