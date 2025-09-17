package leetcode.daily_challenge.september_25.design_a_food_rating_system_17;

import java.util.*;

class MaxItemDS {
    private TreeMap<Integer, TreeSet<String>> valueToItem;
    private Map<String, Integer> itemToValue;
    public MaxItemDS() {
        valueToItem = new TreeMap<>();
        itemToValue = new HashMap<>();
    }
    public void addItem(String item, int value) {
        itemToValue.put(item, value);
        valueToItem.computeIfAbsent(value, k -> new TreeSet<>()).add(item);
    }
    public void updateValue(String item, int updatedValue) {
        Integer oldValue = itemToValue.get(item);
        valueToItem.get(oldValue).remove(item);
        if(valueToItem.get(oldValue).isEmpty()) {
            valueToItem.remove(oldValue);
        }
        valueToItem.computeIfAbsent(updatedValue, k -> new TreeSet<>()).add(item);
        itemToValue.put(item, updatedValue);
    }
    public String getHighest() {
        return valueToItem.lastEntry().getValue().iterator().next();
    }
}

public class FoodRatings {
    private Map<String, MaxItemDS> cuisineMap;
    private Map<String, String> foodMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();
        for(int i = 0; i < ratings.length; i++) {
            cuisineMap.computeIfAbsent(cuisines[i], k -> new MaxItemDS()).addItem(foods[i], ratings[i]);
            foodMap.put(foods[i], cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        cuisineMap.get(foodMap.get(food)).updateValue(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).getHighest();
    }
}