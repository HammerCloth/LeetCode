/**
 * @ClassName Case2
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/16 22:39
 * @Version v0.1
 **/
public class Case2 {
    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(20, 10, 5));
       System.out.println(waysToBuyPensPencils(5, 10, 10));
        System.out.println(waysToBuyPensPencils(100, 1, 1));

    }
//    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
//        if (total<cost1&&total<cost2) return 1;//哪一种铅笔也不买
//        if (total<cost1&&total>=cost2) return total/cost2+1;
//        if (total<cost2&&total>=cost1) return total/cost1+1;
//        long result = 0;//一只铅笔也不买
//        if (total>=cost1){
//            result += waysToBuyPensPencils(total-cost1,cost1,cost2);//买下一直钢笔后的所有方案数
//        }
//        if (total>=cost2){
//            result += waysToBuyPensPencils(total-cost2,cost1,cost2);//买下一只铅笔的方案数
//        }
//        return result+1;
//    }
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total<cost1&&total<cost2) return 1;//哪一种铅笔也不买
        long sizeA = total/cost1;
        long result = 0;
        for (int i = 0; i <= sizeA; i++) {
            result += (total-i*cost1)/cost2+1;
        }
        return result;

    }
}
