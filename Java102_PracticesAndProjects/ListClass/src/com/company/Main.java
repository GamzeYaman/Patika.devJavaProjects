package com.company;

public class Main {

    public static void main(String[] args) {

        GenericList<String> myList = new GenericList<>();
        System.out.println("Size of list : " + myList.myListSize());
        System.out.println("Capacity of list : " + myList.getCapacity());
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        System.out.println("Size of list : " + myList.myListSize());
        System.out.println("Capacity of list : " + myList.getCapacity());
        myList.add("F");
        myList.add("G");
        myList.add("H");
        myList.add("I");
        myList.add("J");
        myList.add("K");
        System.out.println("Size of list : " + myList.myListSize());
        System.out.println("Capacity of list : " + myList.getCapacity());
        System.out.println(myList.toString());

        //Removing Data
        System.out.println("---------------------------------------");
        System.out.println("The data at index 3 : " + myList.get(3));
        myList.remove(3);
        System.out.println("The data at index 3 : " + myList.get(3));
        System.out.println(myList.toString());

        //Setting new data to list
        System.out.println("---------------------------------------");
        System.out.println("The data at index 1 : " + myList.get(1));
        myList.set(1, "Y");
        System.out.println("The data at index 1 : " + myList.get(1));
        System.out.println(myList.toString());

        System.out.println("---------------------------------------");
        System.out.println("The list is empty  : " + myList.isEmpty());
        System.out.println("Index of C: " + myList.indexOf("C"));
        System.out.println("Index of H: " + myList.lastIndexof("H"));
        System.out.println("The list has data  : " + myList.contain("A"));

        Object[] list = myList.toArray();
        System.out.println("---------------------------------------");
        System.out.println("The data at index 1 of object list : " + myList.get(1));

        GenericList<String > subList = new GenericList<>();
        subList = myList.sublist(0,2);
        System.out.println("---------------------------------------");
        System.out.println("The sublist :" + subList.toString());


        myList.clear();
        System.out.println("---------------------------------------");
        System.out.println("My list : " + myList.toString());

    }
}
