# com\java\eight8\datastructure\trees\LevelOrderTraversalQueue.java

```java
package com.java.eight8.datastructure.trees;
import java.util.Queue;
import java.util.LinkedList;
 
/* Class to represent Tree node */
class Node4 {
    int data;
    Node4 left, right;
 
    public Node4(int item) {
        data = item;
        left = null;
        right = null;
    }
}
 
/* Class to print Level Order Traversal */
public class LevelOrderTraversalQueue {
 
    Node4 root;
 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder() 
    {
        Queue<Node4> queue = new LinkedList<Node4>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
 
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node4 tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
 
    public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
    	LevelOrderTraversalQueue tree_level = new LevelOrderTraversalQueue();
        tree_level.root = new Node4(1);
        tree_level.root.left = new Node4(2);
        tree_level.root.right = new Node4(3);
        tree_level.root.left.left = new Node4(4);
        tree_level.root.left.right = new Node4(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
```
