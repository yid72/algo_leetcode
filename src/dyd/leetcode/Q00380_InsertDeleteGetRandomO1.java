package dyd.leetcode;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1) -- Medium
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 * being returned.
 *
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class Q00380_InsertDeleteGetRandomO1 {
    private Map<Integer, Integer> indexes;
    private List<Integer> numbers;

    /** Initialize your data structure here. */
    public Q00380_InsertDeleteGetRandomO1() {
        indexes = new HashMap<>();
        numbers = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        numbers.add(val);
        indexes.put(val, numbers.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.get(val);
        indexes.remove(val);
        if (index < numbers.size() - 1) {
            int lastVal = numbers.get(numbers.size() - 1);
            numbers.set(index, lastVal);
            indexes.put(lastVal, index);
        }
        numbers.remove(numbers.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = (int) (Math.random() * numbers.size());
        return numbers.get(randomIndex);
    }

    public static void main(String[] args) {
        // Init an empty set.
        Q00380_InsertDeleteGetRandomO1 randomSet = new Q00380_InsertDeleteGetRandomO1();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}
