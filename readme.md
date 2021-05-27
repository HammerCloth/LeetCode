# 经验汇总
## 一、动态规划
#### case1105 填充书架
dp算法中，需要找到一种伴随着你的操作再变换的东西，再本题中，按顺序将书籍放入书架就是dp表的顺序，换而言之，记录的是放入多少本书后
最低的位置
#### case368 最大整除子集
这里学习到了单行数组dp,将子集算法保存在dp表中， 对每一个元素，都有选与不选两种情况，将选择这个元素的情况，储存在dp表中，

'''
dp[i] = max{dp[上一个可选的元素a]+1,...dp[上一个可选的元素b]+1};
'''


在学习动态规划时，最好先手动在草稿纸上演算一下，思考一下相关的解法步骤，这种步骤必须是统一的，可循环的

## 二、数组
### 1.双指针
## 三、深度优先搜索
#### case690 员工的重要性
这道题就很简单，唯一需要注意的一点是，题目给了一个员工类的list和对应需要查询的id，因为id并不是按照一定顺序
排列的，所以为了方便查找，可以静态一个全局的map，然后使用一个循环将list中的对像与id对应，降低查询的难度
## 四、位运算
#### case1720 解码异或后的数组
<P>异或的相关推导</P>

    1. a XOR b = b XOR a
    2. a XOR a = 0
    3. a XOR 0 = a
    4. A XOR B XOR B = A

#### case461 汉明距离
<p>这里是使用了两个API，也可通过位移来计算。</P>

1. Integer.toBinaryString(x) 可以把x转化为2进制表示的字符串

2. Integer.bitCount(x);直接输出x二进制表示1的个数
