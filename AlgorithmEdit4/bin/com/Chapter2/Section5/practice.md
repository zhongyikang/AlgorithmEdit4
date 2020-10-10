## 2.5 APPLICATION EXERCISE

# exercise 1
如果没有这一行， 对于"this == that"这种情况， 方法体的所有语句都要执行一遍。有了这一行， 可以直接跳出返回结果。

# exercise 2
思路<p>
1. a、a 有一种可能， aa。a、a、a也有一种可能， aa。所以允许单个元素最大数量为2
2. a、b 有两种可能： ab、ba。

方法一： Set + 暴力破解。组合， 看Set中有没有， 没有，List + Set中都添加； 有， Set中添加。
见com.Chapter2.Section5.Exercise_2_FindAllAllCombinations， 我只想到了这一个方法， 时间复杂度为$N^2$。

# exercise 3
有两点。
1. 它的compareTo()方法不符合comparaTo()的规范。如果x.compareTo(y) == 0, y.compareTo(z) == 0, 那么， x.comparaTo(z) == 0.
2. 对于一个bank account， 存储数据应该用BigDecimal 而不是 double.

# exercise 4
见com.Chapter2.Section5.Exercise_4_Dedup

# exercise 5
所谓的sort稳定性指的是， 保证数组中重复元素的相对位置不变。 

选择排序破坏稳定性的地方是在找到minEle并交换这一步。

3 4 6 7 6 5.
目前指针i到了第一个6这里， 另外一个指针寻找3、4之外的最小key， 为5. exchange key， 第一个6被交换到第二个6的后面，稳定性被破坏了。

