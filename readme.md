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