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
        private BinarySearchTreeNode insertNode(BinarySearchTreeNode node, int key)
        {
            // Create a new node when it is pointing to nothing.
            if(node == null)
            {
                BinarySearchTreeNode newNode = new BinarySearchTreeNode();
                newNode.key = key;
                return newNode;
            }
            // Insert a node to the right if the key > root's key.
            else if(key > node.key)
            {
                node.right = insertNode(node.right, key);
            }
            // insert a node to the left if the key < root's key.
            else if (key < node.key)
            {
                node.left = insertNode(node.left, key);
            }
            
            return node;
            
        }
        
        public void delete(int key)
        {
            
        }
        
        /**
         * Searches to see if a key exists in the BST.
         * @param key The value to check if it exists in the BST.
         * @return True if the key is in the BST, or false if not.
         */
        public boolean find(int key)
        {
            return findNode(root, key);
        }
        
        // Private method used to find the node.
        private boolean findNode(BinarySearchTreeNode node, int key)
        {
            // If the root is null, it is imposible to have found it here.
            if(node == null)
            {
                return false; 
            }
            // The key is found on the current node, then it was found.
            else if (key == node.key)
            {
                return true;
            }
            // Check the right node if the key > the node's key.
            else if(key > node.key)
            {
                return findNode(node.right, key);
            }
            // Otherwise, key < node's key, so check the left node.
            else 
            {
                return findNode(node.left, key);
            }
        }
        
        /**
         * Calculates the sum of all the nodes in the tree.
         * @return The sum of all nodes in the tree.
         */
        public int keySum()
        {
            return keySumNode(root);
        }
        
        // Private method that assists to calculate the sum of all the nodes.
        private int keySumNode(BinarySearchTreeNode node)
        {
            int sum;
            
            // If the node is null, there is no key to add to the sum.
            if(node == null)
            {
                sum = 0;
            }
            // If the key is not null, add the key to sum, and add the sum
            // of the left and right branch.
            else
            {
                sum = node.key;
                sum += keySumNode(node.left);
                sum += keySumNode(node.right);
            }
            
            return sum;
        }
        
        /**
         * Prints the tree in post order traversal.
         */
        public void printPostOrder()
        {
            System.out.print("The tree has the following elements: [ ");
            printPostOrderNodes(root);
            System.out.println("]");
        }
        
        // Helper method used to print the nodes in post order.
        private void printPostOrderNodes(BinarySearchTreeNode node)
        {
            if(node == null)
            {
                //Do nothing
            }
            // If both childs one of childs is not null, then it is not a leaf so print value and
            // traverse to the left child, then eventually to the right child.
            else if(node.left != null || node.right != null)
            {
                printPostOrderNodes(node.left);
                printPostOrderNodes(node.right);
                System.out.print(node.key + " ");
            }
            // If the left & right childs are null, you are at a leaf, so simply
            // print it.
            else 
            {
                System.out.print(node.key + " ");
            }
        }
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProblemThree driver = new ProblemThree();
        
        // Used to create an instance of the BST inner class.
        ProblemThree.BinarySearchTree testBST = driver.new BinarySearchTree();
        
        testBST.insert(4);
        testBST.insert(2);
        testBST.insert(1);
        testBST.insert(3);
        testBST.insert(5);
        
        System.out.println("Find 11: " + testBST.find(11));
        System.out.println("Find 20: " + testBST.find(20));
        System.out.println("The sum of the whole tree is: " + testBST.keySum());
        
        testBST.printPostOrder();
        

    }
    
}
