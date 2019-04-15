public class main {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert_T(10, null);
        tree.insert_T(20, null);
        tree.insert_T(30, null);
        tree.insert_T(40, null);
        tree.insert_T(50, null);
        tree.insert_T(25, null);
        tree.insert_T(20, null);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.print("PreOrder: ");
        tree.preOrder(tree.getRoot());
        System.out.println();
        System.out.print("InOrder: ");
        tree.inOrder(tree.getRoot());
        System.out.println();
        System.out.print("PostOrder: ");
        tree.postOrder(tree.getRoot());
        System.out.println();

        tree.remove_T(10);
        System.out.print("InOrder: ");
        tree.inOrder(tree.getRoot());
        System.out.println("HI");
    }
}
