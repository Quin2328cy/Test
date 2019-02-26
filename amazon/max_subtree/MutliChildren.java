package amazon.max_subtree;

import java.util.ArrayList;
import java.util.List;

public class MutliChildren {
    // 注意double类型的数据,可能会有溢出, 注意叶子节点是否算入
    class CategoryNode{
        int value;
        List<CategoryNode> subCategoryNode;
        public CategoryNode(int val) {
            this.value = val;
            subCategoryNode = new ArrayList<>();
        }
    }
    class Result {
        CategoryNode node;
        // 如果有溢出的情况,考虑换成double
        int sum, size;
        public Result(CategoryNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    public CategoryNode getMostPopularNode(CategoryNode rootCategory) {
        if(rootCategory == null) {
            return null;
        }
        Result res = null;
        Result rootRes = helper(rootCategory, res);
        return res.node;
    }

    public Result helper(CategoryNode root, Result res) {
        if(root == null) {
            return new Result(null, 0, 0);
        }
        ArrayList<Result> results = new ArrayList<Result>();
        for(CategoryNode n : root.subCategoryNode) {
            results.add(helper(n, res));
        }

        int childSum = 0, childSize = 0;
        for(Result r : results) {
            childSum += r.sum;
            childSize += r.size;
        }
        Result curRes = new Result(root, childSum + root.value, childSize + 1);
        if(res == null || curRes.sum * res.size > res.sum * curRes.size) {
            if(curRes.size > 1) {
                res = curRes;
            }
        }

        return curRes;
    }
}
