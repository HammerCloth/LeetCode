package src;

/**
 * @ClassName Case1
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/5/8 10:29
 * @Version v0.1
 **/
public class Case1 {
    public static void main(String[] args) {
        String num = "222";
        System.out.println(largestGoodInteger(num));

    }
    public static String largestGoodInteger(String num) {
        if (num.length()==3){
            Integer integer = Integer.valueOf(num);
            if (integer==0||integer%111==0){
               return num;
            }else{
                return "";
            }
        }
        //遍历所有长度为3的子字符串
        int result = Integer.MIN_VALUE;
        for (int i = 3; i < num.length(); i++) {
            String substring = num.substring(i - 3, i);
            Integer integer = Integer.valueOf(substring);
            if (integer==0||integer%111==0){
                result = Math.max(integer,result);
            }
        }
        if (result==Integer.MIN_VALUE) return "";
        if(result==0) return "000";
        return result+"";

    }
}
