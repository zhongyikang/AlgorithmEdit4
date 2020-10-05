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

