
package com.slotvinskiy;

import java.util.Arrays;

public class MainForMySet {


    public static void main(String[] args) {


        MySet mySet = new MyHashSet();
        //Наполнение до 20 элементов
        mySet.add("One");
        mySet.add("Two");
        mySet.add("Three");
        mySet.add("Four");
        mySet.add("Five");
        mySet.add("Six");
        mySet.add("Seven");
        mySet.add("Eight");
        mySet.add("Nine");
        mySet.add("Ten");
        mySet.add("Eleven");
        mySet.add("Twelve");
        mySet.add("Thirteen");
        mySet.add("Fourteen");
        mySet.add("Fifteen");
        mySet.add("Sixteen");
        mySet.add("Seventeen");
        mySet.add("Eighteen");
        mySet.add("Nineteen");
        mySet.add("Twenty");
        System.out.println(mySet);
        //Перезапись - попытка
        mySet.add("Six");
        mySet.add("One");
        mySet.add("Three");
        System.out.println(mySet);
        //Удаление до 10ти элементов
        mySet.remove("Eleven");
        mySet.remove("Twelve");
        mySet.remove("Thirteen");
        mySet.remove("Fourteen");
        mySet.remove("Fifteen");
        mySet.remove("Sixteen");
        mySet.remove("Seventeen");
        mySet.remove("Eighteen");
        mySet.remove("Nineteen");
        mySet.remove("Twenty");
        System.out.println(mySet);
        System.out.println("Is set empty - " + mySet.isEmpty() + ", size is - " + mySet.size());
        if (mySet.contains("Ten")) {
            System.out.println("true");
        }
        mySet.clear();
        System.out.println("Is set empty - " + mySet.isEmpty() + ", size is - " + mySet.size());

    }

}
