package com.kenzie.gettingstarted.coins;

import java.util.*;

/**
 * Use this to explore solutions to the Pair-Sum interview problem.
 *
 * Kenzie uses a virtual currency, Kenzie Coins, in the Kenzie App Store. When I purchased a Kenzie App,
 * I received some Kenzie Coins. I've bought a few apps, but now I have a balance of 21 coins left
 * over, and it really bothers me.
 *
 * No one app costs 21 coins. But maybe I could find an app for 15 coins, and another app for 6 coins.
 *
 * Of course, this is a problem for many people, with many different balances. The balance isn't
 * always 21 coins, it could be anything.
 *
 * Write a method to help me zero out my balance with two apps.
 */
public class KenzieCoins {
    /*
       Notes: Just like in the guided classroom examples, if you change the name of these methods
       you must also update the KenzieCoinsTest in com.kenzie.gettingstarted.coins
     */

    /**
     * Determine *whether* any two values in the provided list adds up to the provided balance.
     *
     * The KenzieCoinsTest includes some sample data to check your solution.
     *
     * @param balance The balance to find a pair for.
     * @param values The values to search. Never null, contains no null values. May contain duplicates.
     * @return True if any two values sum to the provided balance, false otherwise.
     */
    public boolean anyPairSumsToBalance(int balance, List<Integer> values) {
        Set<Integer> knownPrices = new HashSet<>();
        for(int price : values){
            int pair = balance - price;
            if(knownPrices.contains(pair)){
                return true;
            }
            knownPrices.add(price);
        }
        return false;
    }

    /**
     * Find all the pairs of values that add up to the provided balance.
     *
     * The KenzieCoinsTest includes some sample data to check your solution.
     *
     * @param balance The balance to find a pair for.
     * @param values The values to search. Never null, contains no null values. May contain duplicates.
     * @return A list of pairs of numbers from `values` that sum to the `balance`.
     */
    public List<Pair> findPairsThatSumToBalance(int balance, List<Integer> values) {
        List<Pair> result = new ArrayList<>();

        Map<Integer, Integer> occurrence = new HashMap<>();
        for(int value : values){
            int pair = balance - value;
            if(occurrence.containsKey(pair)){
                for(int i = 0; i < occurrence.get(pair); i++){
                    result.add(new Pair(pair, value));
                }
            }
            occurrence.put(value, occurrence.getOrDefault(value, 0) +1);
        }


        return result;
    }

}
