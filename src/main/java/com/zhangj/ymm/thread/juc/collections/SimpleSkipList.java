package com.zhangj.ymm.thread.juc.collections;

import java.util.Random;

/**
 * @author zhangj
 * @date 2019/5/4
 */
public class SimpleSkipList {
    private final static byte HEAD_NODE = (byte) -1;
    private final static byte DATA_NODE = (byte) 0;
    private final static byte TAIL_NODE = (byte) -1;
    private Node head;
    private Node tail;
    private int size;
    private int height;
    private Random random;

    public SimpleSkipList() {
        this.head = new Node(null, HEAD_NODE);
        this.tail = new Node(null, TAIL_NODE);
        head.right = tail;
        tail.left = head;
        this.random = new Random(System.currentTimeMillis());
    }

    public Node find(Integer element) {
        Node current = head;
        for (; ; ) {
            while (current.right.bit != TAIL_NODE && current.right.value <= element) {
                current = current.right;
            }
            if (current.down != null) {
                current = current.down;
            } else {
                break;
            }
        }
        return current;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node {
        private Integer value;
        private Node up, down, left, right;
        private byte bit;

        public Node(Integer value, byte bit) {
            this.value = value;
            this.bit = bit;
        }

        public Node(Integer value) {
            this(value, DATA_NODE);
        }
    }
}
