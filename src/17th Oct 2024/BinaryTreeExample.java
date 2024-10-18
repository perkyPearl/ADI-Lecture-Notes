import java.util.*;

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(4);

        System.out.println("Binary Tree");
        tree.preorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.levelOrder(tree.root);
        System.out.println("\nBinary Search Tree");
        
        BST bst = new BST();
        
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        
        tree.preorder(bst.root);
        System.out.println();
        tree.postorder(bst.root);
        System.out.println();
        tree.inorder(bst.root);
        System.out.println();
        tree.levelOrder(bst.root);
        
        System.out.println("\nAfter Deletion:");

        bst.root = bst.delete(bst.root, 4);
        tree.preorder(bst.root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inorder(root.left);
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    void delete(int key) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node keynode = null;
            Node temp = null;
            Node last = null;
            while (!q.isEmpty()) {
                temp = q.poll();
                if (temp.data == key) {
                    keynode = temp;
                }
                if (temp.left != null) {
                    last = temp;
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    last = temp;
                    q.add(temp.right);
                }
            }
            if (keynode != null) {
                keynode.data = temp.data;
                if (last.right != null) {
                    last.right = null;
                } else {
                    last.left = null;
                }
            }
        }
    }
}

class BST {
    Node root;

    BST() {
        this.root = null;
    }

    void insert(int val) {
        root = add(root, val);
    }

    Node add(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = add(root.left, val);
        } else if (val > root.data) {
            root.right = add(root.right, val);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inorder(root.left);
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.data = minVal(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    int minVal(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}
