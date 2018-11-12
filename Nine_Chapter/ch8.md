### 哈希表和堆
BFS - Queue
DFS - Stack

###### Hash
```
1. HashTable -> 线程安全的
2. HashMap -> 线程不安全，key-value
3. HashSet -> 只有Key,没有value
```
> Hash Function
```
对于任意一个对象，都可以得到一个映射后的值 
Hash的速度是O(k),k为key的长度

Closed Hash 并没有怎么被工业界接受，因为其删除的方法不是特别好，删除之后会占用很多有效的空间
Opened Hash 用链表解决冲突，每次插入都插入在头部

Rehash 动态膨胀
饱和度 超过1/10就要进行rehash--需要对每一个存进去的数据都重新计算一次，得到新的位置
``` 