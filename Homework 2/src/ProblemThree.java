/*********************************************************************
 Purpose/Description: <a brief description of the program>
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

/**
 *
 */
public class ProblemThree {

    /**
     * Represents a node in a BST.
     */
    public class BinarySearchTreeNode
    {
        
        public int key; // "Key" is the value stored in the node.
        public BinarySearchTreeNode left; // Left child node.
        public BinarySearchTreeNode right; // Right child node.
    }
    
    /**
     * A class that implements the Binary Search Tree data structure.
     */
    public class BinarySearchTree
    {
        private BinarySearchTreeNode root;
        
        /**
         * Creates an empty BST.
         */
        public BinarySearchTree()
        {
            root = null;
        }
        
        /**
         * Inserts a node into the BST.
         * @param key The value to insert into the BST.
         */
        public void insert(int key)
        {
            root = insertNode(root, key);
        }
        
        // Helper method used to insert the node.
        private BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int key)
        {
            
            // Create a new node when it is pointing to nothing.
            if(root == null)
            {
                BinarySearchTreeNode newNode = new BinarySearchTreeNode();
                newNode.key = key;
                return newNode;
            }
            // Insert a node to the right if the key > root's key.
            else if(key > root.key)
            {
                root.right = insertNode(root.right, key);
            }
            // insert a node to the left if the key < root's key.
            else if (key < root.key)
            {
                root.left = insertNode(root.left, key);
            }
            
            return root;
            
        }
        
        public void delete(int key)
        {
            
        }
        
        public boolean find(int key)
        {
            return true;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProblemThree driver = new ProblemThree();
        
        // Used to create an instance of the BST inner class.
        ProblemThree.BinarySearchTree testBST = driver.new BinarySearchTree();
        
        testBST.insert(20);
        testBST.insert(5);
        testBST.insert(3);
        testBST.insert(7);
        testBST.insert(21);
        testBST.insert(20);
        
        System.out.println("Test");
        

    }
    
}
