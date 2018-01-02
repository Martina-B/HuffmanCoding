package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.HuffmanAlgorithm;
import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import cz.muni.fi.pb162.hw03.impl.encoding.node.InnerTreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;

/**
 * This class represents Huffman Coding. Every character has its own unique binary 
 * representation.
 * 
 * @author Martina Balakova, 456595
 */
public class HuffmanEncoding implements Encoding, HuffmanAlgorithm {

    private final TreeNode root;
    private final Map<Character, String> encodingMap;

    /**
     * Constructor contains functionality of class. It stores root and encoding map.
     * @param frequencyTable 
     */
    public HuffmanEncoding(FrequencyTable frequencyTable) {
        Map<TreeNode, String> mapWithPath = new HashMap<>();
        root = frequencyTableToTree(frequencyTable.createTable());
        createCodeTree(mapWithPath, root, "");
        encodingMap = CollectionConverter.nodeMapToEncodingMap(mapWithPath);
    }

    @Override
    public String getEncodingString(char encodingChar) {
        if (!encodingMap.containsKey(encodingChar)) {
            throw new IllegalArgumentException("given char is not in encoding map");
        }
        return encodingMap.get(encodingChar);
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public TreeNode frequencyTableToTree(Set<SymbolFrequency> characterFrequencies) {
        NavigableSet<TreeNode> forest = CollectionConverter
                .charSetToLeafNodeSet(characterFrequencies);
        while (forest.size() != 1) {
            TreeNode leftChild = forest.pollFirst();
            TreeNode rightChild = forest.pollFirst();
            forest.add(new InnerTreeNode(leftChild, rightChild));
        }
        return forest.last();
    }

    @Override
    public void createCodeTree(Map<TreeNode, String> map, TreeNode node, String encodingString) {
        if (node.isLeaf()) {
            map.put(node, encodingString);
            return;
        }
        createCodeTree(map, node.getLeftChild(), encodingString + 0);
        createCodeTree(map, node.getRightChild(), encodingString + 1);
    }
}
