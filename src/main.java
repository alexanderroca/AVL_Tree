public class main {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.setRoot(tree.insert(tree.getRoot(), 20));
        tree.setRoot(tree.insert(tree.getRoot(), 30));
        tree.setRoot(tree.insert(tree.getRoot(), 40));
        tree.setRoot(tree.insert(tree.getRoot(), 50));
        tree.setRoot(tree.insert(tree.getRoot(), 25));

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.print("PreOrder: ");
        tree.preOrder(tree.getRoot());
        System.out.println("InOrder: ");
        tree.inOrder(tree.getRoot());
        System.out.println("PostOrder: ");
        tree.postOrder(tree.getRoot());
    }
}