package cz.muni.fi.pb162.hw03.impl;

import cz.muni.fi.pb162.hw03.BinaryCodec;
import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.TreeNode;

/**
 * This class contains methods for encoding and decoding message.
 * 
 * @author Martina Balakova, 456595
 */
public class BinaryCodecImpl implements BinaryCodec {

    private final Encoding encoding;

    /**
     * @param encoding encoding to be used
     */
    public BinaryCodecImpl(Encoding encoding) {
        this.encoding = encoding;
    }

    @Override
    public String encode(String originalMessage) {
        StringBuilder builder = new StringBuilder("");
        for (char ch : originalMessage.toCharArray()) {
            builder.append(encoding.getEncodingString(ch));
        }
        return builder.toString();
    }

    @Override
    public String decode(String binaryMessage) {
        final TreeNode root = encoding.getRoot();
        TreeNode currentNode;
        StringBuilder builder = new StringBuilder("");

        int index = 0;
        currentNode = root;
        for (char ch : binaryMessage.toCharArray()) {
            currentNode = ch == '0' ? currentNode.getLeftChild()
                                    : currentNode.getRightChild();
            index++;
            if (currentNode.isLeaf()) {
                builder.append(currentNode.getCharacter());
                index = 0;
                currentNode = root;
            }

        }
        return builder.toString();
    }
}
