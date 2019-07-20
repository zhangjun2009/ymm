package com.zhangj.ymm.data_struct.linkedList;

import lombok.Data;

/**
 * @author zhangj
 * @date 2019/6/28
 */
public class LinkedListAlgo {
    /**
     * 单链表反转
     *
     * @return
     */
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Data
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
