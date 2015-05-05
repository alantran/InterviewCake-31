package com.InterviewCake;

import java.util.*;

/**
 * Created by atran on 5/3/15.
 */
public class Permutation {
    public static void main(String[] args) {
        //String input = "abc";
        //perm1("", input);
        System.out.println(Permutation("abc"));
    }

    public static List<String> Permutation(String input) {
        List<String> permutations = new ArrayList<String>();
        if (input.length() == 1) {
            permutations.add(input);
            return permutations;
        } else {
            char first = input.charAt(0);
            String remainder = input.substring(1);
            List<String> words = Permutation(remainder);
            for (String word : words) {
                for (int j = 0; j <= word.length(); j++) {
                    String s = insertCharAt(word, first, j);
                    permutations.add(s);
                }
            }
            return permutations;
        }
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start + c + end;
    }


    // Princeton solution
    public static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }

}
