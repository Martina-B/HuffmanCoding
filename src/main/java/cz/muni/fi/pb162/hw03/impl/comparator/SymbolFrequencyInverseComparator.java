package cz.muni.fi.pb162.hw03.impl.comparator;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.Comparator;

/**
 * Comparator of SymbolFrequency. Aligns the elements in the reverse order
 * of the natural arrangement.
 * 
 * @author Martina Balakova, 456595
 */
public class SymbolFrequencyInverseComparator implements Comparator<SymbolFrequency> {

    @Override
    public int compare(SymbolFrequency o1, SymbolFrequency o2) {
        int output = Integer.compare(o2.getFrequency(), o1.getFrequency());
        if (output != 0) return output;
        return Character.compare(o2.getCharacter(), o1.getCharacter());
    }
    
}
