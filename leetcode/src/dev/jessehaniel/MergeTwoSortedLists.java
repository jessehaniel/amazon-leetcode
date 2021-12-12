package dev.jessehaniel;

public class MergeTwoSortedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + getString() + "]";
        }

        private String getString() {
            return val + (next != null ? "," + next.getString() : "");
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        var app = new MergeTwoSortedLists();
        var list1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        var list2 = new ListNode(1,new ListNode(3, new ListNode(4)));
        var output = app.mergeTwoLists(list1, list2);
        System.out.println(output);//[1,1,2,3,4,4]

        list1 = new ListNode();
        list2 = new ListNode();
        output = app.mergeTwoLists(list1, list2);
        System.out.println(output);//[]

        list1 = new ListNode();
        list2 = new ListNode(0);
        output = app.mergeTwoLists(list1, list2);
        System.out.println(output);//[1,1,2,3,4,4]
    }
}
