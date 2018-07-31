package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * This class represents an inner tree node.
 * Extends AbstractTreeNode class.
 * 
 * @author Magdalena Kunikova
 */
public class InnerTreeNode extends AbstractTreeNode {
    
    /**
     * Parametrized constructor.
     * Character is EMPTY_CHAR.
     * 
     * @param leftChild left child of a node
     * @param rightChild right child of a node
     */
    public InnerTreeNode(TreeNode leftChild, TreeNode rightChild) {
        super(new SymbolFrequency(TreeNode.EMPTY_CHAR, rightChild.getFrequency() + 
                leftChild.getFrequency()), leftChild, rightChild);
    }
    
    @Override
    public String toString() {
        return getLeftChild().getCharacter() + "-(" + getFrequency() + ")-" + getRightChild().getCharacter();
    }
  
    @Override
    public int compareTo(TreeNode o) {
        int diff = Double.compare(getFrequency(), o.getFrequency());
        if (diff != 0) {
            return diff;
        }
        
        if (o.isLeaf()) {
            return -1;
        }
        
        diff = - Double.compare(getLeftChild().getCharacter(), o.getLeftChild().getCharacter());
        return ((diff != 0) ? diff : Double.compare(getRightChild().getCharacter(), o.getRightChild().getCharacter())); 
    }
}
