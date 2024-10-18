class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    void leftViewUtil(TreeNode node, int level, int[] maxLevel) {
        if (node == null) {
            return;
        }

        if (maxLevel[0] < level) {
            System.out.print(node.val + " ");
            maxLevel[0] = level;
        }

        leftViewUtil(node.left, level + 1, maxLevel);
        leftViewUtil(node.right, level + 1, maxLevel);
    }

    void leftView() {
        int[] maxLevel = {0};
        leftViewUtil(root, 1, maxLevel);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.left.left.left = new TreeNode(7);

        System.out.println("Left view of the BST:");
        tree.leftView();
    }
}
