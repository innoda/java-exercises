package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.HuffmanAlgorithm;
import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import cz.muni.fi.pb162.hw03.impl.comparator.SymbolFrequencyInverseComparator;
import cz.muni.fi.pb162.hw03.impl.encoding.node.InnerTreeNode;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class represents and runs huffman encoding.
 * Implements Encoding and HuffmanAlgorithm interfaces.
 * 
 * @author Magdalena Kunikova
 */
public final class HuffmanEncoding implements Encoding, HuffmanAlgorithm {
    
    private final TreeNode root;
    private final Map<TreeNode, String> nodeMap = new TreeMap<>();
    
    /**
     * Parametrized constructor.
     * Encoding is made within this constructor.
     * 
     * @param frequencyTable frequency table of characters
     */
    public HuffmanEncoding(FrequencyTable frequencyTable) {
        root = frequencyTableToTree(frequencyTable.createTable());
        createCodeTree(nodeMap, root, "");
    }
    
    @Override
    public String getEncodingString(char character) {
        Map<Character, String> charMap = CollectionConverter.nodeMapToEncodingMap(nodeMap);
        for(Map.Entry<Character, String> entry : charMap.entrySet()) {
            if (entry.getKey() == character) {
                return entry.getValue(); 
            }
        }
        return "";
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public TreeNode frequencyTableToTree(Set<SymbolFrequency> charSet) {
        // from lowest frequency to highest
        Set<SymbolFrequency> minFrequencySet = new TreeSet<>(new SymbolFrequencyInverseComparator());
        minFrequencySet.addAll(charSet);
        
        // converting to TreeSet, because it provides pollFirst() method
        Set<TreeNode> trees = CollectionConverter.charSetToLeafNodeSet(charSet);
        TreeSet<TreeNode> forest = new TreeSet<>(trees);
        
        while (forest.size() > 1) {
            TreeNode left = forest.pollFirst();
            TreeNode right = forest.pollFirst();
            forest.add(new InnerTreeNode(left, right));    
        }
        
        return forest.pollFirst();   
    }

    @Override
    public void createCodeTree(Map<TreeNode, String> nodeMap, TreeNode treeNode, String string) {
        if (!treeNode.isLeaf()) {
            createCodeTree(nodeMap, treeNode.getLeftChild(), string + '0');
            createCodeTree(nodeMap, treeNode.getRightChild(), string + '1');
        } else {
            nodeMap.put(treeNode, string);
        }
    }
}
