package com.BinaryTree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BT {
    Node root;

    // Insert method for a binary tree using a level-order approach
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        // Insert recursively
        insertRecursively(root, newNode);
    }

    private void insertRecursively(Node current, Node newNode) {
        if (current.left == null) {
            current.left = newNode;
        } else if (current.right == null) {
            current.right = newNode;
        } else {
            // Try inserting in the left subtree first
            insertRecursively(current.left, newNode);
            // Check if the new node was inserted, otherwise, try the right subtree
            if (current.left != null && current.left != newNode) {
                insertRecursively(current.right, newNode);
            }
        }
    }

    // In-order traversal for a binary tree
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Delete method for a binary tree (finding and deleting the deepest node manually)
    public void delete(int data) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == data) {
                root = null;
            }
            return;
        }

        Node target = findNode(root, data);
        if (target != null) {
            Node deepestNode = findDeepestNode(root);
            if (deepestNode != null) {
                target.data = deepestNode.data;
                deleteDeepest(root, deepestNode);
            }
        }
    }

    private Node findNode(Node root, int data) {
        if (root == null) return null;
        if (root.data == data) return root;

        Node leftResult = findNode(root.left, data);
        if (leftResult != null) return leftResult;

        return findNode(root.right, data);
    }

    private Node findDeepestNode(Node root) {
        if (root == null) return null;

        // Perform a DFS to find the last node (rightmost in the last level)
        if (root.left == null && root.right == null) {
            return root;
        }

        Node leftDeep = findDeepestNode(root.left);
        Node rightDeep = findDeepestNode(root.right);

        return rightDeep != null ? rightDeep : leftDeep;
    }

    private void deleteDeepest(Node root, Node nodeToDelete) {
        if (root == null) return;

        if (root.left != null) {
            if (root.left == nodeToDelete) {
                root.left = null;
                return;
            } else {
                deleteDeepest(root.left, nodeToDelete);
            }
        }

        if (root.right != null) {
            if (root.right == nodeToDelete) {
                root.right = null;
                return;
            } else {
                deleteDeepest(root.right, nodeToDelete);
            }
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        BT tree = new BT();
        
        // Inserting nodes into the binary tree
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
       

        // In-order traversal before deletion
        System.out.println("In-order traversal before deletion:");
        tree.inOrder();

        // Delete nodes
        tree.delete(7);  // Deleting an internal node
        tree.delete(15); // Deleting a leaf node
        tree.delete(8);  // Deleting the root node

        // In-order traversal after deletion
        System.out.println("In-order traversal after deletion:");
        tree.inOrder();
    }
}
