package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * This abstract class contains functionality for nodes in tree.
 * 
 * @author Martina Balakova
 */
public abstract class AbstractTreeNode implements TreeNode {
    private final SymbolFrequency symbolFrequency;
    private TreeNode leftDescendant;
    private TreeNode rightDescendant;
    
    /**
     * @param symbolFrequency characters and theirs frequency
     * @param leftDescendant left child of node in tree
     * @param rightDescendant right child of node in tree
     */
    public AbstractTreeNode(SymbolFrequency symbolFrequency, TreeNode leftDescendant, TreeNode rightDescendant) {
        this.symbolFrequency = symbolFrequency;
        this.leftDescendant = leftDescendant;
        this.rightDescendant = rightDescendant;
    }
    
    /**
     * @param symbolFrequency characters and theirs frequency
     */
    public AbstractTreeNode(SymbolFrequency symbolFrequency) {
        this.symbolFrequency = symbolFrequency;
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
        return leftDescendant;
    }

    @Override
    public TreeNode getRightChild() {
        return rightDescendant;
    }

    @Override
    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }
    
    /**
     * Getter of SymbolFrequency.
     * @return characters and theirs frequency
     */
    protected SymbolFrequency getSymbolFrequency() {
        return symbolFrequency;
    }
    
}
