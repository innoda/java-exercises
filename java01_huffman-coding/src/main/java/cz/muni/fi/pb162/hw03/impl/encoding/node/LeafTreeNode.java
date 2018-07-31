package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * This class represents a leaf node.
 * Extends AbstractTreeNode class.
 * 
 * @author Magdalena Kunikova
 */
public class LeafTreeNode extends AbstractTreeNode {
    
    /**
     * Parametrized constructor.
     * Left and right children are always null for a leaf.
     * 
     * @param symbolFrequency symbol
     */
    public LeafTreeNode(SymbolFrequency symbolFrequency) {
        super(symbolFrequency, null, null);
    }
    
    @Override
    public int compareTo(TreeNode o) {
        int diff = Double.compare(getFrequency(), o.getFrequency());
        if (diff != 0) {
            return diff;
        }
        if (!o.isLeaf()) {
            return 1;
        }
        return Double.compare(getCharacter(), o.getCharacter());
    }

    @Override
    public String toString() {
        return "Leaf " + getSymbolFrequency();
    }
}
