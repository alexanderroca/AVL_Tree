public class AVLTree {
    private Node root;

    // Function to get the height of the tree
    public int height(Node n){
        if(n == null)
            return 0;
        return n.getHeight();
    }

    // Get the maximum of two integers
    public int max(int a, int b){
        return (a > b) ? a : b;
    }

    // Get the Balance Factor of Node n
    public int getBalance(Node n){
        if(n == null)
            return 0;
        return Math.abs(height(n.getLeft()) - height(n.getRight()));
    }

    // PreOrder
    public void preOrder(Node n){
        if(n == null)
            return;
        System.out.println(n.getKey() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // InOrder
    public void inOrder(Node n){
        if(n == null)
            return;
        inOrder(n.getLeft());
        System.out.println(n.getKey() + " ");
        inOrder(n.getRight());
    }

    //PostOrder
    public void postOrder(Node n){
        if(n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.println(n.getKey() + " ");
    }

    // LL ROTATION
    public Node rightRotate(Node n){
        Node left = n.getLeft();
        Node left_right = left.getRight();

        left.setRight(n);
        n.setLeft(left_right);

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        left.setHeight(max(height(left.getLeft()), height(left.getRight())) + 1);

        return left;
    }

    // RR ROTATION
    public Node leftRotate(Node n){
        Node right = n.getRight();
        Node right_left = right.getLeft();

        right.setLeft(n);
        n.setRight(right_left);

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        right.setHeight(max(height(right.getLeft()), height(right.getRight())) + 1);

        return right;
    }

    // Insertion of a new Node to the AVL Tree
    public Node insert(Node n, int key){
        if(n == null)
            return new Node(key, null); //TODO: Determine what type of object to keep

        // Insertion
        if(key < n.getKey()) {
            n.setLeft(insert(n.getLeft(), key));
        }   //if
        else if(key > n.getKey()){
            n.setRight(insert(n.getRight(), key));
        }   //else-if
        else{
            return n;
        }   //else

        // Update heights
        n.setHeight(1 + max(height(n.getLeft()), height(n.getRight())));

        // Check if is balanced with the Balance Factor
        int balance = getBalance(n);
        // 4 possibles types of unbalanced
        //RR
        if(balance > 1 && key < n.getLeft().getKey())
            return rightRotate(n);
        //LL
        if(balance > 1 && key > n.getRight().getKey())
            return leftRotate(n);
        //LR
        if(balance > 1 && key > n.getLeft().getKey()){
            n.setLeft(leftRotate(n.getLeft()));
            return rightRotate(n);
        }   //if
        //RL
        if(balance > 1 && key < n.getRight().getKey()){
            n.setRight(rightRotate(n.getRight()));
            return leftRotate(n);
        }   //if

        return n;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
