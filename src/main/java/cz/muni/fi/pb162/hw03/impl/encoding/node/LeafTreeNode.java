package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * This class represents leaf of tree. It doesn't have descendants and it stores character.
 * 
 * @author Martina Balakova, 456595
 */
public class LeafTreeNode extends AbstractTreeNode {

    /**
     * @param symbolFrequency characters and theirs frequency
     */
    public LeafTreeNode(SymbolFrequency symbolFrequency) {
        super(symbolFrequency);
    }

    @Override
    public int compareTo(TreeNode o) {
        int output = Integer.compare(getFrequency(), o.getFrequency());
        if (output != 0) return output;
        if (!(o instanceof LeafTreeNode)) return 1;
        return this.getCharacter().compareTo(o.getCharacter());
    }
    
    @Override
    public String toString() {
        return "Leaf " + getSymbolFrequency().toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof LeafTreeNode)) return false;
        final LeafTreeNode other = (LeafTreeNode) obj;
        return this.getCharacter().equals(other.getCharacter()) 
                && Integer.valueOf(this.getFrequency()).equals(other.getFrequency());       
    }
    
    @Override
    public int hashCode() {
        return Character.hashCode(this.getCharacter()) + Integer.hashCode(this.getFrequency());
    }
    
}
