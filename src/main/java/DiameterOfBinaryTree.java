public class DiameterOfBinaryTree {

    private class Node {
        int value;
        Node left;
        Node right;
    }

     class Answer{
        int value = Integer.MIN_VALUE;
    }

    public void display() {

    }

    int diameter(Node root) {
        Answer diameter = new Answer();
        solve(root,diameter);
        return diameter.value;
    }

    private int solve(Node root, Answer diameter) {
        if(root ==  null) return 0;

        int leftHeight = solve(root.left,diameter);
        int rightHeight = solve(root.right,diameter);

        int maxSideLength = Integer.max(leftHeight,rightHeight) +1;
        diameter.value = Integer.max(diameter.value,leftHeight + rightHeight +1);

        return maxSideLength;
    }

}
