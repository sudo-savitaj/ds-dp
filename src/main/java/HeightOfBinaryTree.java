public class HeightOfBinaryTree {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public void display() {

    }

    int height(Node node) {
        if(node == null) return 0;
        return 1 + Integer.max(height(node.left),height(node.right));
    }

}
