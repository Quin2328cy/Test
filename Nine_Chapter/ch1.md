```Markdown 基本语法
ctrl+alt+O 浏览器预览
ctrl+alt+x 导出为html--直接导出到markdown文件所在文件夹
ctrl+alt+c 拷贝html代码
```
# 第一章

## 基本的编码规范
1. 记得加括号什么的，一行也要换行
2. 一元运算符不加空格，二元运算符加空格 +、-、=、；、，
3. 注意参数判断，避免数组越界等

## 题型一：找全子集（排列组合问题-> 深度优先搜索）
> DFS 空间复杂度O(n)
> BFS 空间复杂度更高--> DFS更节省空间

#### 去重问题
1. 错误思路： 先找到所有的解，然后去重-->浪费时间，计算量过大
2. 正确思路： 找代表（用排序等操作）

> 所有的整数都是以0作为开头，所有的字符串都是以空串作为开头，所有的集合都是以空集作为开头

#### 递归三要素
1. 递归的定义
2. 递归的拆解-> 如何使规模变得更小
3. 递归的出口

> Recursion-DFS
> 回溯基本可以认为是DFS

https://www.jiuzhang.com/video/subsets-ii/

##### 排列组合模板
```Java
private void helper(int[] nums,
		    int offset,
		    ArrayList<Integer> subset,
		    ArrayList<ArrayList<Integer>> results){
	result.add(new ArrayList<Integer>(subset));
	for(int i = offset; i < nums.length; i++){
		subset.add(nums[i]);
		helper(nums, i + 1, subset, results);
		subset.remove(subset.size() - 1);
	}
}

```

##### 误区避免
1. 别做难题，主攻medium和bug free,编程速度.
2. 要和面试官愉快交流，一起合作解觉问题，别试图证明面试官煞笔
3. 不要浪费时间在基本不会考且又很心虚的内容，e.g KMP,红黑树，AVL,ACM竞赛题
