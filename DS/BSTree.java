import java.util.Scanner;

class BSTree {
    BSTNode rootNode;

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int option;
        Scanner mScanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter Choice : \n1.Insert\n2.Delete\n3.Print (Inorder)\n4.print (Pre order)\n5.Print (Post order)");
            option = mScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Data");
                    for (int i = 0; i < 15; i++) {
                        int data = mScanner.nextInt();
                        bsTree.insert(data);
                        System.out.println("Remaining" + String.valueOf((i - 13)));
                    }

                    break;
                case 2:
                    // System.out.println("Enter Data");
                    // int data = mScanner.nextInt();
                    // insert(data);
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
                default:
                    break;
            }
            // mScanner.close();
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
            traverseInorder(r.lNode);
            traverseInorder(r.rNode);
        }
    }

    void traversePostorder(BSTNode r) {
        if (r != null) {
            traverseInorder(r.lNode);
            traverseInorder(r.rNode);
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