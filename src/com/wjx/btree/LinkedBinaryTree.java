package com.wjx.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther:wjx
 * @Date:2019/5/28
 * @Description:com.wjx.btree
 * @version:1.0
 */
public class LinkedBinaryTree implements BinaryTree {
    private Node root; // 默认为null，也就是空树

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // 二叉树的结点数=左子树的结点数+右子树的结点数+1
    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的结点数
        int leftSize = this.size(root.leftChild);
        // 获取右子树的结点数
        int rightSize = this.size(root.rightChild);
        // 返回总的结点数
        return leftSize + rightSize + 1;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    // 获取树的度
    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的高度
        int leftHeight = this.getHeight(root.leftChild);
        // 获取右子树的高度
        int rightHeight = this.getHeight(root.rightChild);
        // 返回树的高度
        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    @Override
    public Node findKey(int value) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        System.out.println("递归先序遍历：");
        this.preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        // 输出根结点的值
        System.out.print(root.data + " ");
        // 遍历左子树
        this.preOrderTraverse(root.leftChild);
        // 遍历右子树
        this.preOrderTraverse(root.rightChild);
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("递归中序遍历：");
        this.inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        // 遍历左子树
        this.inOrderTraverse(root.leftChild);
        // 输出根结点的值
        System.out.print(root.data + " ");
        // 遍历右子树
        this.inOrderTraverse(root.rightChild);
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("递归后序遍历：");
        this.postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node root) {
        if (root != null) {
            // 遍历左子树
            this.postOrderTraverse(root.leftChild);
            // 遍历右子树
            this.postOrderTraverse(root.rightChild);
            // 输出根结点的值
            System.out.print(root.data + "\t");
        }
    }

    @Override
    public void inOrderByStack() {
        System.out.println("中序非递归遍历：");
        this.inOrderByStack(root);
        System.out.println();
    }

    private void inOrderByStack(Node root) {
        // 创建一个栈
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            // 先遍历左子树,直到左子树为空
            while (current != null) {
                stack.push(current); // 将结点压入栈顶
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop(); // 出栈
                System.out.print(current.data + "\t"); // 输出结点
                current = current.rightChild; // 获取当前结点的右孩子
            }
        }
    }

    @Override
    public void preOrderByStack() {
        System.out.println("先序非递归遍历：");
        this.preOrderByStack(root);
        System.out.println();
    }

    private void preOrderByStack(Node root) {
        // 创建一个栈
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            // 输出根结点，然后遍历左孩子结点,直到左孩子结点为空
            while (current != null) {
                System.out.print(current.data + "\t");
                stack.push(current); // 将结点压入栈顶
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop(); // 出栈
                current = current.rightChild; // 获取当前结点的右孩子
            }
        }
    }

    @Override
    public void postOrderByStack() {
        System.out.println("后序非递归遍历：");
        this.postOrderByStack(root);
        System.out.println();
    }

    private void postOrderByStack(Node root) {
        Deque<Node> stack = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>(); //辅助栈，用来判断子结点返回父结点是处于左结点还是右结点
        int left = 1; // 辅助栈里表示左结点
        int right = 2; // 辅助栈里表示右节点
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current); // 将结点压入栈1
                stack2.push(left); // 在辅助栈标记为左结点
                current = current.leftChild;
            }

            //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
            while (!stack.isEmpty() && stack2.peek()==right){
                stack2.pop();
                System.out.print(stack.pop().data+"\t");
            }

            //如果是从左子节点返回父节点，则将标记改为右子节点
            if (!stack.isEmpty() && stack2.peek()==left) {
                stack2.pop();
                stack2.push(right);
                current = stack.peek().rightChild;
            }

        }
    }

    @Override
    public void levelOrderByQueue() {
        this.levelOrderByQueue(root);
    }

    /**
     * 二叉树的层次遍历操作：利用队列实现
     *
     * @param root
     */
    private void levelOrderByQueue(Node root) {
        if (root == null) {
            return;
        }
        // 创建一个队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size(); // 队列存的是将要遍历的那层的结点
            for (int i = 0; i < len; i++) { // 有几个结点就遍历几次
                Node temp = queue.poll(); // 每次遍历都进行出队操作
                System.out.print(temp.data + "\t");
                if (temp.leftChild != null) {
                    queue.add(temp.leftChild); // 如果当前结点左孩子结点不为空，则左孩子结点进队
                }
                if (temp.rightChild != null) {
                    queue.add(temp.rightChild); // 如果当前结点右孩子结点不为空，则右孩子结点进队
                }
            }
        }
    }
}
