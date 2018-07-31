package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a table of frequencies for characters
 * 
 * @author Magdalena Kunikova
 */
public class FrequencyTable {
    
    private final Map<Character, Integer> charFrequency;
    
    /**
     * Parametrized constructor.
     * Creates map of frequencies for string's characters.
     * 
     * @param string string to build a table of frequencies
     */
    public FrequencyTable(String string) {
        charFrequency = new HashMap<>();
        
        for (int i = 0; i < string.length(); i++) {
            if (!charFrequency.containsKey(string.charAt(i))) {
                charFrequency.put(string.charAt(i), 1);
            } else {
                int oldValue = charFrequency.get(string.charAt(i));
                charFrequency.replace(string.charAt(i), oldValue+1);
            }
        }
    }
    
    /**
     * Creates table (set) of characters and frequencies
     * 
     * @return table (set) of characters and frequencies
     */
    public Set<SymbolFrequency> createTable() {
        Set<SymbolFrequency> result = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            result.add(new SymbolFrequency(entry.getKey(), entry.getValue()));
        }
        return result;
    } 
}
