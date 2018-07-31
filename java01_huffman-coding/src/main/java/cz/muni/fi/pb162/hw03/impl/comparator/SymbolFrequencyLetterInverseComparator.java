package cz.muni.fi.pb162.hw03.impl.comparator;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Comparator;

/**
 * This class sorts from highest to lowest frequency and in inverse letter order
 * 
 * @author Magdalena Kunikova
 */
public class SymbolFrequencyLetterInverseComparator implements Comparator<SymbolFrequency> {

    @Override
    public int compare(SymbolFrequency o1, SymbolFrequency o2) {
        int diff = o1.getFrequency() - o2.getFrequency();
        return ((diff != 0) ? diff : (- Double.compare(o1.getCharacter(), o2.getCharacter()))); 
    } 
}
