package com.wjx.btree;

/**
 * @Auther:wjx
 * @Date:2019/5/28
 * @Description:com.wjx.btree
 * @version:1.0
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        // 构建一棵二叉树
        Node node5 = new Node(5);
        Node node4 = new Node(4, null, node5);

        Node node7 = new Node(7);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3);
        Node node2 = new Node(2, node3, node6);

        Node root = new Node(1, node4, node2);

        BinaryTree btree = new LinkedBinaryTree(root);

        // 操作这棵二叉树
        //System.out.println(btree.isEmpty());
        //System.out.println(btree.size());
        //System.out.println(btree.getHeight());
        //btree.preOrderTraverse();
        //btree.inOrderTraverse();
        //btree.postOrderTraverse();
        //btree.levelOrderByQueue();
        //btree.inOrderByStack();
        //btree.preOrderByStack();
        btree.postOrderByStack();

    }
}
