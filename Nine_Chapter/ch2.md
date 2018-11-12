## 二分法专题
> Find the any/first/last position of target
```
T(n) = T(n/2) + O(1)(比较大小) = O(log N)
通过一个比较大小的操作O(1)把问题规模减小一半
```

T(n) = T(n/2) + O(n) ->时间复杂度为 O(n)
```
• O(1) 极少 
• O(logn) 几乎都是二分法 
• O(√n) 几乎是分解质因数 --暂时不会写，有空查一下
• O(n) 高频 
• O(nlogn) 一般都可能要排序 
• O(n2) 数组，枚举，动态规划 
• O(n3) 数组，枚举，动态规划 
• O(2^n) 与组合有关的搜索  
• O(n!) 与排列有关的搜索
```

> 能不递归就不递归--递归不是一个好的编程习惯
> 所以在二分法的时候，尽量用while
```
用递归之前询问面试官
```

> Binary Search模板
```Java
public int binarySearch(int[] nums, int target){
	if(nums == null || nums.length == 0){
		return -1;
	}
	int start = 0, end = nums.length - 1;
	while(start + 1 < end){ // 避免死循环
		int mid = start + (end - start) / 2; //用end - start是为了避免当end 和start 都很大时，两数相加int溢出
		if(nums[mid] == target){
			end = mid; //???
		}else if(nums[mid] < target){
			start = mid;
			// or start = mid + 1;
		}else if(nums[mid] > target){
			end = mid;
			// or end = mid - 1;
		}
	}

	if(nums[start] == target){
		return start;
	}
	if(nums[end] == target){
		return end;
	}
	return -1;
}
```
```
search in a big sorted array-->用倍增的方式来确定待查找数组的上界
```
