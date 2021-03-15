public class MaxPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private class Answer {
        public int value = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        Answer ans = new Answer();
        solve(root, ans);
        return ans.value;
    }

    private int solve(TreeNode root, Answer ans) {
        if (root == null) return 0;

        int leftSubTreePathSum =  Integer.max(0,solve(root.left,ans));
        int rightSubTreePathSum = Integer.max(0,solve(root.right,ans));

        int subPathSum =  root.val + Integer.max(leftSubTreePathSum, rightSubTreePathSum);
        ans.value = Integer.max(ans.value,leftSubTreePathSum + rightSubTreePathSum + root.val);

        return subPathSum;
    }

}
