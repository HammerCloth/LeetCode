package advanced;

/**
 * 二进制加法
 * @author:syx
 * @date: 2021/8/9 10:27
 * @version:v1.0
 */
public class Of002 {
    public static void main(String[] args) {
        System.out.println(addBinary("0", "0"));
    }
    public static String addBinary(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        char[] arrayC = new char[Math.max(arrayA.length,arrayB.length)+1];
        int A = a.length()-1;
        int B = b.length()-1;
        int C = arrayC.length-1;
        char[] result;
        int key;
        if (A>B){
            result = arrayA;
        }else{
            result = arrayB;
        }
        arrayC[C]='0';
        int D = result.length-1;
        while(A>=0||B>=0){
            int temp;
            if (A<0){
                 temp = (int)arrayB[B]+(int)arrayC[C]-2*48;
            }else if(B<0) {
                 temp = (int) arrayA[A] + (int) arrayC[C] - 2 * 48;
            }else{
                 temp = (int)arrayA[A]+(int)arrayB[B]+(int)arrayC[C]-3*48;
            }
            result[D]=(char)(temp%2+48);
            arrayC[C-1]=(char)(temp/2+48);
            A--;
            B--;
            C--;
            D--;
        }
        if (arrayC[C]=='1'){
            char[] chars = new char[result.length + 1];
            chars[0]='1';
            for (int i = 0; i < result.length; i++) {
                chars[i+1] = result[i];
            }
            return new String(chars);
        }
        return new String(result);

    }
}
