package advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author:syx 小行星碰撞
 * @date:2021/9/14 9:46
 * @version:v1.0
 */
public class Of037 {
    public static void main(String[] args) {
       Of037 of037 = new Of037();
        int[] ints = {8,-8};
        System.out.println(Arrays.toString(of037.asteroidCollision(ints)));

    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length;) {
            if (stack.isEmpty()){
                stack.push(asteroids[i]);
                i++;
            }else if (crash(stack.peek(),asteroids[i])){
                if (stack.peek()>-asteroids[i]){
                    asteroids[i]=stack.peek();
                    stack.pop();
                }else if (stack.peek()<-asteroids[i]){
                    stack.pop();
                }else{
                    stack.pop();
                    i++;
                }
            }else{
                stack.push(asteroids[i]);
                i++;
            }
        }
        int[] ints = new int[stack.size()];
        for (int i = ints.length-1; i >=0; i--) {
            ints[i]=stack.pop();
        }
        return ints;
    }
    public boolean crash(int stack,int i){
        if (stack>0&&i<0){
            return true;
        }
        return false;
    }

}
