public class MaxSumPathBwTwoLeafNodes {

    private class Answer {
        public int val = Integer.MIN_VALUE;
    }

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
        }

        Node(int val, Node left, Node right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }


    int maxPathSum(Node root)
    {
        Answer ans = new Answer();
        solve(root,ans);
        return ans.val;
    }

    private int solve(Node node, Answer res) {
        if(node == null) return 0;

        int ls = solve(node.left,res);
        int rs = solve(node.right,res);

        int maxPathSumForRoot = Integer.max(ls,rs) + node.data;

        if(node.left!=null&&node.right!=null)
            res.val = Integer.max(res.val,ls+rs+node.data);
        return maxPathSumForRoot;
    }
}
