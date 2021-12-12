package dev.jessehaniel;

public class MergeKSortedLists {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        var app = new MergeKSortedLists();
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var output = app.mergeKLists(new ListNode[]{list1, list2});
        System.out.println(output);//[1,1,2,3,4,4]

        output = app.mergeKLists(new ListNode[]{});
        System.out.println(output);//[]

        list1 = new ListNode();
        list2 = new ListNode(0);
        output = app.mergeKLists(new ListNode[]{list1, list2});
        System.out.println(output);//[1,1,2,3,4,4]
    }
}
