public class NodeAlreadyExists extends Exception {
    public static final String MESSAGE = "A node already exists that contains the key value: ";

    public boolean NodeAlreadyExistsException(Node n ,int key) {
        if(n == null)
            return false;
        if(n.getKey() == key)
            return true;
        return false;
    }

    public NodeAlreadyExists(String message) {
        super(MESSAGE);
    }
}
