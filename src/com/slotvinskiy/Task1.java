package com.slotvinskiy;

//1) Написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются. Если строки разной длины то вернуть -1.
//Примеры:
//a="asdf", b="qwerty" => -1
//a="abb", b="bba" => 0
//a="abc", b="dca" => 1
//a="aaa", b="fga" => 2
//a="abc", b="dfg" => 3

import java.util.HashSet;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dca";
        int differencesNumber = findDifferences(s1, s2);
        System.out.println(differencesNumber);
    }

    private static int findDifferences(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        stringToCharSet(set1, s1); // не нашел стандартного решения преобразовать char[] в Set<Character>
        stringToCharSet(set2, s2);
        if (set1.size() < set2.size()) {
            set2.removeAll(set1);
            return set2.size();
        }
        set1.removeAll(set2);
        return set1.size();
    }

    private static void stringToCharSet(Set<Character> set, String s) {
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
    }
}
