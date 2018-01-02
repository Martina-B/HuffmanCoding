package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class represents table of frequencies of individual characters. It's 0. step
 * of Huffman algorithm.
 * 
 * @author Martina Balakova, 456595
 */
public class FrequencyTable {
    
    private final String message;
    
    /**
     * @param message message from which to get frequencies
     */
    public FrequencyTable(String message) {
        this.message = message;
    }
    
    /**
     * Takes a message and finds the number of occurrences of each character.
     * 
     * @return table (map) which contains SymbolFrequency
     */
    public Set<SymbolFrequency> createTable() {
        Map<Character, Integer> mapOfFrequencies = new HashMap<>();
        for (char ch : message.toCharArray()) {
            mapOfFrequencies.put(ch, mapOfFrequencies.containsKey(ch) ? mapOfFrequencies.get(ch) + 1 : 1);
        }
        SortedSet<SymbolFrequency> tableOfFrequencies = new TreeSet<>();
        for (Map.Entry<Character, Integer> entry : mapOfFrequencies.entrySet()) {
            tableOfFrequencies.add(new SymbolFrequency(entry.getKey(), entry.getValue()));
        }
        return tableOfFrequencies;
    }
}
