package com.kenzie.expandingwindow.krepeatingelements;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains a problem that can be solved using the Expanding Window Technique.
 */
public class KRepeatingElements {

    /**
     * Given a string s and an integer k, return the length of the longest substring of s such that the
     * frequency of each character in this substring is greater than or equal to k.
     *
     * Example:
     *   s = aaabb
     *   k = 3
     *
     *   result = aaa
     *
     * @param s - the string from which to identify the longest substring where each character appears
     *          at least k times. s will contain only lowercase letters.
     * @param k - the minimum frequency which each character should appear in the substring. k will be
     *          a postive number.
     * @return the length of the longest substring of s where each character appears at least k times.
     */
    public static int kRepeatingElements(String s, int k) {
        int max = 0;
        for(int character =1; character <= 26; character ++){
            int[] counter = new int[26];
            int start = 0;
            int end = 0;
            int current = 0;
            int atLeastK = 0;

            while(end < s.length()){
                int endIndex = s.charAt(end) - 'a';
                if(counter[endIndex] == 0) current ++;
                counter[endIndex]++;
                if(counter[endIndex] == k) atLeastK ++;
                end ++;

                while(current > character){
                    int startIndex = s.charAt(start) -'a';
                    if(counter[startIndex] == k) atLeastK --;
                    counter[startIndex] --;
                    if(counter[startIndex] == 0) current --;
                    start ++;
                }
                if(current == character && current == atLeastK){
                    max = Math.max(max, end - start);
                }
            }
        }
        return max;
    }
}
