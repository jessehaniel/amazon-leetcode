package dev.jessehaniel.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node {

        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;
    private Node temp = root;

    private void inorder(Node temp) {
        if (temp == null) {
            return;
        }
        this.inorder(temp.left);
        System.out.print(temp.key + " ");
        this.inorder(temp.right);
    }

    private void insert(Node node, int key) {
        if (node == null) {
            this.root = new Node(key);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.remove();

            if (node.left == null) {
                node.left = new Node(key);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(key);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    private void deleteDeepest(Node root, Node delNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;

        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    private void delete(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        Node keyNode = null;

        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if (temp.key == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        }
    }

    private void printLevelOrder() {
        int h = this.height(this.root);
        for (int i=1; i <= h; i++) {
            this.printCurrentLevel(this.root, i);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = this.height(node.left);
        int rightHeight = this.height(node.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private void printCurrentLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.key + " ");
        } else if (level > 1) {
            this.printCurrentLevel(node.left, level - 1);
            this.printCurrentLevel(node.right, level - 1);
        }
    }

    public static void main(String[] args) {
        var app = new BinaryTree();
        app.root = new Node(10);
        app.root.left = new Node(11);
        app.root.left.left = new Node(7);
        app.root.right = new Node(9);
        app.root.right.left = new Node(15);
        app.root.right.right = new Node(8);

        System.out.println("Level order traversal of binary tree is ");
        app.printLevelOrder();

        System.out.println("\nInorder traversal before insertion: ");
        app.inorder(app.root);

        app.insert(app.root, 12);

        System.out.println("\nInorder traversal after insertion: ");
        app.inorder(app.root);

        app.delete(app.root, 11);

        System.out.println("\nInorder traversal after deletion: ");
        app.inorder(app.root);
    }


}
