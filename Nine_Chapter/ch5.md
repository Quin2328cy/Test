> Combination Sum
1. 输入中需要考虑到重复的存在
1.1. 

```java
if(nums == null || nums.length == 0){

}


```
> Combination Sum II
记得去重

> Premutations
```
排列问题不需要考虑去重
```
```java
if(nums.length == 0){
    results.add(new ArrayList<Integer>());
    return results;
}

list<Integer> permutation = new ArrayList<Integer>();
Set<Integer> set = new HashSet<>();
helper(nums, permutation, set, results);

return results;


////////////////////////////////////////

public void helper(int[] nums,
                   List<Integer> permutation,
                   Set<integer> set,
                   List<List<Integer>> results){
    if(permutation.size() == nums.length){
        results.add(new ArrayList<Integer>(permutation));
        return;
    }

    for(int i = 0; i < nums.length; i++){
        //去除输入元素中的重复
        if(set.contains(nums[i])){
            continue;
        }

        permutation.add(nums[i]);
        set.add(nums[i]);
        helper(nums, permutation, set, results);
        set.remove(nums[i]);
        permutation.remove(permutation.size() - 1);
    }
}
```

###### 所有的切割问题都是组合问题
n个字母的切割问题，就是n-1个数字的组合问题

### N皇后
```
1. 注意函数的封装
```

### 图搜索
