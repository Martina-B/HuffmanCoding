package cz.muni.fi.pb162.hw03.impl.comparator;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Comparator;

/**
 * Comparator of SymbolFrequency. it sorts elements primarily 
 * by frequency ascending and secondary in the reverse alphabetical order.
 * 
 * @author Martina Balakova, 456595
 */
public class SymbolFrequencyLetterInverseComparator implements Comparator<SymbolFrequency> {

    @Override
    public int compare(SymbolFrequency o1, SymbolFrequency o2) {
        int output = Integer.compare(o1.getFrequency(), o2.getFrequency());
        if (output != 0) return output;
        return Character.compare(o2.getCharacter(), o1.getCharacter());
    }
    
}
