public class main {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert_T(10);
        tree.insert_T(20);
        tree.insert_T(30);
        tree.insert_T(40);
        tree.insert_T(50);
        tree.insert_T(25);
       /* tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.insert(tree.getRoot(), 20);
        tree.insert(tree.getRoot(), 30);
        tree.insert(tree.getRoot(), 40);
        tree.insert(tree.getRoot(), 50);
        tree.insert(tree.getRoot(), 25);*/

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
    }
}
