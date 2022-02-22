package com.vladarsenjtev;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String string1 = "Привет";
        String string2 = "тевПри";
        System.out.println(equals(string1, string2));
    }

    public static boolean equals(String s1, String s2) {
        return permutationFinder(s1).equals(permutationFinder(s2));
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
}