package com.zhangj.ymm.thread.juc.collections;

/**
 * @author zhangj
 * @date 2019/5/1
 */
public class PriorityLinkedList<E extends Comparable<E>> {
    private final static String PLAIN_NULL = "null";
    private Node<E> first;
    private final Node<E> NULL = null;
    private int size;

    public static void main(String[] args) {
        PriorityLinkedList<Integer> list = PriorityLinkedList.of(1, 3, 2, 6, 4);
        Node<Integer> first = list.first;
        while (first != null) {
            System.out.println(list.first.value);
            first = first.next;
        }
    }

    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.value == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("The linked list is empty");
        }
        Node<E> node = first;
        first = node.next;
        this.size--;
        return node.value;
    }

    public static <E extends Comparable<E>> PriorityLinkedList<E> of(E... elements) {
        final PriorityLinkedList linkedList = new PriorityLinkedList();
        if (elements.length > 0) {
            for (E ele : elements) {
                linkedList.addFirst(ele);
            }
        }
        return linkedList;
    }

    public PriorityLinkedList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        Node<E> previous = NULL;
        Node<E> current = first;
        while (current != null && e.compareTo(current.value) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        this.size++;
        return this;
    }

    public PriorityLinkedList() {
        this.first = NULL;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (null != value) {
                return value.toString();
            }
            return PLAIN_NULL;
        }
    }
}
