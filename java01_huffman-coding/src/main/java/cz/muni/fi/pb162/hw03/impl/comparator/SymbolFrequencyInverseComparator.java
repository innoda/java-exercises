package cz.muni.fi.pb162.hw03.impl.comparator;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Comparator;

/**
 * This class sorts differently from natural ordering
 * 
 * @author Magdalena Kunikova
 */
public class SymbolFrequencyInverseComparator implements Comparator<SymbolFrequency> {

    @Override
    public int compare(SymbolFrequency o1, SymbolFrequency o2) {
        return - o1.compareTo(o2);
    }
}
