## 二叉树与分治法

```
二叉树的高度没办法直接通过节点个数n来推测
```
> 当二叉树的深度比较深时，不建议用递归来做->但在面试的时候，可能不需要考虑这个，直接用递归就好


> 通过O(n)的时间，把n的问题，变为了两个n/2的问题，复杂度是多少->log(n)*O(n)
```
MergeSort, QuickSort
```
```
前序遍历，中序遍历和后续遍历在面试题里面主要考察非递归的实现方式
前序：https://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
中序：https://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/
后序：https://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/
```
> 在二叉树的问题里考虑边界情况时，不光要考虑节点为空的情况，还需考虑节点为叶子节点时的情况
```
参见https://www.jiuzhang.com/solutions/binary-tree-paths/
```

##### Result Type
```
当返回一个值不够用时，自己新建一个数据类型，封装多个值
不要过于追求程序代码的简洁，要避免程序的二义性
```

##### 多用常量的定义
```
例如return -1 这样的定义，直接写难以理解-1代表什么意思，但是如果定义一个常量值，代码的含义就一目了然
```

> 好好看看PPT