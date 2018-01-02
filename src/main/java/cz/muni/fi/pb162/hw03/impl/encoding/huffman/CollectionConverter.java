package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import cz.muni.fi.pb162.hw03.impl.encoding.node.LeafTreeNode;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * This class contains methods to convert collections.
 * 
 * @author Martina Balakova, 456595
 */
public class CollectionConverter {
    
    /**
     * Makes a forest tree from the table.
     * @param charSet Set of SymbolFrequency to be converted
     * @return Navigable set (sorted set) of tree nodes
     */
    public static NavigableSet<TreeNode> charSetToLeafNodeSet(Set<SymbolFrequency> charSet) {
        return charSet.stream()
                .map(f -> new LeafTreeNode(f))
                .collect(Collectors.toCollection(TreeSet::new));
    }
    
    /**
     * Conversion of TreeNode to Character.
     * @param nodeStringMap map with TreeNode key to be converted
     * @return map with Character key and String value
     */
    public static Map<Character, String> nodeMapToEncodingMap(Map<TreeNode, String> nodeStringMap) {
        // https://stackoverflow.com/questions/27228961/java-8-stream-map-on-entry-set
        return nodeStringMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getCharacter(), e -> e.getValue()));
    }
}
