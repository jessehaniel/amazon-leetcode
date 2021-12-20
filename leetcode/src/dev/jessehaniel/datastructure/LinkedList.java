package dev.jessehaniel.datastructure;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            super();
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +  data + '}';
        }
    }

    private Node<T> head;

    public void add(T data) {
        final var newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            var node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public void add(T data, int index) {
        final var newNode = new Node<>(data);
        if (index == 0) {
            if (this.head != null) {
                newNode.next = this.head;
            }
            this.head = newNode;
        } else {
            var node = this.head.next;
            var prevNode = this.head;
            int i = 1;
            while (i++ < index) {
                prevNode = node;
                node = node.next;
            }
            newNode.next = node;
            prevNode.next = newNode;
        }
    }

    @Override
    public String toString() {
        var list = new ArrayList<Node<T>>();
        var node = this.head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        return "LinkedList[ "+ list.stream().map(Node::toString).collect(Collectors.joining(", ")) + " ]";
    }

    public static void main(String[] args) {
        var linkedList = new LinkedList<String>();
        linkedList.add("apple");
        linkedList.add("grape");
        linkedList.add("banana", 1);
        System.out.println(linkedList);
    }
}
