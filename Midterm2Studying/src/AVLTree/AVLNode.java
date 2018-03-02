package AVLTree;

/**
 * Represents a node for an AVL tree. Nodes have integer data.
 * @author carlos
 */
public class AVLNode {
    int data; // Data contained in then node.
    int height; // Height of the node.
    AVLNode left; // Left child of the node.
    AVLNode right; // Right child of the node.
    
    /**
     * Constructs a node for an AVL Tree.
     * @param data The data contained in the node.
     */
    AVLNode(int data)
    {
        this.data = data;
        this.height = 0; // If a now node is inserted, it is a leaf.
        
        // New node is a leaf, so it has no children.
        left = null;
        right = null;
    }
    
}
