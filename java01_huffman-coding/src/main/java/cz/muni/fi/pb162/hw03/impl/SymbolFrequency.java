package cz.muni.fi.pb162.hw03.impl;

/**
 * This class represents a symbol in Huffmann coding
 * 
 * @author Magdalena Kunikova
 */
public class SymbolFrequency implements Comparable<SymbolFrequency> {
    private final char character;
    private final int frequency;
    
    /**
     * Parametrized constructor
     * 
     * @param codedChar character
     * @param frequency character frequency
     */
    public SymbolFrequency(char codedChar, int frequency) {
        this.character = codedChar;
        this.frequency = frequency;
    }
    
    @Override
    public int compareTo(SymbolFrequency object) {
        int diff = Double.compare(this.frequency, object.frequency);
        return ((diff != 0) ? diff : Double.compare(this.character, object.character));
    }

    @Override
    public String toString() {
        return (this.frequency + "x'" + character + "'");
    }
    
    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.character;
        hash = 17 * hash + this.frequency;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SymbolFrequency other = (SymbolFrequency) obj;
        if (this.character != other.character) {
            return false;
        }
        return this.frequency == other.frequency;
    } 
}
