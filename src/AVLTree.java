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
        return (height(n.getLeft()) - height(n.getRight()));
    }

    // PreOrder
    public void preOrder(Node n){
        if(n == null)
            return;
        System.out.print(n.getKey() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // InOrder
    public void inOrder(Node n){
        if(n == null)
            return;
        inOrder(n.getLeft());
        System.out.print(n.getKey() + " ");
        inOrder(n.getRight());
    }

    //PostOrder
    public void postOrder(Node n){
        if(n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getKey() + " ");
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

    public boolean insert_T(int key, Object object){

        try {
            root = insert(root, key, object);
            return true;
        } catch (NodeAlreadyExists nodeAlreadyExists) {
            System.out.println(nodeAlreadyExists.getMessage() + key);
            return false;
        }
    }

    // Insertion of a new Node to the AVL Tree
    public Node insert(Node n, int key, Object object) throws NodeAlreadyExists{

        if (n == null)
            return (new Node(key, object)); //TODO: Determine what type of object to keep

        else {
            if (n.getKey() == key)
                throw new NodeAlreadyExists();

            // Insertion
            if (key < n.getKey()) {
                n.setLeft(insert(n.getLeft(), key, object));
            }   //if
            else if (key > n.getKey()) {
                n.setRight(insert(n.getRight(), key, object));
            }   //else-if
            else {
                return n;
            }   //else

            // Update heights
            n.setHeight(1 + max(height(n.getLeft()), height(n.getRight())));

            // Check if is balanced with the Balance Factor
            int balance = getBalance(n);
            // 4 possibles types of unbalanced
            //RR
            if (balance > 1 && key < n.getLeft().getKey())
                return rightRotate(n);
            //LL
            if (balance < -1 && key > n.getRight().getKey())
                return leftRotate(n);
            //LR
            if (balance > 1 && key > n.getLeft().getKey()) {
                n.setLeft(leftRotate(n.getLeft()));
                return rightRotate(n);
            }   //if
            //RL
            if (balance < -1 && key < n.getRight().getKey()) {
                n.setRight(rightRotate(n.getRight()));
                return leftRotate(n);
            }   //if
        }   //else
        return n;
    }

    public boolean remove_T(int key){
        try{
            root = remove(root, key);
            return true;
        } catch (NodeDoesntExists nodeDoesntExists){
            System.out.println(nodeDoesntExists.getMessage() + key);
            return false;
        }
    }

    public Node remove(Node n, int key) throws NodeDoesntExists{

        if(n == null)
            return n;

        if(key < n.getKey())
            n.setLeft(remove(n.getLeft(), key));
        else if(key > n.getKey())
            n.setRight(remove(n.getRight(), key));
        else{

            if(n.getLeft() == null || n.getRight() == null){

                Node aux = null;
                if(aux == n.getLeft())
                    aux = n.getRight();
                else
                    aux = n.getLeft();

                if(aux == null){
                    aux = n;
                    n = null;
                }   //if
                else
                    n = aux;
            }   //if
            else{
                Node aux = minValueNode(n.getRight());
                n.setKey(aux.getKey());
                n.setRight(remove(n.getRight(), aux.getKey()));
            }   //else
        }   //else

        if(n == null)
            return n;

        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);

        int balance = getBalance(n);
        if(balance > 1 && getBalance(n.getLeft()) >= 0)
            return rightRotate(n);
        if(balance > 1 && getBalance(n.getLeft()) < 0){
            n.setLeft(leftRotate(n.getLeft()));
            return rightRotate(n);
        }   //if

        if(balance < -1 && getBalance(n.getRight()) <= 0)
            return leftRotate(n);
        if(balance < -1 && getBalance(n.getRight()) > 0) {
            n.setRight(rightRotate(n.getRight()));
            return leftRotate(n);
        }   //if

        return n;
    }

    //Search the minimum key value in the tree
    public Node minValueNode(Node n){
        Node aux = n;

        //Loop to find the most left leaf
        while(aux.getLeft() != null)
            aux = aux.getLeft();

        return aux;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
