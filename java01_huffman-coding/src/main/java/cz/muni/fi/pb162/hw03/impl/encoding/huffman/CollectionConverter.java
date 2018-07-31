package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import cz.muni.fi.pb162.hw03.impl.encoding.node.LeafTreeNode;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Methods to convert collections
 *
 * @author Magdalena Kunikova
 */
public class CollectionConverter {
    
    /**
     * Converts symbol set to leaf node set
     * 
     * @param charSet set of symbols
     * @return leaf node set made from symbols
     */
    public static NavigableSet<TreeNode> charSetToLeafNodeSet(Set<SymbolFrequency> charSet) {
        NavigableSet<TreeNode> result = new TreeSet<>();
        for (SymbolFrequency symbol : charSet) {
            result.add(new LeafTreeNode(symbol));
        }
        return result;
    }
    
    /**
     * Converts node map to string map of binary representation
     * 
     * @param nodeMap node map to convert
     * @return map of binary representations of chars
     */
    public static Map<Character, String> nodeMapToEncodingMap(Map<TreeNode, String> nodeMap) {
        Map<Character, String> result = new TreeMap<>();
        for (Map.Entry<TreeNode, String> treeNode : nodeMap.entrySet()) {
            result.put(treeNode.getKey().getCharacter(), treeNode.getValue());
        }
        return result;
    }
}
