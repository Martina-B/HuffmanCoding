package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Objects;

/**
 * This class represents inner node in tree. Must have two descendants.
 * 
 * @author Martina Balakova, 456595
 */
public class InnerTreeNode extends AbstractTreeNode {

    /**
     * Constructor calls constructor of super class. Character is empty character,
     * frequency is sum of frequencies of descendants.
     * @param leftDescendant left child of tree
     * @param rightDescendant right child of tree
     */
    public InnerTreeNode(TreeNode leftDescendant, TreeNode rightDescendant) {
        super(new SymbolFrequency(EMPTY_CHAR, leftDescendant.getFrequency() 
                + rightDescendant.getFrequency()), leftDescendant, rightDescendant);
    }

    @Override
    public String toString() {
        return "" + getLeftChild().getCharacter() + "-(" + this.getFrequency()
                + ")-" + getRightChild().getCharacter();
    }

    @Override
    public int compareTo(TreeNode o) {
        int output = Integer.compare(getFrequency(), o.getFrequency());
        if (output != 0) return output;
        if (o instanceof LeafTreeNode) return -1;
        output = getLeftChild().compareTo(o.getLeftChild());
        if (output != 0) return output;
        return getRightChild().compareTo(o.getRightChild());
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InnerTreeNode)) return false;        
        InnerTreeNode other = (InnerTreeNode) o;
        return this.getLeftChild().equals(other.getLeftChild()) 
                && this.getRightChild().equals(other.getRightChild());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.getSymbolFrequency()) 
                + Objects.hashCode(this.getLeftChild()) + Objects.hashCode(this.getRightChild());
    }
}
