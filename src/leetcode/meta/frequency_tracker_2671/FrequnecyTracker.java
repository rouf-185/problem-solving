package leetcode.meta.frequency_tracker_2671;
import java.util.*;

public class FrequencyTracker {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Integer> numMap;
    public FrequencyTracker() {
        freqMap = new HashMap<>();
        numMap = new HashMap<>();
    }
    
    private void addNewFrequencyAgainstNumber(int newFreq, int number) {
        freqMap.put(newFreq, freqMap.getOrDefault(newFreq, 0) + 1);
        numMap.put(number, newFreq);
    }
    private void removeCurrentFrequencyAgainstNumber(int currentFreq, int number) {
        freqMap.put(currentFreq, freqMap.get(currentFreq) - 1);
        if(freqMap.get(currentFreq) == 0) {
            freqMap.remove(currentFreq);
        }
        if(currentFreq == 1) {
            numMap.remove(number);
        } else {
            numMap.put(number, currentFreq - 1);
        }
    }
    public void add(int number) {
        if(numMap.containsKey(number)) {
            int currentFreq = numMap.get(number);
            removeCurrentFrequencyAgainstNumber(currentFreq, number);
            addNewFrequencyAgainstNumber(currentFreq + 1, number);
        } else {
            addNewFrequencyAgainstNumber(1, number);
        }
    }
    
    public void deleteOne(int number) {
        if(!numMap.containsKey(number)) {
            return;
        }
        int currentFreq = numMap.get(number);
        removeCurrentFrequencyAgainstNumber(currentFreq, number);
        if(currentFreq == 1) {
            return;
        }
        addNewFrequencyAgainstNumber(currentFreq - 1, number);
    }
    
    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency);
    }
}
