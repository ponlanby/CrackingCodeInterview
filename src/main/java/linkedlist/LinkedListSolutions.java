package linkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class LinkedListSolutions {

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

    public boolean removeNode(ListNode pNode) {
        // write code here
        if (null == pNode.next) {
            return false;
        }
        ListNode firstNode = pNode.next;
        ListNode secondNode = firstNode.next;
        pNode.val = firstNode.val;
        pNode.next = secondNode;

        return true;
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (null == pHead.next) {
            return pHead;
        }
        ListNode smallerNode, biggerNode, smallHeadNode, biggerHeadNode;
        smallerNode = smallHeadNode = biggerNode = biggerHeadNode = null;
        while (null != pHead.next) {
            if (x > pHead.val) {
                if (null == smallerNode) {
                    smallerNode = smallHeadNode = new ListNode(pHead.val);
                } else {
                    smallerNode.next = new ListNode(pHead.val);
                    smallerNode = smallerNode.next;
                }
            } else {
                if (null == biggerNode) {
                    biggerNode = biggerHeadNode = new ListNode(pHead.val);
                } else {
                    biggerNode.next = new ListNode(pHead.val);
                    biggerNode = biggerNode.next;
                }
            }
            pHead = pHead.next;
        }
        if (x > pHead.val) {
            smallerNode.next = new ListNode(pHead.val);
            smallerNode = smallerNode.next;
        } else {
            biggerNode.next = new ListNode(pHead.val);
            biggerNode = biggerNode.next;
        }

        if (null == smallHeadNode) {
            return biggerHeadNode;
        }
        smallerNode.next = biggerHeadNode;
        return smallHeadNode;
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode head = new ListNode(-1);
        ListNode pivot = head;
        int add = 0;
        while (null != a || null != b || 0 != add) {
            int aval = null != a ? a.val : 0;
            int bval = null != b ? b.val : 0;

            int sum = aval + bval + add;
            pivot.next = new ListNode(sum % 10);
            pivot = pivot.next;
            add = sum / 10;

            a = null != a ? a.next : null;
            b = null != b ? b.next : null;
        }

        return head.next;
    }

    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (null == pHead) {
            return false;
        }
        if (null == pHead.next) {
            return true;
        }
        Stack<Integer> firstHalf = new Stack<Integer>();
        ListNode slowerPointer = pHead;
        ListNode fasterPointer = pHead;
        while (null != fasterPointer && null != fasterPointer.next) {
            firstHalf.push(slowerPointer.val);
            slowerPointer = slowerPointer.next;
            fasterPointer = fasterPointer.next.next;
        }
        // 链表为奇数,跳过中间节点
        if (null != fasterPointer) {
            slowerPointer = slowerPointer.next;
        }
        while (null != slowerPointer) {
            if (firstHalf.pop() != slowerPointer.val) {
                return false;
            }
            slowerPointer = slowerPointer.next;
        }
        return true;
    }
}
