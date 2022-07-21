package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> allNumbers = new ArrayList<>();

        for(int i = 0; i <= 100; i++){
            allNumbers.add(i);
        }

        List<Integer> numbers1 =  allNumbers.subList(0, 25);
        List<Integer> numbers2 = allNumbers.subList(25,50);
        List<Integer> numbers3 = allNumbers.subList(50,75);
        List<Integer> numbers4 = allNumbers.subList(75,100);


        ThreadsRace threadsRace1 = new ThreadsRace(numbers1);
        threadsRace1.start();

        ThreadsRace threadsRace2 = new ThreadsRace(numbers2);
        threadsRace2.start();

        ThreadsRace threadsRace3 = new ThreadsRace(numbers3);
        threadsRace3.start();

        ThreadsRace threadsRace4 = new ThreadsRace(numbers4);
        threadsRace4.start();

    }
}
