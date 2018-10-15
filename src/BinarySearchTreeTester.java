public class BinarySearchTreeTester
{
    public static void main(String[] args)
    {
        BinarySearchTreeDemo tree = new BinarySearchTreeDemo();

        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(30);
        tree.addNode(75 );
        tree.addNode(85);

        System.out.println("preorder traversal:");
        tree.preOrderTraverse(tree.getRoot());
        System.out.println();

        System.out.println("inorder traversal:");
        tree.inOrderTraverse(tree.getRoot());
        System.out.println();

        System.out.println("postorder traversal:");
        tree.postOrderTraverse(tree.getRoot());
        System.out.println();

        System.out.println(tree.findNode(75));
        System.out.println(tree.findNode(80));
        System.out.println();

        System.out.println(tree.removeNode(25));
        System.out.println("New inorder traversal:");
        tree.inOrderTraverse(tree.getRoot());
    }
}
