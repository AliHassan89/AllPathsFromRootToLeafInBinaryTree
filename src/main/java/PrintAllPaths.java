/*
Given a binary tree, return all paths from the root to leaves.

For example, given the tree

   1
  / \
 2   3
    / \
   4   5
it should return [[1, 2], [1, 3, 4], [1, 3, 5]].
 */

package main.java;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

    static List<Node> nodeList;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        nodeList = new ArrayList<>();
        printPathsUtil(root);
    }

    public static void printPathsUtil(Node root) {
        if(root == null)
            return;

        nodeList.add(root);
        if(root.left == null && root.right == null) {
            for(int i=0; i<nodeList.size(); i++)
                System.out.print(nodeList.get(i).data+", ");
            System.out.println();
            nodeList.remove(nodeList.get(nodeList.size()-1));
        }
        else{
            printPathsUtil(root.left); // go to left
            printPathsUtil(root.right); // then right
        }
    }
}
