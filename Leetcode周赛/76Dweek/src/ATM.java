import java.util.HashMap;

/**
 * @ClassName ATM
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/4/16 23:06
 * @Version v0.1
 **/
public class ATM {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        atm.withdraw(600);
        atm.deposit(new int[]{0,1,0,1,1});
        atm.withdraw(600);
        atm.withdraw(550);
    }
    HashMap<Integer,Integer> map;
    int[] money;
    public ATM() {
        map = new HashMap<>();
        map.put(0,20);
        map.put(1,50);
        map.put(2,100);
        map.put(3,200);
        map.put(4,500);
        money = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < money.length; i++) {
            money[i]+=banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] clone = money.clone();
        int[] a = getMoney(4, amount);
        int[] b = getMoney(3, a[1]);
        int[] c = getMoney(2,b[1]);
        int[] d = getMoney(1,c[1]);
        int[] e = getMoney(0,d[1]);
        if (e[1]!=0){
            money = clone;
            return new int[]{-1};
        }else{
            return new int[]{e[0],d[0],c[0],b[0],a[0]};
        }

    }
    private int[] getMoney(int level,int amount){
        int face = map.get(level);
        if (amount<face) return new int[]{0,amount};
        if (amount>=face){
            int count = amount / face;
            if (count>=money[level]){
                int[] ints = {money[level], amount - (face * money[level])};
                money[level] = 0;
                return ints;
            }else{
                money[level]-=count;
                return new int[]{count,amount-(face*count)};
            }
        }
        return null;
    }
}
