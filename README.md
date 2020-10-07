# AlgorithmEdit4

## 2.4 priority queue
优先队列的特点是部分排序， 它的两个主要功能是：
1. delMax, 删除最大元素。
2. insert, 插入元素。

优先队列的最基本实现有四种， 无序数组、有序数组、无序链表、有序链表。对其复杂度分析， 最糟糕情况都为N。对此我们希望找到更优秀稳定的PQ实现算法，例如二叉堆实现。
MaxHeap的特点是每个子节点的key都小于父节点的key, 对于heap最重要的实现是swim()和sink(), 分别用于insert和delMax之后， 重新组织堆以让其是heap ordered。

...
  
详情请见[优先队列](https://github.com/zhongyikang/AlgorithmEdit4/blob/master/AlgorithmEdit4/src/com/Chapter2/Section4/priorityQueue.md)
