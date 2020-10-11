# AlgorithmEdit4

## 2.4 priority queue
优先队列的特点是部分排序， 它的两个主要功能是：
1. delMax, 删除最大元素。
2. insert, 插入元素。

优先队列的最基本实现有四种， 无序数组、有序数组、无序链表、有序链表。对其复杂度分析， 最糟糕情况都为N。对此我们希望找到更优秀稳定的PQ实现算法，例如二叉堆实现。
MaxHeap的特点是每个子节点的key都小于父节点的key, 对于heap最重要的实现是swim()和sink(), 分别用于insert和delMax之后， 重新组织堆以让其是heap ordered。

...
  
详情请见[优先队列](https://github.com/zhongyikang/AlgorithmEdit4/blob/master/AlgorithmEdit4/src/com/Chapter2/Section4/priorityQueue.md)

## 3.1 符号表
Java中的Map其实就是符号表。 有key-value形式的数据，其主要是用来通过key查找对应的数据。<p>
符号表分为两种，有序和无序。<p>
老样子， 它的实现有最基础的方式： 数组、链表。<p>
假设是数组 则有两个并行的数组分别用来存储key和value。<p>
符号表API中，无序比较简单， 有put和get。<p>
有序较为复杂，其中有序中最重要的是 int rank(Key)方法，通过key， 找到小于key的元素的数量。为了减少时间复杂度，它使用**二分查找**来完成寻找功能。<p>
下一节会谈到更为优秀的BST的符号表实现方式。<p>

**本节的重点是数组实现的有序符号表。**<p>
更多请见：
[3.1符号表](https://github.com/zhongyikang/AlgorithmEdit4/blob/master/AlgorithmEdit4/src/com/Chapter3/Section1/symbolTables.md)<p>
[符号表游思](https://github.com/zhongyikang/AlgorithmEdit4/blob/master/AlgorithmEdit4/src/com/Chapter3/Section1/symbolTables.md)
