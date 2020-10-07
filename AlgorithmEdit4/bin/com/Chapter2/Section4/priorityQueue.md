## piority queue(优先队列)

# 简介： 什么是优先队列？

之前学习的几种sort方法有两个特点：

1. 全局sort，一次排序list中的所有element。
2. sort once.

日常使用中，我们可能有： 局部sort + 多次sort的需求。 这就是本章谈论的内容。 

实现这样的需求需要一种新的数据结构： priority queue。 它主要有两种功能：删除最大或者最小元素， 入队。

## TopM

TopM的功能是输入一组数据， 输出其中的最大的M个数

标准输入有two part， one is the M, others are the data.

实现: 构造一个长度为M + 1的priority queue， 一旦长度大于M， 就执行delMin（）方法。最终， 存在于此PQ中的就是这串数据中最大的M个数。

## Priority Queue的四种实现

## 1. 无序数组

可以理解为array实现的下压栈的变体。

insert操作直接在数组尾部添加， 类似于下压栈的push()方法。

delMax可以像选择排序一样使用一个循环找到maxNum， 然后swap最大的元素和最后一个元素。然后和下压栈的pop()逻辑一样弹出元素。

## 2. 有序数组

有序的方式是在每次insert的时候， 使用插入排序的插入逻辑，让maxNum在数组的尾部。delMax的时候直接删除尾部元素。


## 3. 无序链表
## 4. 有序链表

总结： 所有以上的实现在最糟糕的情况下是线性时间， 我们需要寻找更优质的算法。
Finding an implementation where both operations are **guaranteed to be fast** is a more interesting task.


# 二叉堆（binary heap）
二叉堆是一种数据结构， 和二叉树很像。
首先，二叉堆可以用数组实现， root的索引是1， 假设节点索引是x，则它的left child 的索引是2 * x， right child的索引是 2 * x + 1.
二叉堆的特点： 每个子节点的value小于或者大于其父节点，这意味着root节点的value是最大的或者最小的。

二叉堆 = 完全二叉树 + head ordered（堆排序的）
二叉堆用完全二叉树特别好实现，因为可以保证数组实现中,有n个节点的二叉堆，在array中前n个位置没有空位。

完全二叉树的定义：一棵深度为k的有n个结点的二叉树，对树中的结点按从上至下、从左到右的顺序进行编号，如果编号为i（1≤i≤n）的结点与满二叉树中编号为i的结点在二叉树中的位置相同，则这棵二叉树称为完全二叉树。 

# 重新堆化（reheapify）
让一个堆保持堆的特性的操作。

reheapify 有两种实现方式，分别是： 自底向上（swim）和自顶而下（sink）。两个方法分别对应优先队列的insert和delMax方法中。

* 当insert的时候，insert的key是在数组的尾部。 这时候需要使用swim， 自底向上reheapify。
* 当delMax的时候， 把索引为1的key删除， 这时候用尾部的元素exch， 然后在sink它。 


## heapSort
heap sort分为两部分。
传入sort方法的是一个普通的数组。
1. 对这个数组进行sink或者swim，使其heap-ordered.
2. 逐个delMax， 然后把maxVal和数组尾部元素exch,最后得到的array是从小到大排序的。
