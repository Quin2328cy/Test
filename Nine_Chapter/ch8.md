### 哈希表和堆
BFS - Queue
DFS - Stack

###### Hash

```
1. HashTable -> 线程安全的
2. HashMap -> 线程不安全，key-value
3. HashSet -> 只有Key,没有value
``` 

Hash Function


对于任意一个对象，都可以得到一个映射后的值 
Hash的速度是O(k),k为key的长度

Closed Hash 并没有怎么被工业界接受，因为其删除的方法不是特别好，删除之后会占用很多有效的空间
Opened Hash 用链表解决冲突，每次插入都插入在头部

Rehash 动态膨胀
饱和度 超过1/10就要进行rehash--需要对每一个存进去的数据都重新计算一次，得到新的位置

``` 

####### LRU Cache
> 有存储限制的Hash-LinkedList
```
实现
1. LinkedHashMap = DoublyLinkedList + HashMap
2. Singly List: HashMap 里面存每个节点的前序节点,其中第一个节点用dummyNode来存储
多练习几遍—涉及到很多的链表操作
```

#### Heap VS PriorityQueue
```
PriorityQueue的删除操作很慢-O(n)---复习一下queue的接口操作


Ugly Number-> Priority Queue + HashSet

Top K Largest Number II(还有一个kth 最小值,针对两个已经排好序的数组-quick select)



```
> Top K Largest Numbers II
```java

private int K;// K means the size of Queue
public Solution(int K){
  Queue<Integer> queue = new PriorityQueue<Integer>();
  this.K = K;
}

public void add(int num){
  queue.offer(num);
}

public List<Integer> topk(){
  List<Integer> list = new ArrayList<Integer>();
  for(int i = 0; i < K; i++){
    list.add(queue.pol());
  }
                      
  for(Integer num: list){
    queue.offer(num);
  }
  
  return list;
}


/*这个代码有问题啊,Java的PriorityQueue默认是最小堆,需要重写Compareable方法实现最大堆*/
private static final int DEFAULT_INITIAL_CAPACITY = 11;
PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {                
            return o2-o1;
        }
    });
    
    
/**改进-只存储Top K个数字/
// 用MinHeap来存储当前的Top K个数字,每当加入一个新的值,就通过对比最小的值来进行更新

private int maxSize;
private Queue<Integer> minheap;
public void Solution(int k){
  minheap = new PriorityQueue<>();
  maxSize = k;
}

public void add(int num){
  if(minheap.size() < maxSize){
    minheap.offer(num);
  }
  if(minheap.top() < num){
    minheap.poll();
    minheap.offer(num);
  }
}

public List<Integer> topk(){
  Iterator it = minheap.iterator();
  List<Integer> result = new ArrayList<Integer>();
  while(it.hashNext()){
    result.add((Integer)it.next()){
  }
  Collections.sort(result, Collections.reverseOrder());
  return result;
}

```
