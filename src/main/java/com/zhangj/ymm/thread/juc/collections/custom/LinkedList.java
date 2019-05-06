package com.zhangj.ymm.thread.juc.collections.custom;

/**
 * @author zhangj
 * @date 2019/5/1
 */
public class LinkedList<E> {
    private final static String PLAIN_NULL = "null";
    private Node<E> first;
    private final Node<E> NULL = null;
    private int size;

    public static void main(String[] args) {
        LinkedList<String> linkedList = LinkedList.of("a", "b", "c", "d");
        linkedList.addFirst("e").addFirst("f");
        System.out.println(linkedList.size);
        System.out.println(linkedList.contains("a"));
        System.out.println(linkedList.contains("dd"));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.size());
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

    public static <E> LinkedList<E> of(E... elements) {
        final LinkedList linkedList = new LinkedList();
        if (elements.length > 0) {
            for (E ele : elements) {
                linkedList.addFirst(ele);
            }
        }
        return linkedList;
    }

    public LinkedList<E> addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        newNode.next = first;
        this.size++;
        this.first = newNode;
        return this;
    }

    public LinkedList() {
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
