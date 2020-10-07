##2.4.1 
略

## 2.4.2
1. 不仅仅要找到最大的元素，还要删除。 对于heap实现的priority queue来说， 只需要交换root和heap尾部元素然后sink()即可，复杂度为log N。而stack和队列删除要腾出空间， 复杂度高， 为N。
2. heap删除一次之后， sink(), 最大元素又在root。 而对于stack或者queue， 要重新遍历找到maxKey， 复杂度又是N。

## 2.4.3 
1. 无序数组： insert（尾部insert）， 复杂度为1。delMax（类似于选择排序， 遍历，找到max， swap（i，n）， 删除尾部。 复杂度为N）
2. 有序数组， 每次addEle类似于插入排序。 insert(最糟糕复杂度为N)， delMax（复杂度为1）。
 


## 2.4.4 
是。<p>
maxEle-oriented heap的特点是：
1. index从1开始。
2. 每个key的所有子节点的key不大于它。<p>
降序排列的数组符合这两个特点。

## 2.4.5 
Y T U S Q N E A S I O E

## 2.4.7
当k为2， 第k大的元素一定在位置2或者3
当k为3， 第k大的元素可能在位置2或者3， 4，5，或者6，7都有可能， 但是不可能在7之后。
当k为4， 第k----在：2、3...， 总之在从上到下堆的第二层、第三层、第四层。

## 2.4.9 
对于A、B、C、D、E， 不管怎样， E在最上层。 因为堆的形式是完全二叉树的形式， 所以root的left child有三个元素。 如果left child是C， 剩下的只能是AB， 所以两种可能。 如果是D， 剩下的可能是ABC的两个。 使用高中排列知识， 3 * 2 = 6。 所以总共是8种可能性。

对于A、A、A、B、B。 2种。

## 2.4.10
这一题的思想在heapSort中有所运用。我们可以构建一个逻辑索引。pq[0]的逻辑索引是1， 映射规则是logicalIndex = index + 1.
对于pq[k], 其逻辑索引是k + 1。 父亲节点的逻辑索引是(k + 1) / 2, 对应数组位置是(k + 1)/ 2 - 1.

## 2.4.11
我将这一题理解为insert操作次数远大于delMax操作， 那么无序数组更适合，因为是常数级别的复杂度。
这一题考察的priority queue三种实现各自的insert和delMax的复杂度。

## 2.4.12
注意这里是找出最大元素， 找出最大元素， 最优复杂度是1， 为heap以及ordered array实现。但是heap的insert操作复杂度优于ordered array， 所以推荐heap。

## 2.4.13
j = k * 2.
j + 1 = k * 2 + 1;
sink()中， 检查j < N， 是为了防止数组越界。
我们可以把j < N提前到while的条件中， 把while(k * 2 <= N) 转化为  while(k * 2 < N)即可。

## 2.4.14
最少要交换log N次。

## 2.4.15 
见com.Chapter2.Section4.TestMinHeap.isMinHead()

## 2.4.27
Q：在MaxPQ中添加一个min()方法，功能是找到minKey， 要求常数时间和空间。
A：<p> 
1. 有一个min field， 每次insert的时候， 都使用less()方法比较一下。
2. 然后delMax的时候，只有在n == 1的时候删除， min值才会被删掉。
3. 当n==0的时候insert， min == insertVal。




