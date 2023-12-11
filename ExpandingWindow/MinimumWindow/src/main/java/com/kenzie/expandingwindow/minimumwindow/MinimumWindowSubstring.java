package com.kenzie.expandingwindow.minimumwindow;

/**
 * Contains a problem that can be solved using the Expanding Window Technique.
 */
public class MinimumWindowSubstring {

    /**
     * Given two strings s and t, return the minimum window substring of s such that every character in
     * t (including duplicates) is included in the window. If there is no such substring, return the
     * empty string "".
     *
     * Example:
     *   s = "ADOBECODEBANC"
     *   t = "ABC"
     *
     *   result = "BANC"
     *
     * @param s - the string from which to identify the shortest substring where each character in t appears.
     * @param t - the string containing all the characters that must appear in the substring from s.
     * @return the shortest substring of s in which each character in t appears.
     */
    public static String minimumWindowSubstring(String s, String t) {


        int[] frequency = new int[128];
        int requiredChars = t.length();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;


        for (char c : t.toCharArray()) {
            frequency[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);


            if (frequency[rightChar] > 0) {
                requiredChars--;
            }

            frequency[rightChar]--;


            while (requiredChars == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }


                char leftChar = s.charAt(left);
                frequency[leftChar]++;
                if (frequency[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minLeft, minLeft + minLength + 1);
        }
    }
}
