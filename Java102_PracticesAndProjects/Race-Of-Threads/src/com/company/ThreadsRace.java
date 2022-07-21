package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreadsRace extends Thread{

    private List<Integer> numbers = new ArrayList<>();
    private ArrayList<Integer> oddNumbers = new ArrayList<>();
    private ArrayList<Integer> evenNumbers = new ArrayList<>();

    public ThreadsRace(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public void run() {

        separateNumbers(numbers);

        printNumbers(Thread.currentThread().getName());
    }

    private synchronized void separateNumbers(List<Integer> numberList) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                evenNumbers.add(numbers.get(i));
            }else{
                oddNumbers.add(numbers.get(i));
            }
        }
    }

    public  void printNumbers(String threadName){
        System.out.println("Tek Sayılar : " + threadName +  this.oddNumbers);
        System.out.println("Çift Sayılar : " + threadName +  this.evenNumbers);
    }
}
