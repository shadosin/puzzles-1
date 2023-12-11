package com.kenzie.gettingstarted.balance;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Drills to apply the problem-solving framework on variations of the Balanced Parentheses problem.
 */
public class BalancedParens {

    /**
     * Determine whether a string composed entirely of opening and closing parentheses is balanced.
     * If a closing paren appears without an opening paren, the string is not balanced.
     * If an opening paren is not closed by the end of the string, it is not balanced.
     *
     * BalancedParensTest includes some sample test cases.*
     *
     * @param parens A String of opening and closing parentheses
     * @return true if every opening and closing paren has a partner
     */
    public boolean areParensBalanced(String parens) {
        int count = 0;
        for(char c : parens.toCharArray()){
            if(c == '('){
                count ++;
            }
            if(c == ')'){
                count --;
            }

        }
        return count == 0;
    }

    /**
     * Placeholder for the we-do classroom activity for Problem-Solving Framework.
     *
     * BalancedParensTest includes some sample test cases.
     *
     * @param text A text String, described in the classroom.
     * @return True as described in the classroom, false otherwise.
     */
    public boolean areEnclosuresBalanced(String text) {
        Stack<Character> stack = new Stack<>();
        for(char c : text.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){

                if(stack.isEmpty()){
                    return false;
                }

                char check = stack.pop();
                if(c == ')' && !(check == '(')){
                    return false;
                }
                if(c == '}' && !(check == '{')){
                    return false;
                }
                if(c == ']' && !(check == '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Placeholder for the you-do classroom activity for Problem-Solving Framework.
     *
     * BalancedParensTest includes some sample test cases.
     *
     * @param text A text String, described in the classroom.
     * @return True as described in the classroom, false otherwise.
     */
    public boolean theSmileyMethod(String text) {
        Stack<Character> stack = new Stack<>();
        text = deleteSmileys(text);
        for (char c : text.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char check = stack.pop();
                    if (c == ')' && !(check == '(')) {
                        return false;
                    }
                    if (c == '}' && !(check == '{')) {
                        return false;
                    }
                    if (c == ']' && !(check == '[')) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
    private String deleteSmileys(String smiley) {
        return smiley.replaceAll("[:][\\]\\[\\}\\{\\(\\)]", " ");
    }



}
