/*
Name - Patil Tejas Vijay
GR No - xxxxxxxx
ROLL No - xxxxxx
Div - SY-C

https://github.com/Tejasvp25/college-stuff/blob/master/DS/BSTree.java
*/

import java.util.Scanner;

class BSTree {
    BSTNode rootNode;

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int option;
        Scanner mScanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter Choice : \n1.Insert\n2.Delete\n3.Print (Inorder)\n4.print (Pre order)\n5.Print (Post order)\n6.Exit");
            option = mScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Number of Elements You want to Insert");
                    int count = mScanner.nextInt();
                    System.out.println("Enter the Elements");
                    for (int i = 0; i < count; i++) {
                        int data = mScanner.nextInt();
                        bsTree.insert(data);
                    }
                    break;
                case 2:
                    System.out.println("Enter Data");
                    int data = mScanner.nextInt();
                    bsTree.delete(bsTree.rootNode, data);
                    break;
                case 3:
                    bsTree.traverseInorder(bsTree.rootNode);
                    break;
                case 4:
                    bsTree.traversePreorder(bsTree.rootNode);
                    break;
                case 5:
                    bsTree.traversePostorder(bsTree.rootNode);
                    break;
                case 6:
                    mScanner.close();
                    return;

                default:
                    break;
            }
        }

    }

    void insert(int data) {
        BSTNode tNode;

        if (rootNode == null) {
            rootNode = tNode = new BSTNode(data);
            return;
        } else {
            tNode = rootNode;
        }

        while (true) {
            if (tNode.data < data) {
                if (tNode.rNode == null) {
                    tNode.rNode = new BSTNode(data);
                    System.out.println("right");
                    break;
                } else {
                    tNode = tNode.rNode;
                }
            } else {
                if (tNode.lNode == null) {
                    tNode.lNode = new BSTNode(data);
                    System.out.println("left");
                    break;
                } else {
                    tNode = tNode.lNode;
                }
            }
        }

    }

    BSTNode delete(BSTNode node, int data) {
        if (node == null) {
            return null;
        } else {

            if (data < node.data)
                node.lNode = delete(node.lNode, data);
            else if (data > node.data)
                node.rNode = delete(node.rNode, data);
            else {
                if (node.lNode == null && node.rNode == null)
                    node = null;
                else if (node.lNode == null) {
                    node = node.rNode;
                } else if (node.rNode == null) {
                    node = node.lNode;
                } else {
                    BSTNode temp = minimumNode(node.rNode);
                    node.data = temp.data;
                    node.rNode = delete(node.rNode, temp.data);
                }
            }
            return node;
        }

    }

    BSTNode minimumNode(BSTNode node) {
        if (node.lNode != null)
            return minimumNode(node.lNode);
        return node;
    }

    void traverseInorder(BSTNode r) {
        if (r != null) {
            traverseInorder(r.lNode);
            System.out.println(r.data);
            traverseInorder(r.rNode);
        }
    }

    void traversePreorder(BSTNode r) {
        if (r != null) {
            System.out.println(r.data);
            traversePreorder(r.lNode);
            traversePreorder(r.rNode);
        }
    }

    void traversePostorder(BSTNode r) {
        if (r != null) {
            traversePostorder(r.lNode);
            traversePostorder(r.rNode);
            System.out.println(r.data);

        }
    }

    class BSTNode {
        int data;
        BSTNode lNode, rNode;

        BSTNode(int data) {
            this.data = data;
        }
    }
}