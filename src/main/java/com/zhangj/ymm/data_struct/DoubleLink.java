package com.zhangj.ymm.data_struct;

/**
 * @author zhangj
 * @date 2019/6/9
 * 双向链表的java实现
 */
public class DoubleLink<T> {
    /**
     * 链表的头
     */
    public Node<T> head;
    /**
     * 链表节点的个数
     */
    public int count;

    public DoubleLink() {
        /**
         * 创建表头,表头没有数据
         */
        head = new Node<>(null, null, null);
        /**
         * 初始节点个数为0
         */
        count = 0;
    }

    /**
     * 返回节点的数量
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 获取index位置处的节点
     *
     * @param index 位置
     * @return
     */
    public Node<T> getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        /**
         * 正向查找
         */
        if (index <= count / 2) {
            Node<T> nextNode = head.next;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.next;
            }
            return nextNode;
        }
        /**
         * 反向查找
         */
        Node<T> prevNode = head.prev;
        for (int j = 0; j < count - index - 1; j++) {
            prevNode = prevNode.prev;
        }
        return prevNode;
    }

    /**
     * 获取index位置节点的值
     * * @param index
     *
     * @return
     */
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * 获取第一个节点的值
     *
     * @return
     */
    public T getFirst() {
        return getNode(0).value;
    }

    /**
     * 获取最后一个节点的值
     *
     * @return
     */
    public T getLast() {
        return getNode(count - 1).value;
    }

    /**
     * 将节点插入到第index位置之前
     *
     * @param index 位置
     * @param t     值
     */
    public void insert(int index, T t) {
        if (index == 0) {
            Node<T> node = new Node<>(t, head, head.next);
            head.next.prev = node;
            head.next = node;
            count++;
            return;
        }
        Node<T> node = getNode(index);
        Node<T> tNode = new Node<>(t, node.prev, node);
        node.prev.next = tNode;
        node.next = node;
        count++;
    }

    /**
     * 将节点插入第一个节点处
     *
     * @param t
     */
    public void insertFirst(T t) {
        insert(0, t);
    }

    /**
     * 将节点追加到链表的末尾
     *
     * @param t 值
     */
    public void appendLast(T t) {
        Node<T> tNode = new Node<>(t, head.prev, head);
        head.prev.next = tNode;
        head.prev = tNode;
        count++;
    }

    /**
     * 删除index位置的节点
     *
     * @param index 位置
     */
    public void del(int index) {
        Node<T> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        count--;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFirst() {
        del(0);
    }

    /**
     * 删除最后一个节点
     */
    public void deleteLast() {
        del(count - 1);
    }


    public class Node<T> {
        public T value;
        public Node prev;
        public Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
