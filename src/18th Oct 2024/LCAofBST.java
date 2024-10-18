import java.util.*;

public class LCAofBST {
    public static void main(String[] args) {
        BST bst = new BST();
        
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        
        System.out.println("Inorder Triversal: ");
        bst.inorder(bst.root);

        Node lca = bst.LCAFinder(bst.root, 2, 6);
        if (lca != null) {
            System.out.println("\nLCA: " + lca.data);
        } else {
            System.out.println("No LCA found.");
        }
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

    Node LCAFinder(Node root, int n1,int n2){
        if(root==null) return null;

        if(n1 < root.data && n2 > root.data){
            return LCAFinder(root.left, n1, n2);
        }
        
        if(n2 > root.data && n2 < root.data){
            return LCAFinder(root.right, n1, n2);
        }

        return root;
    }
}
