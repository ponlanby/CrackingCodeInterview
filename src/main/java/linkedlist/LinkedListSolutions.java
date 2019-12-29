package linkedlist;

public class LinkedListSolutions {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pivot = head;
        while (--k > 0) {
            if (pivot.next == null) {
                return null;
            }
            pivot = pivot.next;
        }
        while (pivot.next != null) {
            pivot = pivot.next;
            head = head.next;
        }
        return head;
    }
}
