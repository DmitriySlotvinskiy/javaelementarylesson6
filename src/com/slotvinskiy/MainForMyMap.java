package com.slotvinskiy;

public class MainForMyMap {


    public static void main(String[] args) {


        MyMap myMap = new MyHashMap();
        //Наполнение до 20 элементов
        myMap.put("One", "1");
        myMap.put("Two", "2");
        myMap.put("Three", "3");
        myMap.put("Four", "4");
        myMap.put("Five", "5");
        myMap.put("Six", "6");
        myMap.put("Seven", "7");
        myMap.put("Eight", "8");
        myMap.put("Nine", "9");
        myMap.put("Ten", "10");
        myMap.put("Eleven", "11");
        myMap.put("Twelve", "12");
        myMap.put("Thirteen", "13");
        myMap.put("Fourteen", "14");
        myMap.put("Fifteen", "15");
        myMap.put("Sixteen", "16");
        myMap.put("Seventeen", "17");
        myMap.put("Eighteen", "18");
        myMap.put("Nineteen", "19");
        myMap.put("Twenty", "20");
        System.out.println(myMap);
        //Перезапись
        myMap.put("Six", "66");
        myMap.put("One", "111");
        myMap.put("Three", "333");
        System.out.println(myMap);
        //Удаление до 10ти элементов
        myMap.remove("Eleven");
        myMap.remove("Twelve");
        myMap.remove("Thirteen");
        myMap.remove("Fourteen");
        myMap.remove("Fifteen");
        myMap.remove("Sixteen");
        myMap.remove("Seventeen");
        myMap.remove("Eighteen");
        myMap.remove("Nineteen");
        myMap.remove("Twenty");
        System.out.println(myMap);

        if (myMap.containsKey("Ten")) {
            System.out.println(myMap.get("Ten"));
        }


    }

}

