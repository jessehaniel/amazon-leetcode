package dev.jessehaniel;

public class CopyListRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }

        node = head;
        while (node != null) {
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }

        Node headOldList = head;
        Node headNewList = head.next;
        Node headNew = head.next;
        while (headOldList != null) {
            headOldList.next = headOldList.next.next;
            headNewList.next = headNewList.next != null ? headNewList.next.next : null;
            headOldList = headOldList.next;
            headNewList = headNewList.next;
        }

        return headNew;
    }

}
