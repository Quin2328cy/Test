package amazon.max_subtree;

public class BinararyTree {
    /**
     * Definition of TreeNode: --- This version use global parameters
     */
    // 注意double类型的数据,可能会有溢出, 注意叶子节点是否算入
    // This version use global parameters
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        int sum, size;
        TreeNode node;

        public ResultType(int sum, int size, TreeNode node) {
            this.sum = sum;
            this.size = size;
            this.node = node;
        }

    }

    ResultType res = new ResultType(0, 0, null);

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // ResultType res = new ResultType(0, 0, null);
        // helper(res, root);
        helper(root);
        if (res != null) {
            return res.node;
        }
        return null;

    }

    private ResultType helper(TreeNode node) {
        // private ResultType helper(ResultType res, TreeNode node) {
        if (null == node) {
            return new ResultType(0, 0, null);
        }

        ResultType left_res = helper(node.left);
        // ResultType left_res = helper(res, node.left);
        ResultType right_res = helper(node.right);
        // ResultType right_res = helper(res, node.right);

        ResultType root_res = new ResultType(left_res.sum + right_res.sum + node.val,
                left_res.size + 1 + right_res.size, node);

        if (res.node == null || (res.sum * root_res.size) < root_res.sum * res.size) {
            System.out.println("Get in" + root_res.sum);
            res = root_res;
        }
        return root_res;
    }

}
