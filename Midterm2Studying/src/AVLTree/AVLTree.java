package AVLTree;

/**
 * Represents an AVL Tree with the operations of: Insert, Find, Print, and 
 * lazy deletion.
 * @author carlos
 */
public class AVLTree {
    private AVLNode root;
    
    /**
     * Creates an empty AVLTree.
     */
    public AVLTree()
    {
        root = null;
    }
    
    /**
     * Inserts a node into the AVL tree. Uses the balancing condition, so the
     * tree may be rebuilt to maintain the balance.
     * @param data Data to be inserted in the new node.
     */
    public void insert(int data)
    {
        // If the tree is empty, simply create a new node, otherwise insert
        // it using insertAVL to rebuild if needed.
            root = insertAVL(root, data);
    }
    
    // Recursive helper method that inserts a node first as if it is simply a
    // BST, then it will rebuild the tree if a node is not balanced.
    private AVLNode insertAVL(AVLNode root, int data)
    {
        int balance; // Keeps track of the balance of the node.
        /* If node is null, then generate a new leaf, otherwise insert on
        * either left or right child, using the BST order rules.
        */
        if(root == null)
        {
            return new AVLNode(data);
        }
        else if(data < root.data)
        {
            root.left = insertAVL(root.left, data);
        }
        else if(data > root.data)
        {
            root.right = insertAVL(root.right, data);
        }
        
        balance = getHeight(root.left) - getHeight(root.right);
        
        // Check if there is a left or right imbalance. 
        if(balance > 1)
        {
            /* Check if the imbalance is left-left or left-right.
             * If left-left, perform a single rotation, otherwise perform
             * a double rotation.
             */
            if(getHeight(root.left.left) > getHeight(root.left.right))
            {
                return rotateRight(root);
            }
            else if(getHeight(root.left.left) < getHeight(root.left.right))
            {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        else if (balance < -1)
        {
            /* Check if the imbalance is right-right or right-left.
             * If right-right, perform a single rotation, otherwise perform
             * a double rotation.
             */
            if(getHeight(root.right.right) > getHeight(root.right.left))
            {
                return rotateLeft(root);
            }
            else if(getHeight(root.right.right) < getHeight(root.right.left))
            {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }
        
        // Update height for any insertions that may have taken place.
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        return root;
    }
    
    // Perform a right rotation across a node as a result of a left-imbalance, 
    // and return the resulting new parent node.
    private AVLNode rotateRight(AVLNode root)
    {
        // Perform right rotation.
        AVLNode problemChild = root.left;
        root.left = problemChild.right; // "PC.right" is the non-problem GC.
        problemChild.right = root;
        
        // Update heights of the problem child and root.
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        problemChild.height = Math.max(getHeight(problemChild.left),
                getHeight(problemChild.right)) + 1;
        
        return problemChild; // problemChild is the new root.
    }
    
    // Perform a left rotation across a node as a result of a right-imbalance, 
    // and return the resulting new parent node.
    private AVLNode rotateLeft(AVLNode root)
    {
        // Perform a left rotation.
        AVLNode problemChild = root.right;
        root.right = problemChild.left;
        problemChild.left = root;

        // Update heights of the problem child and root.
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        problemChild.height = Math.max(getHeight(problemChild.left),
                getHeight(problemChild.right)) + 1;
        
        return problemChild;
    }
    
    // Return the height of the node.
    private int getHeight(AVLNode root)
    {
        // Return "-1" as the height if the node is null.
        if(root == null)
        {
            return -1;
        }
        else
        {
            return root.height;
        }
    }
    
    /**
     * Get the height of the entire tree.
     * @return The height of the root node.
     */
    public int getTreeHeight()
    {
        return root.height;
    }
    
    /**
     * Return the tree as string of nodes of increasing value.
     * @return The tree as string of nodes of increasing value.
     */
    @Override
    public String toString()
    {
        String treeString = "[";
        treeString = treeString + stringAsIncValue(root);
        treeString = treeString + "]";
        return treeString;
    }
    
    // Helper method to return the tree in increasing order.
    // NOTE: Known bug, extra commas can happen due to a left-based child
    // only having a left child, but no right child.
    private String stringAsIncValue(AVLNode root)
    {
        String treeString = "";
        
        if(root == null)
        {
            return "";
        }
        else if(root.left != null || root.right != null)
        {
            treeString = treeString + stringAsIncValue(root.left) + ", ";
            treeString = treeString + Integer.toString(root.data) + ", ";
            treeString = treeString + stringAsIncValue(root.right);
        }
        else
        {
            treeString = Integer.toString(root.data);
        }
        
        return treeString;
    }
    
    /**
     * Prints the tree such that it iterates over the nodes to print them in
     * increasing order.
     */
    public void printTree()
    {
        System.out.print("The tree has the following elements: [ ");
        printTreeNodes(root);
        System.out.println("]");
    }

    // Helper method that prints a tree's nodes by increasing value.
    private void printTreeNodes(AVLNode node)
    {
        if(node == null)
        {
            //Do nothing
        }
        // If both childs one of childs is not null, then it is not a leaf so 
        // traverse to the left, then print the value and then traverse right.
        else if(node.left != null || node.right != null)
        {
            printTreeNodes(node.left);
            System.out.print(node.data + " ");
            printTreeNodes(node.right);
        }
        // If the left & right childs are null, you are at a leaf, so simply
        // print it.
        else 
        {
            System.out.print(node.data + " ");
        }
    }
}
