package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Objects;

/**
 * Thiss class is an abstraction of a treenode.
 * Implements TreeNode interface.
 * 
 * @author Magdalena Kunikova
 */
public abstract class AbstractTreeNode implements TreeNode {
    
    private final SymbolFrequency symbolFrequency;
    private final TreeNode leftChild;
    private final TreeNode rightChild;
    
    /**
     * Parametrized constructor
     * 
     * @param symbolFrequency node symbol
     * @param leftChild left child of a node
     * @param rightChild right child of a node
     */
    public AbstractTreeNode(SymbolFrequency symbolFrequency, TreeNode leftChild, TreeNode rightChild) {
        this.symbolFrequency = symbolFrequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    @Override
    public int getFrequency() {
        return symbolFrequency.getFrequency();
    }

    @Override
    public Character getCharacter() {
        return symbolFrequency.getCharacter();
    }

    @Override
    public TreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public TreeNode getRightChild() {
        return rightChild;
    }

    @Override
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += Objects.hashCode(this.symbolFrequency);
        hash += Objects.hashCode(this.leftChild);
        hash += Objects.hashCode(this.rightChild);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractTreeNode other = (AbstractTreeNode) obj;
        if (!Objects.equals(this.symbolFrequency, other.symbolFrequency)) {
            return false;
        }
        if (!Objects.equals(this.leftChild, other.leftChild)) {
            return false;
        }
        return Objects.equals(this.rightChild, other.rightChild);
    }

    public SymbolFrequency getSymbolFrequency() {
        return symbolFrequency;
    }  
}
