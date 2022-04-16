/**
 * 位1的个数
 * @author:syx
 * @date:2021/8/7 10:05
 * @version:v1.0
 */
public class Case191 {
        public int hammingWeight(int n) {
            int ret = 0;
            while (n != 0) {
                n &= n - 1;
                ret++;
            }
            return ret;
        }
}
