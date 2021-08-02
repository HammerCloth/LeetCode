import java.util.Arrays;

/**
 * 你可以工作的最大数量
 * @author:syx
 * @date:2021/8/1 10:49
 * @version:v1.0
 */
public class Case5831 {
    public static void main(String[] args) {
        //int[] ints = {5,9,4,4,8,9,9,8,7,3};
        int[] ints = {3,5,7,9};
        System.out.println(numberOfWeeks(ints));
    }
    public static long numberOfWeeks(int[] milestones) {
        long weeks = 0;
        for (int i = 0; i < milestones.length-1; i++) {
            Arrays.sort(milestones);
            for (int j=i;j<milestones.length-1;j++){
                if (milestones[j]==milestones[j+1]){
                    weeks+= 2L *milestones[j];
                    milestones[j]=0;
                    milestones[j+1]=0;
                }
            }
            Arrays.sort(milestones);
            weeks+= 2L *milestones[i];
            milestones[milestones.length-1]-=milestones[i];
            milestones[i]=0;
        }
        if (milestones[milestones.length-1]>0){
            weeks++;
        }
        return weeks;
    }

}
