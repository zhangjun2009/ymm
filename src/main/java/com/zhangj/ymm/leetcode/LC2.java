package com.zhangj.ymm.leetcode;

/**
 * @author zhangj
 * @date 2019/5/10
 * <a>https://leetcode-cn.com/problems/add-two-numbers/</a>
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LC2 {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(1), new ListNode(8)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode root = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode curListNode = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            curListNode.val = sum % 10;
            carry = sum / 10;
            pre.next = curListNode;
            pre = curListNode;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return root.next;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
