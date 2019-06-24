package com.zhangj.ymm.data_struct.linkedList;

import lombok.Data;

import java.util.Scanner;

/**
 * @author zhangj
 * @date 2019/6/21
 * 基于单链表的LRU算法
 */
public class LRUBaseLinkedList<T> {
    /**
     * 链表默认长度
     */
    private final static int DEFAULT_CAPACITY = 10;
    /**
     * 头节点
     */
    private SNode<T> headNode;
    /**
     * 链表长度
     */
    private int length;
    /**
     * 链表容量
     */
    private int capacity;

    public LRUBaseLinkedList(int capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 插入元素
     *
     * @param data
     */
    public void add(T data) {
        SNode preNode = findPreNode(data);
        if (preNode != null) {
            //链表中存在,删除原数据,再插入到链表头
            deleteNode(preNode);
            insertBegin(data);
        } else {
            //链表中不存在,如果链表没满,则插入到头,满了,则删除尾,插入头
            if (length >= this.capacity) {
                deleteEnd();
            }
            insertBegin(data);
        }
    }

    /**
     * 删除node节点的下一个元素
     *
     * @param node
     */
    public void deleteNode(SNode node) {
        SNode temp = node.getNext();
        node.setNext(temp.getNext());
        length--;
    }

    /**
     * 链表头部插入节点
     */
    public void insertBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 删除链表尾节点
     */
    public void deleteEnd() {
        SNode ptr = headNode;
        if (ptr.getNext() == null) {
            //空节点直接返回
            return;
        }
        //查找到倒数第二个节点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        SNode temp = ptr.getNext();
        ptr.setNext(null);
        temp = null;
        length--;
    }

    /**
     * 获取查找到元素的前一个节点
     *
     * @param data
     * @return
     */
    public SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void printAll() {
        SNode next = headNode.getNext();
        while (next != null) {
            System.out.println(next.getElement() + ",");
            next = next.getNext();
        }
        System.out.println();
    }

    @Data
    public class SNode<T> {
        public T element;
        public SNode next;

        public SNode() {
            this.next = null;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>(5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.add(scanner.nextInt());
            list.printAll();
        }
    }
}
