package com.zhangj.ymm.data_struct;

/**
 * @author zhangj
 * @date 2019/6/11
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {

    public BinarySearchTree(BinarySearchNode<T> mRoot) {
        this.mRoot = mRoot;
    }

    //树的根节点
    private BinarySearchNode<T> mRoot;

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    public void preOrder(BinarySearchNode<T> node) {
        if (node != null) {
            System.out.println("preOrder->node.value=" + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(mRoot);
    }

    public void midOrder(BinarySearchNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.println("midOrder->node.value=" + node.value);
            midOrder(node.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    public void postOrder(BinarySearchNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println("postOrder->node.value=" + node.value);
        }
    }

    /**
     * 递归查找节点的值为key的节点
     *
     * @return
     */
    public BinarySearchNode<T> recusiveSearch(T key) {
        return recusiveSearch(mRoot, key);
    }

    public BinarySearchNode<T> recusiveSearch(BinarySearchNode<T> node, T key) {
        if (null == node) {
            return node;
        }
        int result = key.compareTo(node.value);
        if (result < 0) {
            return recusiveSearch(node.left, key);
        } else if (result > 0) {
            return recusiveSearch(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * 非递归查找节点的值为key的节点
     *
     * @param key
     * @return
     */
    public BinarySearchNode<T> serach(T key) {
        return serach(mRoot, key);
    }

    public BinarySearchNode<T> serach(BinarySearchNode<T> node, T key) {
        while (node != null) {
            int result = key.compareTo(node.value);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }

    /**
     * 查找最大值
     *
     * @param node
     * @return
     */
    public BinarySearchNode<T> max(BinarySearchNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public T max() {
        BinarySearchNode<T> maxNode = max(mRoot);
        if (maxNode != null) {
            return maxNode.value;
        }
        return null;
    }

    /**
     * 查找最小值
     *
     * @param node
     * @return
     */
    public BinarySearchNode<T> min(BinarySearchNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public T min() {
        BinarySearchNode<T> minNode = min(mRoot);
        if (minNode != null) {
            return minNode.value;
        }
        return null;
    }

    /**
     * 节点前驱
     *
     * @param node
     * @return
     */
    public BinarySearchNode<T> precursor(BinarySearchNode<T> node) {
        //如果节点存在左子树,则前驱节点为左子树中最大节点
        if (node.left != null) {
            return max(node.left);
        }
        //如果节点没有左子树
        //(1):x是一个右孩子,则前驱节点是它的父节点
        //(2):x是一个左孩子,查找节点的最低父节点,并且父节点必须要有右孩子
        BinarySearchNode<T> parent = node.parent;
        while (parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * 节点后继
     *
     * @param node
     * @return
     */
    public BinarySearchNode<T> subsequent(BinarySearchNode<T> node) {
        //如果节点存在右子树,则前驱节点为右子树中最小节点
        if (node.right != null) {
            return min(node.right);
        }
        //如果节点没有右子树
        //(1):x是一个左孩子,则后继节点是它的父节点
        //(2):x是一个右孩子,查找节点的最低父节点,并且父节点必须要有左孩子
        BinarySearchNode<T> parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * 将节点插入到树中
     *
     * @param tree
     * @param node
     */
    public void insert(BinarySearchTree<T> tree, BinarySearchNode<T> node) {
        int cmp;
        BinarySearchNode<T> y = null;
        BinarySearchNode<T> x = tree.mRoot;
        //查找node的插入位置
        while (x != null) {
            y = x;
            cmp = node.value.compareTo(x.value);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            tree.mRoot = node;
        } else {
            cmp = node.value.compareTo(y.value);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }
    }

    /**
     * 新建节点,并将其插入到树中
     *
     * @param t
     */
    public void insert(T t) {
        BinarySearchNode<T> node = new BinarySearchNode<>(t, null, null, null);
        insert(this, node);
    }

    public BinarySearchNode<T> remove(BinarySearchTree<T> tree, BinarySearchNode<T> node) {
        //删除节点的子树
        BinarySearchNode<T> x = null;
        //真正删除的节点
        BinarySearchNode<T> y = null;
        //获取真正删除的节点
        if (node.left == null || node.right == null) {
            y = node;
        } else {
            //后继节点
            y = subsequent(node);
        }
        //获取真正删除节点的子树
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        //删除真正删除节点
        if (x != null) {
            x.parent = y.parent;
        }
        //子树拼接
        if (y.parent == null) {
            tree.mRoot = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        //值替换
        if (y != node) {
            node.value = y.value;
        }
        return y;
    }

    public class BinarySearchNode<T extends Comparable<T>> {
        //健值
        private T value;
        //左节点
        private BinarySearchNode<T> left;
        //右节点
        private BinarySearchNode<T> right;
        //父节点
        private BinarySearchNode<T> parent;

        public BinarySearchNode(T value, BinarySearchNode<T> left, BinarySearchNode<T> right, BinarySearchNode<T> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
