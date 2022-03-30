package com.company;

import java.util.Arrays;

public class GenericList<T> {
    T[] myList;
    int defaultSize = 10;
    int capacity;
    int index = 0;
    int count;


    public GenericList(){
        this.myList = (T[]) new Object[defaultSize];
    }

    public GenericList(int capacity){
        this.capacity = capacity;
        this.myList = (T[]) new Object[capacity];
    }

    public int myListSize(){
        count = 0;
        for(int i = 0; i < this.myList.length; i++){
            if(myList[i] != null){
                count++;
            }
        }
        return count;
    }

    public int getCapacity(){
        return this.myList.length;
    }

    public void add(T data){
        if(this.index == this.myList.length){
            myList = Arrays.copyOf(this.myList, this.myList.length*2);
            addDataToList(data); // adding data which is when array length surpassed.
        }else{
            addDataToList(data);
        }
    }

    private void addDataToList(T data) {
        this.myList[this.index] = data;
        index++;
    }

    public T get(int index){
        validationOfIndex(index);
        return this.myList[index];
    }

    public void remove(int index){
        validationOfIndex(index);
        for (int i= index;i<=this.index-1;i++)
            this.myList[i]=this.myList[i+1];
        this.index--;
    }

    //List has this index or not
    private void validationOfIndex(int index) {
        if(index > this.myList.length){
            System.out.println("Index that was entered couldn't found!");
        }
    }

    public void set(int index, T data){
        if(index + 1 > this.myList.length){
            System.out.println("List was exceeded!");
        }else{
            this.myList[index] = data;
        }
    }

    public String toString(){
        StringBuilder array = new StringBuilder("[");
        if(this.myList.length > 0){
            for (T item : this.myList){
                if(item != null){
                    array.append(item).append(",");
                }
            }
        }
        if(array.length() > 1){
            array.deleteCharAt(array.length()-1).append("]");
        }
        else{
            array.append("]");
        }
        return array.toString();
    }

    public int indexOf(T data){
        for(int i = 0; i < this.myList.length; i++){
            if(this.myList[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexof(T data){
        int value=-1;
        for (int i =0;i< myList.length;i++){
            if (myList[i]==data){
                value=i;
            }
        }
        return value;
    }

    public boolean isEmpty(){
        return this.myList.length == 0;
    }

    public T[] toArray(){
        return Arrays.copyOfRange(this.myList, 0, this.myList.length);
    }

    public GenericList<T> sublist(int start, int finish){
        GenericList<T> genericList = new GenericList<>(finish - start + 1);
        for (int i=start;i<=finish;i++){
            genericList.add(myList[i]);
        }
        return genericList;
    }

    public boolean contain(T data){
        for(T item : this.myList){
            if(item == data){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        this.myList = (T[]) new Object[defaultSize];
    }

}
