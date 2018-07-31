package cz.muni.fi.pb162.hw03.impl;

import cz.muni.fi.pb162.hw03.BinaryCodec;
import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.TreeNode;

/**
 * Methods of this encode and decode message.
 * Implements BinaryCodec interface.
 * 
 * @author Magdalena Kunikova
 */
public class BinaryCodecImpl implements BinaryCodec {
    
    private final Encoding encoding;
    
    /**
     * Parametrized constructor
     * 
     * @param encoding type of encoding
     */
    public BinaryCodecImpl(Encoding encoding) {
        this.encoding = encoding;
    }

    @Override
    public String encode(String originalMessage) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < originalMessage.length(); i++) {
            output.append(encoding.getEncodingString(originalMessage.charAt(i)));
        }
        return output.toString();
    }

    @Override
    public String decode(String binaryMessage) {
        TreeNode root = encoding.getRoot();
        
        StringBuilder output = new StringBuilder();
        while (binaryMessage.length() != 0) {
            TreeNode node = root;
            while (!node.isLeaf()) {
                if (binaryMessage.charAt(0) == '0') {
                    node = node.getLeftChild();
                    binaryMessage = binaryMessage.substring(1);
                } else {
                    node = node.getRightChild();
                    binaryMessage = binaryMessage.substring(1);
                }
            }
            output.append(node.getCharacter());
        }
        return output.toString();
    } 
}
