package cz.muni.fi.pb162.hw03.impl;

/**
 * This class serves to store the character and its frequency.
 * 
 * @author Martina Balakova, 456595
 */
public class SymbolFrequency implements Comparable<SymbolFrequency> {
    
    private final char symbol;
    private final int frequency;
    
    /**
     * @param symbol character
     * @param frequency number of occurences of symbol
     */
    public SymbolFrequency(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SymbolFrequency)) return false;        
        SymbolFrequency other = (SymbolFrequency) o;
        return this.frequency == other.frequency && this.symbol == other.symbol;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(symbol) + Integer.hashCode(frequency);
    }
    
    /**
     * Getter of character.
     * @return character aka symbol in leaves of tree
     */
    public char getCharacter() {
        return symbol;
    }
    
    /**
     * Getter of frequency.
     * @return frequency 
     */
    public int getFrequency() {
        return frequency;
    }
    
    @Override
    public String toString() {
        return frequency + "x\'" + symbol + "\'";
    }

    @Override
    public int compareTo(SymbolFrequency o) {
        int output = Integer.compare(frequency, o.frequency);
        if (output != 0) return output;
        return Character.compare(symbol, o.symbol);
    }

}
